package cn.elitecode.module.member.controller.app.user;

import cn.elitecode.framework.common.pojo.CommonResult;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.member.controller.app.user.vo.AppMemberUserInfoRespVO;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;
import cn.elitecode.module.member.service.user.MemberUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AppMemberUserController", description = "用户 APP - 用户个人中心")
@RestController
@RequestMapping("/member/user")
public class AppMemberUserController {

    @Autowired
    private MemberUserService userService;

    @ApiOperation(value = "获取个人信息")
    @GetMapping("/getInfo")
    private CommonResult<AppMemberUserInfoRespVO> getMemberUserInfo() {
        MemberUserDO memberUserDO = userService.getUserById(SecurityUtil.getUserId());
        AppMemberUserInfoRespVO appMemberUserInfoRespVO = new AppMemberUserInfoRespVO();
        BeanUtils.copyProperties(memberUserDO, appMemberUserInfoRespVO);
        return CommonResult.success(appMemberUserInfoRespVO);
    }
}
