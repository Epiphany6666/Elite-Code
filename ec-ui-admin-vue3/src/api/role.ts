import type {RoleAddReqVO, RoleDO, RoleQueryReqVO} from "@/types/role";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

/* 分页获取角色信息 */
export function getRolePage(roleQueryReqVO: RoleQueryReqVO) {
    return request<CommonPage<RoleDO>>({
        url: '/admin-api/system/role/list',
        method: 'post',
        data: roleQueryReqVO
    })
}

/* 新增角色 */
export function addRole(roleAddReqVO: RoleAddReqVO) {
    return request<string>({
        url: '/admin-api/system/role',
        method: 'post',
        data: roleAddReqVO
    })
}

/* 根据id数组批量删除角色信息 */
export function removeRoles(ids) {
    return request({
        url: '/admin-api/system/role/' + ids,
        method: 'delete'
    })
}