package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.mapper.ProblemsetMapper;
import cn.elitecode.model.dto.problemset.ProblemsetQueryDTO;
import cn.elitecode.model.entity.Problemset;
import cn.elitecode.service.ProblemsetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* problemset(题库表) | 业务处理层
*/
@Service
public class ProblemsetServiceImpl implements ProblemsetService{

    private static final Logger log = LoggerFactory.getLogger(ProblemsetServiceImpl.class);

    @Autowired
    private ProblemsetMapper problemsetMapper;

    @Override
    public Long addProblemset(Problemset problemset) {
        problemsetMapper.insertProblemset(problemset);
        return problemset.getId();
    }

    @Override
    public void removeByProblemsetIds(Long[] problemsetIds) {
        problemsetMapper.deleteProblemsetByIds(problemsetIds);
    }

    @Override
    public void updateProblemset(Problemset problemset) {
        problemsetMapper.updateProblemsetById(problemset);
    }

    @Override
    public CommonPage<Problemset> selectProblemsetList(ProblemsetQueryDTO problemsetQueryDTO) {
        if (problemsetQueryDTO.getCurrent() != null && problemsetQueryDTO.getPageSize() != null) {
            problemsetQueryDTO.setCurrent((problemsetQueryDTO.getCurrent() - 1) * problemsetQueryDTO.getPageSize());
        }
        List<Problemset> problemsetList = problemsetMapper.selectProblemsetList(problemsetQueryDTO);
        Long total = problemsetMapper.getTotal(problemsetQueryDTO);
        CommonPage<Problemset> page = new CommonPage<>(total, problemsetList);
        return page;
    }

    @Override
    public List<Problemset> selectProblemsetAll() {
        return problemsetMapper.selectProblemsetAll();
    }

    @Override
    public Problemset selectProblemsetId(Long problemsetId) {
        Problemset problemset = problemsetMapper.selectProblemsetById(problemsetId);
        return problemset;
    }

}




