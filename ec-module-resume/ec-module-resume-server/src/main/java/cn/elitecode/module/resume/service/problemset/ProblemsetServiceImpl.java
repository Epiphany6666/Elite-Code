package cn.elitecode.module.resume.service.problemset;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import cn.elitecode.module.resume.dal.mysql.problemset.ProblemsetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* resume_problemset(题库表) | 业务处理层
*/
@Service
public class ProblemsetServiceImpl implements ProblemsetService{

    private static final Logger log = LoggerFactory.getLogger(ProblemsetServiceImpl.class);

    @Autowired
    private ProblemsetMapper problemsetMapper;

    @Override
    public Long addProblemset(ProblemsetDO problemsetDO) {
        problemsetMapper.insertProblemset(problemsetDO);
        return problemsetDO.getId();
    }

    @Override
    public void removeByProblemsetIds(Long[] problemsetIds) {
        problemsetMapper.deleteProblemsetByIds(problemsetIds);
    }

    @Override
    public void updateProblemset(ProblemsetDO problemsetDO) {
        problemsetMapper.updateProblemsetById(problemsetDO);
    }

    @Override
    public CommonPage<ProblemsetDO> selectProblemsetList(ProblemsetQueryReqVO problemsetQueryReqVO) {
        if (problemsetQueryReqVO.getCurrent() != null && problemsetQueryReqVO.getPageSize() != null) {
            problemsetQueryReqVO.setCurrent((problemsetQueryReqVO.getCurrent() - 1) * problemsetQueryReqVO.getPageSize());
        }
        List<ProblemsetDO> problemsetDOList = problemsetMapper.selectProblemsetList(problemsetQueryReqVO);
        Long total = problemsetMapper.getTotal(problemsetQueryReqVO);
        CommonPage<ProblemsetDO> page = new CommonPage<>(total, problemsetDOList);
        return page;
    }

    @Override
    public List<ProblemsetDO> selectProblemsetAll() {
        return problemsetMapper.selectProblemsetAll();
    }

    @Override
    public ProblemsetDO selectProblemsetId(Long problemsetId) {
        ProblemsetDO problemsetDO = problemsetMapper.selectProblemsetById(problemsetId);
        return problemsetDO;
    }

}




