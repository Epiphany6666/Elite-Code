package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.framework.core.utils.SecurityUtil;
import cn.elitecode.model.dto.menu.MenuAddDTO;
import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.dto.menu.MenuUpdateDTO;
import cn.elitecode.model.entity.Menu;
import cn.elitecode.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "MenuController", description = "菜单管理")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "根据分页条件查询菜单")
    @PostMapping("/list")
    private CommonResult<CommonPage<Menu>> listMenu(@RequestBody MenuQueryDTO menuQueryDTO) {
        CommonPage<Menu> menuPage = menuService.selectMenuListByPage(menuQueryDTO);
        return CommonResult.success(menuPage);
    }

    @ApiOperation(value = "根据id查询菜单")
    @GetMapping("/{menuId}")
    private CommonResult<Menu> getMenu(@PathVariable Long menuId) {
        Menu menu = menuService.getMenuById(menuId);
        return CommonResult.success(menu);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping
    private CommonResult<Long> addMenu(@Validated @RequestBody MenuAddDTO menuAddDTO) {
        Long menuId = menuService.addMenu(menuAddDTO);
        return CommonResult.success(menuId);
    }

    @ApiOperation(value = "根据id修改菜单")
    @PutMapping
    private CommonResult updateMenu(@Validated @RequestBody MenuUpdateDTO menuUpdateDTO) {
        menuService.updateMenu(menuUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id数组批量删除菜单")
    @DeleteMapping("/{menuIds}")
    private CommonResult removeMenu(@PathVariable Long[] menuIds) {
        menuService.removeMenu(menuIds);
        return CommonResult.success();
    }

    @ApiOperation(value = "加载对应角色菜单树")
    @GetMapping("/roleMenuTreeselect/{roleId}")
    private CommonResult<Map> roleMenuTreeselect(@PathVariable Long roleId) {
        Map<String, Object> result = new HashMap<>();
        List<Menu> menuList = menuService.selectMenuListByUserId(SecurityUtil.getUserId());
        result.put("checkedKeys", menuService.selectMenuListByRoleId(roleId));
        result.put("menus", menuService.buildMenuTreeSelect(menuList));
        return CommonResult.success(result);
    }
}
