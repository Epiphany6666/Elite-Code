package cn.elitecode.module.member.service.user;

import cn.elitecode.common.api.CommonPage;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserQueryReqVO;
import cn.elitecode.module.member.controller.admin.user.vo.MemberUserUpdateReqVO;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;

/**
* member_user(会员信息表)|业务层
*/
public interface MemberUserService {

    /**
     * 更新会员信息
     * @param reqVO
     */
    void updateUser(MemberUserUpdateReqVO reqVO);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    MemberUserDO getUserById(Long userId);

    /**
     * 根据分页条件查询会员信息
     * @param reqVO
     * @return
     */
    CommonPage<MemberUserDO> selectUserList(MemberUserQueryReqVO reqVO);
}
