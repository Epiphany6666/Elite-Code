package cn.elitecode.module.system.service.auth;

import cn.elitecode.module.system.dal.dataobject.user.UserDO;

public interface RegisterService {

    /**
     * 用户注册
     * @param userDO 用户信息
     */
    Long register(UserDO userDO);

}
