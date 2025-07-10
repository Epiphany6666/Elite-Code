package cn.elitecode.module.system.dal.mysql.dict;

import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataPageReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictDataDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 字典数据表(system_dict_data) | 数据层
*/
@Mapper
public interface DictDataMapper {

    /**
     * 插入字典数据
     * @param dictDataDO
     */
    void insertDictData(DictDataDO dictDataDO);

    /**
     * 批量删除字典数据
     * @param ids
     */
    void deleteDictDataByIds(@Param("ids") Long[] ids);

    /**
     * 根据id修改字典数据信息
     * @param dictDataDO
     */
    void updateDictDataById(DictDataDO dictDataDO);

    /**
     * 获取字典数据列表
     * @return
     */
    List<DictDataDO> selectDictDataList();

    /**
     * 获取字典数据分页列表
     * @param pageReqVO
     * @return
     */
    List<DictDataDO> selectDictDataPage(DictDataPageReqVO pageReqVO);

    /**
     * 获取字典数据分页总数量
     * @param pageReqVO
     * @return
     */
    Long getTotalPage(DictDataPageReqVO pageReqVO);

    /**
     * 根据id查询字典数据信息
     * @param id
     * @return
     */
    DictDataDO selectDictDataById(Long id);
}




