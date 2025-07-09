package cn.elitecode.module.member.controller.admin.user;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserQueryReqVO;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;
import cn.elitecode.module.member.service.user.MemberUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "MemberUserController", description = "会员信息管理")
@RestController
@RequestMapping("/member/user")
public class MemberUserController {

    @Autowired
    private MemberUserService memberUserService;

    @ApiOperation(value = "更新会员信息")
    @PutMapping
    private CommonResult updateUser(@RequestBody @Validated MemberUserUpdateReqVO reqVO) {
        memberUserService.updateUser(reqVO);
        return CommonResult.success();
    }

    @ApiOperation(value = "根据id查询会员信息")
    @GetMapping("/{userId}")
    private CommonResult<MemberUserDO> getUser(@PathVariable Long userId) {
        MemberUserDO memberUserDO = memberUserService.getUserById(userId);
        return CommonResult.success(memberUserDO);
    }

    @ApiOperation(value = "根据分页条件查询会员信息")
    @PostMapping("/list")
    private CommonResult<CommonPage<MemberUserDO>> list(@RequestBody MemberUserQueryReqVO reqVO) {
        CommonPage commonPage = memberUserService.selectUserList(reqVO);
        return CommonResult.success(commonPage);
    }

}
