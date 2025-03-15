package cn.elitecode.web.service;

import cn.elitecode.common.exception.user.UsernameNotFoundException;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.entity.User;
import cn.elitecode.model.bo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户是否存在
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        return new LoginUser(user);
    }

}
