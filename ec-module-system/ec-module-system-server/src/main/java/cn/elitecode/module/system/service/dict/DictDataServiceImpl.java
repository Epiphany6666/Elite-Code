package cn.elitecode.module.system.service.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataPageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictDataDO;
import cn.elitecode.module.system.dal.mysql.dict.DictDataMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 字典数据表(system_dict_data) | 业务处理层
*/
@Service
public class DictDataServiceImpl implements DictDataService {

    @Autowired
    private DictDataMapper dictDataMapper;

    @Override
    public Long addDictData(DictDataAddReqVO addReqVO) {
        // 插入字典数据信息
        DictDataDO dictDataDO = new DictDataDO();
        BeanUtils.copyProperties(addReqVO, dictDataDO);
        dictDataDO.setCreateBy(SecurityUtil.getUserId());
        dictDataDO.setUpdateBy(SecurityUtil.getUserId());
        dictDataMapper.insertDictData(dictDataDO);
        return dictDataDO.getId();
    }

    @Override
    public void removeDictDataByIds(Long[] ids) {
        dictDataMapper.deleteDictDataByIds(ids);
    }

    @Override
    public void updateDictData(DictDataUpdateReqVO updateReqVO) {
        // 更新字典数据
        DictDataDO dictDataDO = new DictDataDO();
        BeanUtils.copyProperties(updateReqVO, dictDataDO);
        dictDataDO.setUpdateBy(SecurityUtil.getUserId());
        dictDataMapper.updateDictDataById(dictDataDO);
    }

    @Override
    public List<DictDataDO> getDictDataList() {
        List<DictDataDO> doList = dictDataMapper.selectDictDataList();
        return doList;
    }

    @Override
    public CommonPage<DictDataDO> getDictDataPage(DictDataPageReqVO pageReqVO) {
        // 组装分页条件
        if (pageReqVO.getCurrent() != null && pageReqVO.getPageSize() != null) {
            pageReqVO.setCurrent((pageReqVO.getCurrent() - 1) * pageReqVO.getPageSize());
        }
        // 获取字典数据分页列表
        List<DictDataDO> DOList = dictDataMapper.selectDictDataPage(pageReqVO);
        // 封装返回结果
        Long total = dictDataMapper.getTotalPage(pageReqVO);
        CommonPage<DictDataDO> DOCommonPage = new CommonPage<>(total, DOList);
        return DOCommonPage;
    }

    @Override
    public DictDataDO getDictData(Long id) {
        DictDataDO dictDataDO = dictDataMapper.selectDictDataById(id);
        return dictDataDO;
    }
}




