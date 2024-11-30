package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.model.entity.SysUser;
import cn.luoyan.elitecode.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @GetMapping("/login")
    private SysUser login(String userAccount, String password, HttpServletRequest request) throws Exception {
        return userService.login(userAccount, password, request);
    }

}
