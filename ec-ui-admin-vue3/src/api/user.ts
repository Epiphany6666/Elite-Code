import type {UserAddReqVO, UserDO, UserQueryReqVO, UserUpdateReqVO} from "@/types/user";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

// 根据分页条件查询用户信息
export function listUser(userQueryReqVO: UserQueryReqVO) {
    return request<CommonPage<UserDO>>({
        url: '/admin-api/system/user/list',
        method: 'post',
        data: userQueryReqVO
    })
}

// 根据id查询用户信息
export function getUser(userId?: string) {
    return request({
        url: '/admin-api/system/user/' + parseStrEmpty(userId),
        method: 'get'
    })
}

// 新增用户
export function addUser(userAddReqVO: UserAddReqVO) {
    return request<number>({
        url: '/admin-api/system/user',
        method: 'post',
        data: userAddReqVO
    })
}

// 根据id更新用户信息
export function updateUser(userUpdateReqVO:UserUpdateReqVO) {
    return request({
        url: '/admin-api/system/user',
        method: 'put',
        data: userUpdateReqVO
    })
}

// 批量删除用户
export function removeUsers(ids: Array<string>) {
    console.log("@@ids", ids)
    return request({
        url: '/admin-api/system/user/' + ids,
        method: 'delete'
    })
}

const parseStrEmpty = (str?: string) => {
    console.log("@@str", str)
    if (!str || str === '') {
        return ''
    }
    else {
        return str
    }
}