package cn.elitecode.service.impl;

import cn.elitecode.common.exception.user.UserPasswordNotMatchException;
import cn.elitecode.common.exception.user.UsernameNotFoundException;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.framework.core.LoginUser;
import cn.elitecode.framework.core.enums.UserTypeEnum;
import cn.elitecode.framework.core.utils.JwtTokenUtil;
import cn.elitecode.mapper.ResourceMapper;
import cn.elitecode.mapper.UserMapper;
import cn.elitecode.model.entity.Resource;
import cn.elitecode.model.entity.User;
import cn.elitecode.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public String login(String username, String userPassword) {
        User user = authenticate(username, userPassword);
        List<Resource> resourceList = resourceMapper.selectResourceByUserId(user.getId());
        LoginUser loginUser = new LoginUser(
                UserTypeEnum.ADMIN.getValue(),
                resourceList.stream()
                        .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                        .collect(Collectors.toList())
        );
        String token = jwtTokenUtil.createToken(loginUser);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return token;
    }

    private User authenticate(String username, String userPassword) {
        // 查询用户是否存在
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        if (!passwordEncoder.matches(userPassword, user.getPassword())) {
            throw new UserPasswordNotMatchException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        return user;
    }

}
