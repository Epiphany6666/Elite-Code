package cn.luoyan.elitecode.service.impl;

import cn.luoyan.elitecode.mapper.SysUserMapper;
import cn.luoyan.elitecode.model.entity.SysUser;
import cn.luoyan.elitecode.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户 处理层
 *
 * @author 洛言
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    private final static String SALT = "luoyan";

    @Override
    public SysUser login(String userAccount, String password, HttpServletRequest request) throws Exception {
        // 1.校验
        if (StringUtils.isAnyBlank(userAccount, password)) {
            throw new Exception("账号或密码为空");
        }
        if (userAccount.length() < 4) {
            throw new Exception("账号长度不足4位");
        }
        if (password.length() < 8) {
            throw new Exception("密码长度不足8位");
        }

        // 2.加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

        // 4.查询用户是否存在
        SysUser user = userMapper.selectUserByUserAccountAndPassword(userAccount, encryptPassword);
        if (user == null) {
            throw new Exception("账号或密码错误");
        }

        // 5.设置登录态
        request.getSession().setAttribute("user_login", user);

        // 6.返回用户信息
        return user;
    }
}
