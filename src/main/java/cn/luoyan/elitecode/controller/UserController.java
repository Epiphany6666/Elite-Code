package cn.luoyan.elitecode.controller;

import cn.luoyan.elitecode.common.AjaxResult;
import cn.luoyan.elitecode.model.dto.user.UserLoginDTO;
import cn.luoyan.elitecode.model.entity.User;
import cn.luoyan.elitecode.model.vo.LoginUserVO;
import cn.luoyan.elitecode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private UserService userService;

    /**
     * 用户登录
     * @param userLoginDTO
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    private AjaxResult<LoginUserVO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        String userAccount = userLoginDTO.getUserAccount();
        String userPassword = userLoginDTO.getUserPassword();
        return AjaxResult.success(userService.login(userAccount, userPassword, request));
    }

}
