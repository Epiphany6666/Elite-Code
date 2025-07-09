package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;

import java.util.List;

/**
* system_resource(后台资源表)|业务层
*/
public interface ResourceService {

    /**
     * 新增后台资源
     * @param resourceAddReqVO
     * @return
     */
    Long addResource(ResourceAddReqVO resourceAddReqVO);

    /**
     * 根据id数组批量删除后台资源
     * @param resourceIds
     */
    void removeByResourceIds(Long[] resourceIds);

    /**
     * 根据id修改后台资源
     * @param resourceUpdateReqVO
     */
    void updateResourceById(ResourceUpdateReqVO resourceUpdateReqVO);

    /**
     * 根据分页条件查找后台资源
     * @param resourceQueryReqVO
     * @return
     */
    CommonPage<ResourceDO> selectResourceListByPage(ResourceQueryReqVO resourceQueryReqVO);

    /**
     * 根据id查询后台资源
     * @param resourceId
     * @return
     */
    ResourceDO getResourceById(Long resourceId);

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
    List<ResourceDO> listResourceAll();
}
