package elitecode.module.resume;

import cn.elitecode.ECServerApplication;
import cn.elitecode.module.resume.dal.dataobject.question.QuestionDO;
import cn.elitecode.module.resume.dal.mysql.question.EsQuestionMapper;
import cn.elitecode.module.resume.dal.mysql.question.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest(classes = ECServerApplication.class)
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
        List<QuestionDO> allQuestionDOList = questionMapper.getAllQuestionList();
        esQuestionMapper.saveAll(allQuestionDOList.stream().map(item -> {
            QuestionDO questionDO = new QuestionDO();
            BeanUtils.copyProperties(item, questionDO);
            return questionDO;
        }).collect(Collectors.toList()));
    }
}
