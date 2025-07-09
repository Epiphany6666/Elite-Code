package cn.elitecode.module.member.service.user;

import cn.elitecode.framework.common.pojo.CommonPage;
import cn.elitecode.framework.security.core.utils.SecurityUtil;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserQueryReqVO;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;
import cn.elitecode.module.member.dal.mysql.MemberUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberUserServiceImpl implements MemberUserService {

    @Autowired
    private MemberUserMapper memberUserMapper;

    @Override
    public void updateUser(MemberUserUpdateReqVO reqVO) {
        MemberUserDO memberUserDO = new MemberUserDO();
        BeanUtils.copyProperties(reqVO, memberUserDO);
        memberUserDO.setUpdateBy(SecurityUtil.getUserId());
        memberUserDO.setUpdateTime(new Date());
        memberUserMapper.updateUserById(memberUserDO);
    }

    @Override
    public MemberUserDO getUserById(Long userId) {
        MemberUserDO memberUserDO = memberUserMapper.selectUserById(userId);
        return memberUserDO;
    }

    @Override
    public CommonPage<MemberUserDO> selectUserList(MemberUserQueryReqVO reqVO) {
        if (reqVO.getCurrent() != null && reqVO.getPageSize() != null) {
            reqVO.setCurrent((reqVO.getCurrent() - 1) * reqVO.getPageSize());
        }
        List<MemberUserDO> memberUserDOList = memberUserMapper.selectUserList(reqVO);
        Long total = memberUserMapper.selectTotalByPage(reqVO);
        CommonPage<MemberUserDO> memberUserCommonPage = new CommonPage<>(total, memberUserDOList);
        return memberUserCommonPage;
    }
}




