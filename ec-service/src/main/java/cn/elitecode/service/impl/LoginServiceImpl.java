package cn.elitecode.service.impl;

import cn.elitecode.common.exception.user.UserPasswordNotMatchException;
import cn.elitecode.common.utils.JwtTokenUtil;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.model.bo.LoginUser;
import cn.elitecode.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username, String userPassword) {
        LoginUser loginUser = (LoginUser) userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(userPassword, loginUser.getPassword())) {
            throw new UserPasswordNotMatchException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        String token = jwtTokenUtil.createToken(loginUser);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return token;
    }

}
