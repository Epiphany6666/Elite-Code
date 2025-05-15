package cn.elitecode.mapper;

import cn.elitecode.model.dto.resource.ResourceQueryDTO;
import cn.elitecode.model.entity.Resource;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* resource(后台资源表)
*/
public interface ResourceMapper {

    /**
     * 插入后台资源信息
     * @param resource
     */
    void insertResource(Resource resource);

    /**
     * 根据id数组批量删除后台资源
     * @param resourceIds
     */
    void deleteResourceByIds(@Param("resourceIds") Long[] resourceIds);

    /**
     * 根据id修改后台资源信息
     * @param resource
     */
    void updateResourceById(Resource resource);

    /**
     * 根据分页条件查询资源信息
     * @param resourceQueryDTO
     * @return
     */
    List<Resource> selectResourceListByPage(ResourceQueryDTO resourceQueryDTO);

    /**
     * 根据分页条件查询总数
     * @param resourceQueryDTO
     * @return
     */
    Long getTotal(ResourceQueryDTO resourceQueryDTO);

    /**
     * 根据id查询后台资源信息
     * @param resourceId
     * @return
     */
    Resource getResourceById(Long resourceId);

    /**
     * 获取角色相关资源信息
     * @param roleId
     * @return
     */
    List<Resource> listResourceByRoleId(Long roleId);

    /**
     * 查询所有后台资源信息
     * @return
     */
    List<Resource> selectResourceAll();

    /**
     * 根据用户id查询后台资源信息
     * @param userId
     * @return
     */
    List<Resource> selectResourceByUserId(Long userId);
}




