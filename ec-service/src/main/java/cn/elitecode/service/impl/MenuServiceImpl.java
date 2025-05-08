package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.MenuMapper;
import cn.elitecode.mapper.RoleMapper;
import cn.elitecode.model.bo.TreeSelect;
import cn.elitecode.model.dto.menu.MenuAddDTO;
import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.dto.menu.MenuUpdateDTO;
import cn.elitecode.model.entity.Menu;
import cn.elitecode.model.entity.Role;
import cn.elitecode.service.MenuService;
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
    public Long addMenu(MenuAddDTO menuAddDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuAddDTO, menu);
        menu.setCreateBy(SecurityUtils.getUserId());
        menuMapper.insertMenu(menu);
        return menu.getId();
    }

    @Override
    public void removeMenu(Long[] menuIds) {
        menuMapper.deleteByMenuIds(menuIds);
    }

    @Override
    public void updateMenu(MenuUpdateDTO menuUpdateDTO) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuUpdateDTO, menu);
        menu.setUpdateBy(SecurityUtils.getUserId());
        menuMapper.updateMenuById(menu);
    }

    @Override
    public CommonPage<Menu> selectMenuListByPage(MenuQueryDTO menuQueryDTO) {
        if (menuQueryDTO.getCurrent() != null && menuQueryDTO.getPageSize() != null) {
            menuQueryDTO.setCurrent((menuQueryDTO.getCurrent() - 1) * menuQueryDTO.getPageSize());
        }
        List<Menu> menuList = menuMapper.selectMenuListByPage(menuQueryDTO);
        Long total = menuMapper.getTotalByPage(menuQueryDTO);
        CommonPage<Menu> menuCommonPage = new CommonPage<>(total, menuList);
        return menuCommonPage;
    }

    @Override
    public Menu getMenuById(Long menuId) {
        Menu menu = menuMapper.selectMenuById(menuId);
        return menu;
    }

    @Override
    public List<Menu> selectMenuListByUserId(Long userId) {
        List<Menu> menuList = menuMapper.selectMenuListByUserId(userId);
        return menuList;
    }

    @Override
    public List<Long> selectMenuListByRoleId(Long roleId) {
        Role role = roleMapper.selectRoleById(roleId);
        List<Long> menuIds = menuMapper.selectMenuListByRoleId(roleId, role.getMenuCheckStrictly());
        return menuIds;
    }

    @Override
    public List<TreeSelect> buildMenuTreeSelect(List<Menu> menuList) {
        List<Menu> menuTrees = buildMenuTree(menuList);
        List<TreeSelect> menuTreeSelects = menuTrees.stream().map(TreeSelect::new).toList();
        return menuTreeSelects;
    }

    /**
     * 构建菜单树
     * @param menuList
     * @return
     */
    private List<Menu> buildMenuTree(List<Menu> menuList) {
        List<Menu> menuTrees = new ArrayList<>();
        List<Long> menuIdList = menuList.stream().map(Menu::getId).toList();
        for (Menu menu : menuList) {
            // 如果是顶级节点，遍历该父节点的所有子结点
            if (!menuIdList.contains(menu.getParentId())) {
                recursionFn(menuList, menu);
                menuTrees.add(menu);
            }
        }
        if (menuTrees.isEmpty()) {
            menuTrees = menuList;
        }
        return menuTrees;
    }

    /**
     * 递归列表
     * @param menuList 菜单列表
     * @param child 子菜单
     */
    private void recursionFn(List<Menu> menuList, Menu child) {
        // 设置菜单child的子菜单
        List<Menu> menuChildren = new ArrayList<>();
        for (Menu menu : menuList) {
            if (child.getId().longValue() == menu.getParentId().longValue()) {
                menuChildren.add(menu);
            }
        }
        child.setChildren(menuChildren);
        // 遍历子菜单
        for (Menu menuChild : menuChildren) {
            recursionFn(menuList, menuChild);
        }
    }
}




