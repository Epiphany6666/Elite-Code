package cn.elitecode.module.resume.dal.mysql.question;

import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsQuestionMapper extends ElasticsearchRepository<QuestionDO, String> {
}
