package cn.elitecode.mapper;

import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsQuestionMapper extends ElasticsearchRepository<QuestionSearchDTO, String> {
}
