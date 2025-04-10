package cn.elitecode.service.impl;

import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.RegisterService;
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
    public Long register(User user) {
        userMapper.insertUser(user);
        // 若成功，返回注册用户的id
        return user.getId();
    }

}
