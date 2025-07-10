package cn.elitecode.module.system.service.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictTypeDO;

/**
* 字典类型表(system_dict_type) | 业务层
*/
public interface DictTypeService {

    /**
     * 新增字典类型
     * @param addReqVO
     * @return
     */
    Long addDictType(DictTypeAddReqVO addReqVO);

    /**
     * 批量删除字典类型
     * @param ids
     */
    void removeDictTypeByIds(Long[] ids);

    /**
     * 根据id更新字典类型信息
     * @param updateReqVO
     */
    void updateDictType(DictTypeUpdateReqVO updateReqVO);

    /**
     * 获取字典类型分页列表
     * @param pageReqVO
     * @return
     */
    CommonPage<DictTypeDO> getDictTypePage(DictTypePageReqVO pageReqVO);

    /**
     * 根据id查询字典类型信息
     * @param id
     * @return
     */
    DictTypeDO getDictType(Long id);
}
