package cn.elitecode.service.impl;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.utils.SecurityUtils;
import cn.elitecode.mapper.MenuMapper;
import cn.elitecode.model.dto.menu.MenuAddDTO;
import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.dto.menu.MenuUpdateDTO;
import cn.elitecode.model.entity.Menu;
import cn.elitecode.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
* menu(菜单表) | 业务处理层
*/
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

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
}




