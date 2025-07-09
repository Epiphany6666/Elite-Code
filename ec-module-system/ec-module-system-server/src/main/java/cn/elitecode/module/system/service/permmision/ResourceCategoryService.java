package cn.elitecode.module.system.service.permmision;

import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resourcecategory.ResourceCategoryUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceCategory;

import java.util.List;

/**
* system_resource_category(后台资源分类表)|业务层
*/
public interface ResourceCategoryService {

    /**
     * 新增后台资源分类
     * @param resourceCategoryAddReqVO
     * @return
     */
    Long addResourceCategory(ResourceCategoryAddReqVO resourceCategoryAddReqVO);

    /**
     * 根据id数组批量删除后台资源分类
     * @param resourceCategoryIds
     */
    void removeByResourceCategoryIds(Long[] resourceCategoryIds);

    /**
     * 根据id修改后台资源分类
     * @param resourceCategoryUpdateReqVO
     */
    void updateResourceCategoryById(ResourceCategoryUpdateReqVO resourceCategoryUpdateReqVO);

    /**
     * 查询所有后台资源分类
     * @return
     */
    List<ResourceCategory> selectResourceCategoryAll();

    /**
     * 根据id查找资源
     * @param resourceCategoryId
     * @return
     */
    ResourceCategory selectResourceCategoryById(Long resourceCategoryId);
}
