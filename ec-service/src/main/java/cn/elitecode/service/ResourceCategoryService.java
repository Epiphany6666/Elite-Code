package cn.elitecode.service;

import cn.elitecode.model.dto.resourcecategory.ResourceCategoryAddDTO;
import cn.elitecode.model.dto.resourcecategory.ResourceCategoryUpdateDTO;
import cn.elitecode.model.entity.ResourceCategory;
import java.util.List;

/**
* resource_category(后台资源分类表)|业务层
*/
public interface ResourceCategoryService {

    /**
     * 新增后台资源分类
     * @param resourceCategoryAddDTO
     * @return
     */
    Long addResourceCategory(ResourceCategoryAddDTO resourceCategoryAddDTO);

    /**
     * 根据id数组批量删除后台资源分类
     * @param resourceCategoryIds
     */
    void removeByResourceCategoryIds(Long[] resourceCategoryIds);

    /**
     * 根据id修改后台资源分类
     * @param resourceCategoryUpdateDTO
     */
    void updateResourceCategoryById(ResourceCategoryUpdateDTO resourceCategoryUpdateDTO);

    /**
     * 查询所有后台资源分类
     * @return
     */
    List<ResourceCategory> selectResourceCategoryAll();
}
