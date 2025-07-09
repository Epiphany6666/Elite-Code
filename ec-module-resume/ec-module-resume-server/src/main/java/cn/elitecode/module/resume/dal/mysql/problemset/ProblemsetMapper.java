package cn.elitecode.module.resume.dal.mysql.problemset;

import cn.elitecode.module.resume.controller.admin.problemset.vo.ProblemsetQueryReqVO;
import cn.elitecode.module.resume.dal.dataobject.problemset.ProblemsetDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* resume_problemset(题库表)
*/
@Mapper
public interface ProblemsetMapper {

    /**
     * 插入题库
     * @param problemsetDO
     * @return
     */
    int insertProblemset(ProblemsetDO problemsetDO);

    /**
     * 根据id数组批量删除题库
     * @param problemsetIds
     * @return
     */
    int deleteProblemsetByIds(@Param("problemsetIds") Long[] problemsetIds);

    /**
     * 根据id修改题库信息
     * @param problemsetDO
     * @return
     */
    int updateProblemsetById(ProblemsetDO problemsetDO);

    /**
     * 根据分页条件查询题库列表
     * @param problemsetQueryReqVO
     * @return
     */
    List<ProblemsetDO> selectProblemsetList(ProblemsetQueryReqVO problemsetQueryReqVO);

    /**
     * 根据分页条件获取题库数量
     * @param problemsetQueryReqVO
     * @return
     */
    Long getTotal(ProblemsetQueryReqVO problemsetQueryReqVO);

    /**
     * 查询所有题库
     * @return
     */
    List<ProblemsetDO> selectProblemsetAll();

    /**
     * 根据id查询题库信息
     * @param problemsetId
     * @return
     */
    ProblemsetDO selectProblemsetById(Long problemsetId);
}




