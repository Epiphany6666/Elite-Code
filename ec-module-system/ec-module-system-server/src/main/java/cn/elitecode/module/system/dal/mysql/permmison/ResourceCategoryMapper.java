package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.dal.dataobject.permission.ResourceCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* system_resource_category(后台资源分类表)
*/
@Mapper
public interface ResourceCategoryMapper {

    /**
     * 插入后台资源分类信息
     * @param resourceCategory
     */
    void insertResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据id数组批量删除后台资源分类
     * @param resourceCategoryIds
     */
    void deleteResourceCategoryByIds(@Param("resourceCategoryIds") Long[] resourceCategoryIds);

    /**
     * 根据id修改后台资源分类
     * @param resourceCategory
     */
    void updateResourceCategoryById(ResourceCategory resourceCategory);

    /**
     * 查询所有后台资源分类
     * @return
     */
    List<ResourceCategory> selectResourceCategoryListAll();

    /**
     * 根据id查询后台资源分类信息
     * @param resourceCategoryId
     * @return
     */
    ResourceCategory selectResourceCategoryById(Long resourceCategoryId);
}




