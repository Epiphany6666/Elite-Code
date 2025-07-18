import request from "@/utils/request.ts";
import type {UserLoginReqVO, LoginUserVO, UserDO} from "@/types/user.d.ts";

// 用户登录
export function login(userLoginReqVO: UserLoginReqVO) {
    return request<LoginUserVO>({
        url: '/admin-api/system/login',
        method: 'post',
        data: userLoginReqVO
    })
}

// 获取用户信息
export function getInfo() {
    return request<UserDO>({
        url: '/admin-api/system/getInfo',
        method: 'get'
    })
}

// 退出登录
export function logou() {
    return request({
        url: '/logout',
        method: 'post'
    })
}