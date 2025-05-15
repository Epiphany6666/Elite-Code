package cn.elitecode.service;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.model.dto.resource.ResourceAddDTO;
import cn.elitecode.model.dto.resource.ResourceQueryDTO;
import cn.elitecode.model.dto.resource.ResourceUpdateDTO;
import cn.elitecode.model.entity.Resource;
import java.util.List;

/**
* resource(后台资源表)|业务层
*/
public interface ResourceService {

    /**
     * 新增后台资源
     * @param resourceAddDTO
     * @return
     */
    Long addResource(ResourceAddDTO resourceAddDTO);

    /**
     * 根据id数组批量删除后台资源
     * @param resourceIds
     */
    void removeByResourceIds(Long[] resourceIds);

    /**
     * 根据id修改后台资源
     * @param resourceUpdateDTO
     */
    void updateResourceById(ResourceUpdateDTO resourceUpdateDTO);

    /**
     * 根据分页条件查找后台资源
     * @param resourceQueryDTO
     * @return
     */
    CommonPage<Resource> selectResourceListByPage(ResourceQueryDTO resourceQueryDTO);

    /**
     * 根据id查询后台资源
     * @param resourceId
     * @return
     */
    Resource getResourceById(Long resourceId);

    /**
     * 给角色分配后台资源
     * @param roleId
     * @param resourceIds
     */
    void allocateResource(Long roleId, Long[] resourceIds);

    /**
     * 查询所有后台资源
     * @return
     */
    List<Resource> listResourceAll();
}
