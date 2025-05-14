package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.ResourceMapper;
import cn.elitecode.mapper.RoleResourceMapper;
import cn.elitecode.model.dto.resource.ResourceAddDTO;
import cn.elitecode.model.dto.resource.ResourceQueryDTO;
import cn.elitecode.model.dto.resource.ResourceUpdateDTO;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.RoleResource;
import cn.elitecode.service.ResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
* @author luoyan
* @description 针对表【resource(后台资源表)】的数据库操作Service实现
* @createDate 2025-05-10 15:05:07
*/
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public Long addResource(ResourceAddDTO resourceAddDTO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceAddDTO, resource);
        resource.setCreateBy(SecurityUtils.getUserId());
        resourceMapper.insertResource(resource);
        return resource.getId();
    }

    @Override
    public void removeByResourceIds(Long[] resourceIds) {
        resourceMapper.deleteResourceByIds(resourceIds);
    }

    @Override
    public void updateResourceById(ResourceUpdateDTO resourceUpdateDTO) {
        Resource resource = new Resource();
        BeanUtils.copyProperties(resourceUpdateDTO, resource);
        resource.setUpdateBy(SecurityUtils.getUserId());
        resourceMapper.updateResourceById(resource);
    }

    @Override
    public CommonPage<Resource> selectResourceListByPage(ResourceQueryDTO resourceQueryDTO) {
        if (resourceQueryDTO.getCurrent() != null && resourceQueryDTO.getPageSize() != null) {
            resourceQueryDTO.setCurrent((resourceQueryDTO.getCurrent() - 1) * resourceQueryDTO.getPageSize());
        }
        List<Resource> resourceList = resourceMapper.selectResourceListByPage(resourceQueryDTO);
        Long total = resourceMapper.getTotal(resourceQueryDTO);
        CommonPage<Resource> resourceCommonPage = new CommonPage<>(total, resourceList);
        return resourceCommonPage;
    }

    @Override
    public Resource getResourceById(Long resourceId) {
        Resource resource = resourceMapper.getResourceById(resourceId);
        return resource;
    }

    @Override
    public void allocateResource(Long roleId, Long[] resourceIds) {
        // 删除角色资源关联
        roleResourceMapper.deleteRoleResourceByRoleId(roleId);
        // 新增角色资源关联
        insertRoleResource(roleId, resourceIds);
    }

    /**
     * 新增角色资源关联
     * @param roleId
     * @param resourceIds
     */
    private void insertRoleResource(Long roleId, Long[] resourceIds) {
        List<RoleResource> roleResourceList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            RoleResource roleResource = new RoleResource(roleId, resourceId);
            roleResourceList.add(roleResource);
        }
        roleResourceMapper.batchRoleResource(roleResourceList);
    }
}




