package cn.elitecode.module.member.controller.app.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AppMemberUserController", description = "用户 APP - 用户个人中心")
@RestController
@RequestMapping("/app-api/member/user")
public class AppMemberUserController {
}
