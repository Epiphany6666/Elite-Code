package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.question.QuestionQueryDTO;
import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;
import cn.elitecode.strategy.SearchStrategy;
import cn.hutool.core.util.StrUtil;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EsQuestionServiceImpl implements SearchStrategy {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public CommonPage<QuestionSearchDTO> selectQuestionList(QuestionQueryDTO questionQueryDTO) {
        PageRequest pageRequest = getPageRequest(questionQueryDTO);
        String title = questionQueryDTO.getTitle();
        CommonPage<QuestionSearchDTO> questionCommonPage = search(buildQuery(title, pageRequest));
        return questionCommonPage;
    }

    /**
     * 构建查询条件
     * @param title
     * @param pageRequest
     * @return
     */
    private NativeSearchQueryBuilder buildQuery(String title, PageRequest pageRequest) {
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (StrUtil.isNotEmpty(title)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("title", title));
        }
        boolQueryBuilder.must(QueryBuilders.matchQuery("delFlag", 0));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withPageable(pageRequest);
        return nativeSearchQueryBuilder;
    }

    /**
     * 查询并处理查询结果
     * @param nativeSearchQueryBuilder
     * @return
     */
    private CommonPage<QuestionSearchDTO> search(NativeSearchQueryBuilder nativeSearchQueryBuilder) {
        SearchHits<QuestionSearchDTO> search = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), QuestionSearchDTO.class);
        List<QuestionSearchDTO> questionList = search.getSearchHits().stream().map(item -> item.getContent()).collect(Collectors.toList());
        long total = search.getTotalHits();
        CommonPage<QuestionSearchDTO> questionCommonPage = new CommonPage<>(total, questionList);
        return questionCommonPage;
    }

    /**
     * 自定义的PageRequest转换成Spring的PageRequest
     * @param questionQueryDTO
     * @return
     */
    private PageRequest getPageRequest(QuestionQueryDTO questionQueryDTO) {
        int current = questionQueryDTO.getCurrent() - 1;
        int pageSize = questionQueryDTO.getPageSize();
        List<String> sortFieldPair = questionQueryDTO.getSortFieldPair();
        List<Sort.Order> orders = new ArrayList<>();
        if (sortFieldPair != null && sortFieldPair.size() > 0) {
            for (String sortField : sortFieldPair) {
                String[] split = sortField.split("\\s");
                if (split.length == 2) {
                    Sort.Direction direction = Sort.Direction.DESC;
                    if ("asc".equalsIgnoreCase(split[1])) {
                        direction = Sort.Direction.ASC;
                    }
                    orders.add(new Sort.Order(direction, split[0]));
                }
            }
        }
        PageRequest pageRequest = PageRequest.of(current, pageSize, Sort.by(orders));
        return pageRequest;
    }
}
