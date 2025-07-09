package cn.elitecode.module.resume.dal.mysql.question;

import cn.elitecode.module.resume.controller.admin.question.vo.QuestionSearchDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsQuestionMapper extends ElasticsearchRepository<QuestionSearchDTO, String> {
}
