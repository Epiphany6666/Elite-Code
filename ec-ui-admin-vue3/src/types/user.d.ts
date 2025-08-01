import type {RoleDO} from "@/types/role.d.ts";

export declare interface UserLoginReqVO {
    username: string
    password: string
}

export declare interface LoginUserVO {
    token: string
    tokenHead: string
}

export declare interface UserDO {
    avatar?: string
    createBy?: string
    createTime?: Date
    delFlag?: string
    id?: string
    nickName?: string
    password?: string
    profile?: string
    roleList?: Array<RoleDO>
    updateBy?: string
    updateTime?: Date
    username?: string
}

export declare interface UserQueryReqVO {
    createBy?: string
    current?: number
    endTime?: Date
    nickName?: string
    pageSize?: number
    role?: string
    sortFieldPair?: Array<string>
    startTime?: Date
    dateRange?: Array<Date>
    updateBy?: string
    username?: string
}

export declare interface UserAddReqVO {
    avatar?: string
    nickName?: string
    password?: string
    profile?: string
    roleIds?: Array<string>
    username?: string
}

export declare interface UserUpdateReqVO {
    avatar?: string
    id?: string
    nickName?: string
    profile?: string
    roleIds?: Array<string>
    username?: string
}