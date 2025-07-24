package cn.elitecode.module.member.dal.mysql;

import cn.elitecode.module.member.controller.admin.user.vo.MemberUserQueryReqVO;
import cn.elitecode.module.member.dal.dataobject.user.MemberUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberUserMapper {

    /**
     * 根据id修改会员信息
     * @param memberUserDO
     */
    void updateUserById(MemberUserDO memberUserDO);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    MemberUserDO selectUserById(Long userId);

    /**
     * 根据分页条件查询会员信息列表
     * @param reqVO
     * @return
     */
    List<MemberUserDO> selectUserList(MemberUserQueryReqVO reqVO);

    /**
     * 根据分页条件查询会员数量
     * @param reqVO
     * @return
     */
    Long selectTotalByPage(MemberUserQueryReqVO reqVO);

    /**
     * 根据手机号查询会员信息
     * @param mobile
     * @return
     */
    MemberUserDO selectUserByMobile(String mobile);

    /**
     * 插入会员信息
     * @param memberUserDO
     */
    void insertUser(MemberUserDO memberUserDO);
}




