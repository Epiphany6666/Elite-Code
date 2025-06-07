package cn.elitecode;

import cn.elitecode.mapper.EsQuestionMapper;
import cn.elitecode.mapper.QuestionMapper;
import cn.elitecode.model.dto.elasticsearch.QuestionSearchDTO;
import cn.elitecode.model.entity.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class EliteCodeApplicationTests {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private EsQuestionMapper esQuestionMapper;

    /**
     * 将MySql中的数据全部存入ES
     */
    @Test
    public void testImportAllMySqlToES() {
        List<Question> allQuestionList = questionMapper.getAllQuestionList();
        esQuestionMapper.saveAll(allQuestionList.stream().map(item -> {
            QuestionSearchDTO questionSearchDTO = new QuestionSearchDTO();
            BeanUtils.copyProperties(item, questionSearchDTO);
            return questionSearchDTO;
        }).collect(Collectors.toList()));
    }
}
