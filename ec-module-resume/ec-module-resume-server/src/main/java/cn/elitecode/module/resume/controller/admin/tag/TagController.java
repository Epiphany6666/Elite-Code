package cn.elitecode.module.resume.controller.admin.tag;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.resume.dal.dataobject.tag.TagDO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagAddDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagQueryDTO;
import cn.elitecode.module.resume.controller.admin.tag.vo.TagUpdateDTO;
import cn.elitecode.module.resume.service.tag.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "TagController", description = "题目标签管理")
@RestController
@RequestMapping("/vo")
public class TagController {

    @Autowired
    private TagService tagService;

    @ApiOperation(value = "根据分页条件查询标签信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<TagDO>> listTag(@RequestBody TagQueryDTO tagQueryDTO) {
        CommonPage<TagDO> page = tagService.selectTagList(tagQueryDTO);
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

    @ApiOperation(value = "根据id查询标签")
    @GetMapping("/{tagId}")
    private CommonResult<TagDO> getTag(@PathVariable Long tagId) {
        TagDO tagDO = tagService.selectTagById(tagId);
        return CommonResult.success(tagDO);
    }

}
