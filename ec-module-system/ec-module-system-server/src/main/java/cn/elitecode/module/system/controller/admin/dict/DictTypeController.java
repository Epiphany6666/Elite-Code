package cn.elitecode.module.system.controller.admin.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypePageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.type.DictTypeUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictTypeDO;
import cn.elitecode.module.system.service.dict.DictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "DictTypeController", description = "管理后台 — 字典类型")
@RestController
@RequestMapping("/system/dict-type")
public class DictTypeController {

    @Autowired
    private DictTypeService dictTypeService;

    @ApiOperation(value = "新增字典类型")
    @PostMapping("/add")
    public CommonResult<Long> addDictType(@Validated @RequestBody DictTypeAddReqVO addReqVO) {
        Long dictTypeId = dictTypeService.addDictType(addReqVO);
        return CommonResult.success(dictTypeId);
    }

    @ApiOperation(value = "批量删除字典类型")
    @DeleteMapping("/delete")
    public CommonResult removeDictType(@ApiParam("需要删除的id数组") @RequestParam("ids") Long[] ids) {
        dictTypeService.removeDictTypeByIds(ids);
        return CommonResult.success();
    }

    @ApiOperation(value = "修改字典类型")
    @PutMapping("/update")
    public CommonResult updateDictType(@Validated @RequestBody DictTypeUpdateReqVO updateReqVO) {
        dictTypeService.updateDictType(updateReqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取字典类型分页列表")
    @GetMapping("/page")
    public CommonResult<CommonPage<DictTypeDO>> getDictTypePage(DictTypePageReqVO pageReqVO) {
        CommonPage<DictTypeDO> dictTypeDOCommonPage = dictTypeService.getDictTypePage(pageReqVO);
        return CommonResult.success(dictTypeDOCommonPage);
    }

    @ApiOperation(value = "根据id查询字典类型")
    @GetMapping("/get")
    public CommonResult<DictTypeDO> getDictType(@RequestParam("id") Long id) {
        DictTypeDO dictTypeDO = dictTypeService.getDictType(id);
        return CommonResult.success(dictTypeDO);
    }
}
