package cn.elitecode.module.member.service.auth;

import cn.elitecode.common.exception.user.UserPasswordNotMatchException;
import cn.elitecode.common.exception.user.UsernameAlreadyExistsException;
import cn.elitecode.constant.HttpStatus;
import cn.elitecode.framework.core.LoginUser;
import cn.elitecode.framework.core.enums.UserTypeEnum;
import cn.elitecode.framework.core.utils.JwtTokenUtil;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;
import cn.elitecode.module.member.dal.mysql.MemberUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MemberAuthServiceImpl implements MemberAuthService{

    @Autowired
    private MemberUserMapper memberUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String mobile, String password) {
        MemberUserDO memberUserDO = authenticate(mobile, password);
        LoginUser loginUser = new LoginUser(UserTypeEnum.MEMBER.getValue(), Arrays.asList(new SimpleGrantedAuthority("TEST")));
        loginUser.setId(memberUserDO.getId());
        String token = jwtTokenUtil.createToken(loginUser);
        return token;
    }

    private MemberUserDO authenticate(String mobile, String password) {
        MemberUserDO memberUserDO = memberUserMapper.selectUserByMobile(mobile);
        if (memberUserDO == null) {
            throw new UsernameAlreadyExistsException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        if (!passwordEncoder.matches(password, memberUserDO.getPassword())) {
            throw new UserPasswordNotMatchException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        return memberUserDO;
    }
}
