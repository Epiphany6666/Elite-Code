package cn.elitecode.framework.security.core.utils;

import cn.elitecode.framework.security.core.LoginUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {

    /**
     * 获取当前登录用户id
     * @return
     */
    public static LoginUser getLoginUser() {
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return loginUser;
    }

    /**
     * 获取当前登录用户id
     * @return
     */
    public static Long getUserId() {
        return getLoginUser().getId();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
