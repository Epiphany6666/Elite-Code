import type {UserDO, UserQueryReqVO} from "@/types/user";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

export function listUser(userQueryReqVO: UserQueryReqVO) {
    return request<CommonPage<UserDO>>({
        url: '/admin-api/system/user/list',
        method: 'post',
        data: userQueryReqVO
    })
}