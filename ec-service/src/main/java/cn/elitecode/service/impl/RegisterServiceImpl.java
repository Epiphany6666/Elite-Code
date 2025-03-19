package cn.elitecode.service.impl;

import cn.elitecode.common.exception.user.RegistrationFailedException;
import cn.elitecode.constant.HttpStatus;
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
        boolean regFlag = this.registerUser(user);
        if (!regFlag) {
            throw new RegistrationFailedException(HttpStatus.SYSTEM_ERROR, "注册失败");
        }
        // 若成功，返回注册用户的id
        return user.getId();
    }

    /**
     * 注册用户
     * @param user 用户信息
     * @return 结果
     */
    public boolean registerUser(User user) {
        int result = userMapper.insertUser(user);
        if (result <= 0) {
            log.error("用户插入数据库失败：{}", result);
        }
        return true;
    }

}
