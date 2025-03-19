package cn.elitecode.service;

public interface LoginService {

    /**
     * 用户登录
     * @param username 用户账号
     * @param userPassword 用户密码
     * @return 用户信息
     */
    String login(String username, String userPassword);

}
