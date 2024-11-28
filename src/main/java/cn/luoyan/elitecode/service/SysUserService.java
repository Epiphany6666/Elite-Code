package cn.luoyan.elitecode.service;

import cn.luoyan.elitecode.model.entity.SysUser;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户 业务层
 *
 * @author 洛言
 */
public interface SysUserService {

    /**
     * 用户登录
     * @param userAccount 用户账号
     * @param password 用户密码
     * @param request
     * @return 用户信息
     */
    SysUser login(String userAccount, String password, HttpServletRequest request) throws Exception;
}
