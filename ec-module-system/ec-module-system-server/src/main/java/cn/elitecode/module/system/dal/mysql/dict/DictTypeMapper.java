package cn.elitecode.module.system.dal.mysql.dict;

import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictTypeDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* 字典类型表(system_dict_type) | 数据层
*/
@Mapper
public interface DictTypeMapper {

    /**
     * 插入字典类型
     * @param dictTypeDO
     */
    void insertDictType(DictTypeDO dictTypeDO);

    /**
     * 批量删除字典类型
     * @param ids
     */
    void deleteDictTypeByIds(@Param("ids") Long[] ids);

    /**
     * 根据id动态更新字典类型信息
     * @param dictTypeDO
     */
    void updateDictTypeById(DictTypeDO dictTypeDO);

    /**
     * 获取字典类型分页列表
     * @param pageReqVO
     */
    List<DictTypeDO> selectDictTypePage(DictTypePageReqVO pageReqVO);

    /**
     * 获取字典类型分页总数量
     * @param pageReqVO
     * @return
     */
    Long selectDictTypeTotalPage(DictTypePageReqVO pageReqVO);

    /**
     * 根据id查询字典类型信息
     * @param id
     */
    DictTypeDO selectDictTypeById(Long id);
}




