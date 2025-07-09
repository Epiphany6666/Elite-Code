package cn.elitecode.module.system.dal.mysql.permmison;

import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceQueryReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* system_resource(后台资源表)
*/
@Mapper
public interface ResourceMapper {

    /**
     * 插入后台资源信息
     * @param resourceDO
     */
    void insertResource(ResourceDO resourceDO);

    /**
     * 根据id数组批量删除后台资源
     * @param resourceIds
     */
    void deleteResourceByIds(@Param("resourceIds") Long[] resourceIds);

    /**
     * 根据id修改后台资源信息
     * @param resourceDO
     */
    void updateResourceById(ResourceDO resourceDO);

    /**
     * 根据分页条件查询资源信息
     * @param resourceQueryReqVO
     * @return
     */
    List<ResourceDO> selectResourceListByPage(ResourceQueryReqVO resourceQueryReqVO);

    /**
     * 根据分页条件查询总数
     * @param resourceQueryReqVO
     * @return
     */
    Long getTotal(ResourceQueryReqVO resourceQueryReqVO);

    /**
     * 根据id查询后台资源信息
     * @param resourceId
     * @return
     */
    ResourceDO getResourceById(Long resourceId);

    /**
     * 获取角色相关资源信息
     * @param roleId
     * @return
     */
    List<ResourceDO> listResourceByRoleId(Long roleId);

    /**
     * 查询所有后台资源信息
     * @return
     */
    List<ResourceDO> selectResourceAll();

    /**
     * 根据用户id查询后台资源信息
     * @param userId
     * @return
     */
    List<ResourceDO> selectResourceByUserId(Long userId);
}




