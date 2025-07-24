package cn.elitecode.module.member.service.auth;

import cn.elitecode.framework.common.enums.HttpStatus;
import cn.elitecode.framework.common.exception.BaseException;
import cn.elitecode.framework.security.core.LoginUser;
import cn.elitecode.framework.security.core.enums.UserTypeEnum;
import cn.elitecode.framework.security.core.utils.JwtTokenUtil;
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
        LoginUser loginUser = new LoginUser(memberUserDO.getId(), UserTypeEnum.MEMBER.getValue(), Arrays.asList(new SimpleGrantedAuthority("TEST")));
        String token = jwtTokenUtil.createToken(loginUser);
        return token;
    }

    @Override
    public Long register(String phone, String password) {
        MemberUserDO memberUserDO = new MemberUserDO();
        memberUserDO.setMobile(phone);
        memberUserDO.setPassword(passwordEncoder.encode(password));
        memberUserMapper.insertUser(memberUserDO);
        return memberUserDO.getId();
    }

    private MemberUserDO authenticate(String mobile, String password) {
        MemberUserDO memberUserDO = memberUserMapper.selectUserByMobile(mobile);
        if (memberUserDO == null) {
            throw new BaseException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        if (!passwordEncoder.matches(password, memberUserDO.getPassword())) {
            throw new BaseException(HttpStatus.PARAMS_ERROR, "账号或密码错误");
        }
        return memberUserDO;
    }
}
