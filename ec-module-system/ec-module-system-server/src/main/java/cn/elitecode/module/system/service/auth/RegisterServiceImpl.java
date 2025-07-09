package cn.elitecode.module.system.service.auth;

import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.dal.mysql.user.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long register(UserDO userDO) {
        userMapper.insertUser(userDO);
        // 若成功，返回注册用户的id
        return userDO.getId();
    }

}
