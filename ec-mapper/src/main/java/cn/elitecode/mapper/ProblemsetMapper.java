package cn.elitecode.mapper;

import cn.elitecode.model.dto.problemset.ProblemsetQueryDTO;
import cn.elitecode.model.entity.Problemset;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* problemset(题库表)
*/
public interface ProblemsetMapper {

    /**
     * 插入题库
     * @param problemset
     * @return
     */
    int insertProblemset(Problemset problemset);

    /**
     * 根据id数组批量删除题库
     * @param problemsetIds
     * @return
     */
    int deleteProblemsetByIds(@Param("problemsetIds") Long[] problemsetIds);

    /**
     * 根据id修改题库信息
     * @param problemset
     * @return
     */
    int updateProblemsetById(Problemset problemset);

    /**
     * 根据分页条件查询题库列表
     * @param problemsetQueryDTO
     * @return
     */
    List<Problemset> selectProblemsetList(ProblemsetQueryDTO problemsetQueryDTO);

    /**
     * 根据分页条件获取题库数量
     * @param problemsetQueryDTO
     * @return
     */
    Long getTotal(ProblemsetQueryDTO problemsetQueryDTO);

    /**
     * 查询所有题库
     * @return
     */
    List<Problemset> selectProblemsetAll();

}




