package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.problemset.ProblemsetQueryDTO;
import cn.elitecode.model.entity.Problemset;

/**
* problemset(题库表) | 业务层
*/
public interface ProblemsetService {

    /**
     * 新增题库
     * @param problemset
     * @return
     */
    Long addProblemset(Problemset problemset);

    /**
     * 批量删除题库
     * @param problemsetIds 需要删除的题库id数组
     */
    void removeByProblemsetIds(Long[] problemsetIds);

    /**
     * 根据id修改题库信息
     * @param problemset
     */
    void updateProblemset(Problemset problemset);

    /**
     * 根据分页条件查询题库列表
     * @param problemsetQueryDTO
     * @return
     */
    CommonPage<Problemset> selectProblemsetList(ProblemsetQueryDTO problemsetQueryDTO);

}
