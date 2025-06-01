package cn.elitecode.service.impl;

import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.ResourceCategoryMapper;
import cn.elitecode.model.dto.resourcecategory.ResourceCategoryAddDTO;
import cn.elitecode.model.dto.resourcecategory.ResourceCategoryUpdateDTO;
import cn.elitecode.model.entity.ResourceCategory;
import cn.elitecode.service.ResourceCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public Long addResourceCategory(ResourceCategoryAddDTO resourceCategoryAddDTO) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(resourceCategoryAddDTO, resourceCategory);
        resourceCategory.setCreateBy(SecurityUtils.getUserId());
        resourceCategoryMapper.insertResourceCategory(resourceCategory);
        return resourceCategory.getId();
    }

    @Override
    public void removeByResourceCategoryIds(Long[] resourceCategoryIds) {
        resourceCategoryMapper.deleteResourceCategoryByIds(resourceCategoryIds);
    }

    @Override
    public void updateResourceCategoryById(ResourceCategoryUpdateDTO resourceCategoryUpdateDTO) {
        ResourceCategory resourceCategory = new ResourceCategory();
        BeanUtils.copyProperties(resourceCategoryUpdateDTO, resourceCategory);
        resourceCategory.setUpdateBy(SecurityUtils.getUserId());
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




