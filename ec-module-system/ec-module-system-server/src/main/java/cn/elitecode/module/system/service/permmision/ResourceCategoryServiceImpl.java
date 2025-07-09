package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceCategory;
import cn.elitecode.module.system.dal.mysql.permmison.ResourceCategoryMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public Long addResourceCategory(ResourceCategoryAddReqVO resourceCategoryAddReqVO) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(resourceCategoryAddReqVO, resourceCategory);
        resourceCategory.setCreateBy(SecurityUtil.getUserId());
        resourceCategoryMapper.insertResourceCategory(resourceCategory);
        return resourceCategory.getId();
    }

    @Override
    public void removeByResourceCategoryIds(Long[] resourceCategoryIds) {
        resourceCategoryMapper.deleteResourceCategoryByIds(resourceCategoryIds);
    }

    @Override
    public void updateResourceCategoryById(ResourceCategoryUpdateReqVO resourceCategoryUpdateReqVO) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(resourceCategoryUpdateReqVO, resourceCategory);
        resourceCategory.setUpdateBy(SecurityUtil.getUserId());
        resourceCategoryMapper.updateResourceCategoryById(resourceCategory);
    }

    @Override
    public List<ResourceCategory> selectResourceCategoryAll() {
        List<ResourceCategory> resourceCategoryList = resourceCategoryMapper.selectResourceCategoryListAll();
        return resourceCategoryList;
    }

    @Override
    public ResourceCategory selectResourceCategoryById(Long resourceCategoryId) {
        ResourceCategory resourceCategory = resourceCategoryMapper.selectResourceCategoryById(resourceCategoryId);
        return resourceCategory;
    }
}




