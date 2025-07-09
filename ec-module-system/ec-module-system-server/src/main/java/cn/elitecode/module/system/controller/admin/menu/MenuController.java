package cn.elitecode.module.system.controller.admin.menu;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuAddReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuQueryReqVO;
import cn.elitecode.module.system.controller.admin.menu.vo.MenuUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.menu.MenuDO;
import cn.elitecode.module.system.service.permmision.MenuService;
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
    private CommonResult<CommonPage<MenuDO>> listMenu(@RequestBody MenuQueryReqVO menuQueryReqVO) {
        CommonPage<MenuDO> menuPage = menuService.selectMenuListByPage(menuQueryReqVO);
        return CommonResult.success(menuPage);
    }

    @ApiOperation(value = "根据id查询菜单")
    @GetMapping("/{menuId}")
    private CommonResult<MenuDO> getMenu(@PathVariable Long menuId) {
        MenuDO menuDO = menuService.getMenuById(menuId);
        return CommonResult.success(menuDO);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping
    private CommonResult<Long> addMenu(@Validated @RequestBody MenuAddReqVO menuAddReqVO) {
        Long menuId = menuService.addMenu(menuAddReqVO);
        return CommonResult.success(menuId);
    }

    @ApiOperation(value = "根据id修改菜单")
    @PutMapping
    private CommonResult updateMenu(@Validated @RequestBody MenuUpdateReqVO menuUpdateReqVO) {
        menuService.updateMenu(menuUpdateReqVO);
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
        List<MenuDO> menuDOList = menuService.selectMenuListByUserId(SecurityUtil.getUserId());
        result.put("checkedKeys", menuService.selectMenuListByRoleId(roleId));
        result.put("menus", menuService.buildMenuTreeSelect(menuDOList));
        return CommonResult.success(result);
    }
}
