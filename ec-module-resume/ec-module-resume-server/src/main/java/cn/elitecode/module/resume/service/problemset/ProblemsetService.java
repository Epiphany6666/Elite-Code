package cn.elitecode.module.resume.service.problemset;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;

import java.util.List;

/**
* resume_problemset(题库表) | 业务层
*/
public interface ProblemsetService {

    /**
     * 新增题库
     * @param problemsetDO
     * @return
     */
    Long addProblemset(ProblemsetDO problemsetDO);

    /**
     * 批量删除题库
     * @param problemsetIds 需要删除的题库id数组
     */
    void removeByProblemsetIds(Long[] problemsetIds);

    /**
     * 根据id修改题库信息
     * @param problemsetDO
     */
    void updateProblemset(ProblemsetDO problemsetDO);

    /**
     * 根据分页条件查询题库列表
     * @param problemsetQueryReqVO
     * @return
     */
    CommonPage<ProblemsetDO> selectProblemsetList(ProblemsetQueryReqVO problemsetQueryReqVO);

    /**
     * 查询所有题库
     * @return
     */
    List<ProblemsetDO> selectProblemsetAll();

    /**
     * 根据id查询题库
     * @param problemsetId
     * @return
     */
    ProblemsetDO selectProblemsetId(Long problemsetId);
}
