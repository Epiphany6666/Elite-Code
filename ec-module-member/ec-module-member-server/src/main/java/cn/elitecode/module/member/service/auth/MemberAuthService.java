package cn.elitecode.module.member.service.auth;

public interface MemberAuthService {

    /**
     * App登录
     * @param mobile
     * @param password
     * @return
     */
    String login(String mobile, String password);
}
