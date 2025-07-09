package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceAddReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceQueryReqVO;
import cn.elitecode.module.system.controller.admin.permmision.vo.resource.ResourceUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleResourceDO;
import cn.elitecode.module.system.dal.mysql.permmison.ResourceMapper;
import cn.elitecode.module.system.dal.mysql.permmison.RoleResourceMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* @author luoyan
* @description 针对表【system_resource(后台资源表)】的数据库操作Service实现
* @createDate 2025-05-10 15:05:07
*/
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public Long addResource(ResourceAddReqVO resourceAddReqVO) {
        ResourceDO resourceDO = new ResourceDO();
        BeanUtils.copyProperties(resourceAddReqVO, resourceDO);
        resourceDO.setCreateBy(SecurityUtil.getUserId());
        resourceMapper.insertResource(resourceDO);
        return resourceDO.getId();
    }

    @Override
    public void removeByResourceIds(Long[] resourceIds) {
        resourceMapper.deleteResourceByIds(resourceIds);
    }

    @Override
    public void updateResourceById(ResourceUpdateReqVO resourceUpdateReqVO) {
        ResourceDO resourceDO = new ResourceDO();
        BeanUtils.copyProperties(resourceUpdateReqVO, resourceDO);
        resourceDO.setUpdateBy(SecurityUtil.getUserId());
        resourceMapper.updateResourceById(resourceDO);
    }

    @Override
    public CommonPage<ResourceDO> selectResourceListByPage(ResourceQueryReqVO resourceQueryReqVO) {
        if (resourceQueryReqVO.getCurrent() != null && resourceQueryReqVO.getPageSize() != null) {
            resourceQueryReqVO.setCurrent((resourceQueryReqVO.getCurrent() - 1) * resourceQueryReqVO.getPageSize());
        }
        List<ResourceDO> resourceDOList = resourceMapper.selectResourceListByPage(resourceQueryReqVO);
        Long total = resourceMapper.getTotal(resourceQueryReqVO);
        CommonPage<ResourceDO> resourceCommonPage = new CommonPage<>(total, resourceDOList);
        return resourceCommonPage;
    }

    @Override
    public ResourceDO getResourceById(Long resourceId) {
        ResourceDO resourceDO = resourceMapper.getResourceById(resourceId);
        return resourceDO;
    }

    @Override
    @Transactional
    public void allocateResource(Long roleId, Long[] resourceIds) {
        // 删除角色资源关联
        roleResourceMapper.deleteRoleResourceByRoleId(roleId);
        // 新增角色资源关联
        insertRoleResource(roleId, resourceIds);
    }

    @Override
    public List<ResourceDO> listResourceAll() {
        List<ResourceDO> resourceDOList = resourceMapper.selectResourceAll();
        return resourceDOList;
    }

    /**
     * 新增角色资源关联
     * @param roleId
     * @param resourceIds
     */
    private void insertRoleResource(Long roleId, Long[] resourceIds) {
        List<RoleResourceDO> roleResourceDOList = new ArrayList<>();
        for (Long resourceId : resourceIds) {
            RoleResourceDO roleResourceDO = new RoleResourceDO(roleId, resourceId);
            roleResourceDOList.add(roleResourceDO);
        }
        roleResourceMapper.batchRoleResource(roleResourceDOList);
    }
}




