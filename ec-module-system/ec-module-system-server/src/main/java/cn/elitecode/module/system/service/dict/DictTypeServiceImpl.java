package cn.elitecode.module.system.service.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictTypeDO;
import cn.elitecode.module.system.dal.mysql.dict.DictTypeMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 字典类型表(system_dict_type) | 业务处理层
*/
@Service
public class DictTypeServiceImpl implements DictTypeService{

    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Override
    public Long addDictType(DictTypeAddReqVO addReqVO) {
        // TODO：校验字典类型的名字的唯一性
        // TODO：校验字典类型的类型的唯一性
        DictTypeDO dictTypeDO = new DictTypeDO();
        BeanUtils.copyProperties(addReqVO, dictTypeDO);
        dictTypeDO.setCreateBy(SecurityUtil.getUserId());
        dictTypeDO.setUpdateBy(SecurityUtil.getUserId());

        // 插入字典类型
        dictTypeMapper.insertDictType(dictTypeDO);
        return dictTypeDO.getId();
    }

    @Override
    public void removeDictTypeByIds(Long[] ids) {
        // TODO：校验ids是否为空

        // 删除字典类型
        dictTypeMapper.deleteDictTypeByIds(ids);
    }

    @Override
    public void updateDictType(DictTypeUpdateReqVO updateReqVO) {
        // TODO：校验自己存在
        // TODO：校验字典类型的名字的唯一性
        // TODO：校验字典类型的类型的唯一性
        DictTypeDO dictTypeDO = new DictTypeDO();

        // 更新字典类型
        BeanUtils.copyProperties(updateReqVO, dictTypeDO);
        dictTypeDO.setUpdateBy(SecurityUtil.getUserId());
        dictTypeMapper.updateDictTypeById(dictTypeDO);
    }

    @Override
    public CommonPage<DictTypeDO> getDictTypePage(DictTypePageReqVO pageReqVO) {
        // 将current设置为分页用的起始索引
        if (pageReqVO.getCurrent() != null && pageReqVO.getPageSize() != null) {
            pageReqVO.setCurrent((pageReqVO.getCurrent() - 1) * pageReqVO.getPageSize());
        }

        // 获取字典类型分页信息
        List<DictTypeDO> dictTypeDOList = dictTypeMapper.selectDictTypePage(pageReqVO);
        Long total = dictTypeMapper.selectDictTypeTotalPage(pageReqVO);
        CommonPage<DictTypeDO> dictTypeDOCommonPage = new CommonPage<>(total, dictTypeDOList);
        return dictTypeDOCommonPage;
    }

    @Override
    public DictTypeDO getDictType(Long id) {
        DictTypeDO dictTypeDO = dictTypeMapper.selectDictTypeById(id);
        return dictTypeDO;
    }
}




