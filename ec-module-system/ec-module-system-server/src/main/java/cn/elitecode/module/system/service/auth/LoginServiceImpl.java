package cn.elitecode.module.system.service.auth;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.security.core.LoginUser;
import cn.elitecode.framework.security.core.enums.UserTypeEnum;
import cn.elitecode.framework.security.core.utils.JwtTokenUtil;
import cn.elitecode.module.system.dal.dataobject.permission.ResourceDO;
import cn.elitecode.module.system.dal.dataobject.user.UserDO;
import cn.elitecode.module.system.dal.mysql.permmison.ResourceMapper;
import cn.elitecode.module.system.dal.mysql.user.UserMapper;
import cn.elitecode.module.system.exception.user.UserPasswordNotMatchException;
import cn.elitecode.module.system.exception.user.UsernameNotFoundException;
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
        UserDO userDO = authenticate(username, userPassword);
        List<ResourceDO> resourceDOList = resourceMapper.selectResourceByUserId(userDO.getId());
        LoginUser loginUser = new LoginUser(
                userDO.getId(),
                UserTypeEnum.ADMIN.getValue(),
                resourceDOList.stream()
                        .map(resource -> new SimpleGrantedAuthority(resource.getId() + ":" + resource.getName()))
                        .collect(Collectors.toList())
        );
        String token = jwtTokenUtil.createToken(loginUser);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return token;
    }

    private UserDO authenticate(String username, String userPassword) {
        // 查询用户是否存在
        UserDO userDO = userMapper.selectUserByUsername(username);
        if (userDO == null) {
            throw new UsernameNotFoundException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        if (!passwordEncoder.matches(userPassword, userDO.getPassword())) {
            throw new UserPasswordNotMatchException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        return userDO;
    }

}
