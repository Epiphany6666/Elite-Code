package cn.elitecode.web.controller;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.common.api.CommonResult;
import cn.elitecode.model.dto.tag.TagAddDTO;
import cn.elitecode.model.dto.tag.TagQueryDTO;
import cn.elitecode.model.dto.tag.TagUpdateDTO;
import cn.elitecode.model.entity.Tag;
import cn.elitecode.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "TagController", description = "题目标签管理")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "根据分页条件查询标签信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<Tag>> listTag(@RequestBody TagQueryDTO tagQueryDTO) {
        CommonPage<Tag> page = tagService.selectTagList(tagQueryDTO);
        return CommonResult.success(page);
    }

    @ApiOperation(value = "新增标签")
    @PostMapping
    private CommonResult<Long> addTag(@Validated @RequestBody TagAddDTO tagAddDTO) {
        Long tagId = tagService.addTag(tagAddDTO);
        return CommonResult.success(tagId);
    }

    @ApiOperation(value = "根据id修改标签信息")
    @PutMapping
    private CommonResult updateTag(@Validated @RequestBody TagUpdateDTO tagUpdateDTO) {
        tagService.updateTag(tagUpdateDTO);
        return CommonResult.success();
    }

    @ApiOperation(value = "批量删除标签")
    @DeleteMapping("/{tagIds}")
    private CommonResult removeTags(@PathVariable("tagIds") Long[] tagIds) {
        tagService.removeTagByIds(tagIds);
        return CommonResult.success();
    }

}
