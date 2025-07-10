package cn.elitecode.module.system.controller.admin.dict;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataAddReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataPageReqVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataSimpleRespVO;
import cn.elitecode.module.system.controller.admin.dict.vo.data.DictDataUpdateReqVO;
import cn.elitecode.module.system.dal.dataobject.dict.DictDataDO;
import cn.elitecode.module.system.service.dict.DictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "DictDataController", description = "管理后台 — 字典数据")
@RestController
@RequestMapping("/system/dict-data")
public class DictDataController {

    @Autowired
    private DictDataService dictDataService;

    @ApiOperation(value = "新增字典数据")
    @PostMapping("/add")
    public CommonResult<Long> addDictData(@Validated @RequestBody DictDataAddReqVO addReqVO) {
        Long dictDataId = dictDataService.addDictData(addReqVO);
        return CommonResult.success(dictDataId);
    }

    @ApiOperation(value = "根据id修改字典数据信息")
    @PutMapping("/update")
    public CommonResult updateDictData(@Validated @RequestBody DictDataUpdateReqVO updateReqVO) {
        dictDataService.updateDictData(updateReqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除字典数据")
    @DeleteMapping("/delete")
    public CommonResult removeDictData(@ApiParam("需要删除的id数组") @RequestParam("ids") Long[] ids) {
        dictDataService.removeDictDataByIds(ids);
        return CommonResult.success();
    }

    @ApiOperation(value = "获取全部字典数据列表", notes = "一般用于管理后台缓存字典数据在本地")
    @GetMapping("/list-all-simple")
    public CommonResult<List<DictDataSimpleRespVO>> getSimpleDictDataList() {
        // 获取字典数据列表
        List<DictDataDO> doList = dictDataService.getDictDataList();
        // 简化字典数据信息
        List<DictDataSimpleRespVO> simpleRespVOList = doList.stream().map(item -> {
            DictDataSimpleRespVO dictDataSimpleRespVO = new DictDataSimpleRespVO();
            BeanUtils.copyProperties(item, dictDataSimpleRespVO);
            return dictDataSimpleRespVO;
        }).collect(Collectors.toList());
        return CommonResult.success(simpleRespVOList);
    }

    @ApiOperation(value = "获取字典数据分页列表")
    @GetMapping("/page")
    public CommonResult<CommonPage<DictDataDO>> getDictDataPage(DictDataPageReqVO pageReqVO) {
        CommonPage<DictDataDO> DOCommonPage = dictDataService.getDictDataPage(pageReqVO);
        return CommonResult.success(DOCommonPage);
    }

    @ApiOperation(value = "根据id查询字典数据")
    @GetMapping("/get")
    public CommonResult<DictDataDO> getDictData(@RequestParam("id") Long id) {
        DictDataDO dictDataDO = dictDataService.getDictData(id);
        return CommonResult.success(dictDataDO);
    }
}
