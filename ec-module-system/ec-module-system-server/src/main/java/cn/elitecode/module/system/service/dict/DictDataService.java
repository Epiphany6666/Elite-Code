package cn.elitecode.module.system.service.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataPageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictDataDO;

import java.util.List;

/**
* 字典数据表(system_dict_data) | 业务层
*/
public interface DictDataService {

    /**
     * 新增字典数据
     * @param addReqVO
     * @return
     */
    Long addDictData(DictDataAddReqVO addReqVO);

    /**
     * 批量删除字典数据
     * @param ids
     */
    void removeDictDataByIds(Long[] ids);

    /**
     * 根据id更新字典数据信息
     * @param updateReqVO
     */
    void updateDictData(DictDataUpdateReqVO updateReqVO);

    /**
     * 获取字典数据列表
     * @return
     */
    List<DictDataDO> getDictDataList();

    /**
     * 获取字典数据分页列表
     * @param pageReqVO
     * @return
     */
    CommonPage<DictDataDO> getDictDataPage(DictDataPageReqVO pageReqVO);

    /**
     * 根据id查询字典数据信息
     * @param id
     * @return
     */
    DictDataDO getDictData(Long id);
}
