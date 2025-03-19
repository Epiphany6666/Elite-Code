package cn.elitecode.service;

import cn.elitecode.model.entity.User;

public interface RegisterService {

    /**
     * 用户注册
     * @param user 用户信息
     */
    Long register(User user);

}
