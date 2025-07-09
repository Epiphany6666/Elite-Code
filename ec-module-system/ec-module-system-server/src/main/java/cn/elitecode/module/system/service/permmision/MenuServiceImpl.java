package cn.elitecode.module.system.service.permmision;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuAddReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuQueryReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.TreeSelect;
import cn.elitecode.module.system.dal.dataobject.menu.MenuDO;
import cn.elitecode.module.system.dal.dataobject.permission.RoleDO;
import cn.elitecode.module.system.dal.mysql.menu.MenuMapper;
import cn.elitecode.module.system.dal.mysql.permmison.RoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* menu(菜单表) | 业务处理层
*/
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Long addMenu(MenuAddReqVO menuAddReqVO) {
        MenuDO menuDO = new MenuDO();
        BeanUtils.copyProperties(menuAddReqVO, menuDO);
        menuDO.setCreateBy(SecurityUtil.getUserId());
        menuMapper.insertMenu(menuDO);
        return menuDO.getId();
    }

    @Override
    public void removeMenu(Long[] menuIds) {
        menuMapper.deleteByMenuIds(menuIds);
    }

    @Override
    public void updateMenu(MenuUpdateReqVO menuUpdateReqVO) {
        MenuDO menuDO = new MenuDO();
        BeanUtils.copyProperties(menuUpdateReqVO, menuDO);
        menuDO.setUpdateBy(SecurityUtil.getUserId());
        menuMapper.updateMenuById(menuDO);
    }

    @Override
    public CommonPage<MenuDO> selectMenuListByPage(MenuQueryReqVO menuQueryReqVO) {
        if (menuQueryReqVO.getCurrent() != null && menuQueryReqVO.getPageSize() != null) {
            menuQueryReqVO.setCurrent((menuQueryReqVO.getCurrent() - 1) * menuQueryReqVO.getPageSize());
        }
        List<MenuDO> menuDOList = menuMapper.selectMenuListByPage(menuQueryReqVO);
        Long total = menuMapper.getTotalByPage(menuQueryReqVO);
        CommonPage<MenuDO> menuCommonPage = new CommonPage<>(total, menuDOList);
        return menuCommonPage;
    }

    @Override
    public MenuDO getMenuById(Long menuId) {
        MenuDO menuDO = menuMapper.selectMenuById(menuId);
        return menuDO;
    }

    @Override
    public List<MenuDO> selectMenuListByUserId(Long userId) {
        List<MenuDO> menuDOList = menuMapper.selectMenuListByUserId(userId);
        return menuDOList;
    }

    @Override
    public List<Long> selectMenuListByRoleId(Long roleId) {
        RoleDO roleDO = roleMapper.selectRoleById(roleId);
        List<Long> menuIds = menuMapper.selectMenuListByRoleId(roleId, roleDO.getMenuCheckStrictly());
        return menuIds;
    }

    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<MenuDO> menuDOList) {
        List<MenuDO> menuDOTrees = buildMenuTree(menuDOList);
        List<TreeSelect> menuTreeSelects = menuDOTrees.stream().map(TreeSelect::new).toList();
        return menuTreeSelects;
    }

    /**
     * 构建菜单树
     * @param menuDOList
     * @return
     */
    private List<MenuDO> buildMenuTree(List<MenuDO> menuDOList) {
        List<MenuDO> menuDOTrees = new ArrayList<>();
        List<Long> menuIdList = menuDOList.stream().map(MenuDO::getId).toList();
        for (MenuDO menuDO : menuDOList) {
            // 如果是顶级节点，遍历该父节点的所有子结点
            if (!menuIdList.contains(menuDO.getParentId())) {
                recursionFn(menuDOList, menuDO);
                menuDOTrees.add(menuDO);
            }
        }
        if (menuDOTrees.isEmpty()) {
            menuDOTrees = menuDOList;
        }
        return menuDOTrees;
    }

    /**
     * 递归列表
     * @param menuDOList 菜单列表
     * @param child 子菜单
     */
    private void recursionFn(List<MenuDO> menuDOList, MenuDO child) {
        // 设置菜单child的子菜单
        List<MenuDO> menuDOChildren = new ArrayList<>();
        for (MenuDO menuDO : menuDOList) {
            if (child.getId().longValue() == menuDO.getParentId().longValue()) {
                menuDOChildren.add(menuDO);
            }
        }
        child.setChildren(menuDOChildren);
        // 遍历子菜单
        for (MenuDO menuDOChild : menuDOChildren) {
            recursionFn(menuDOList, menuDOChild);
        }
    }
}




