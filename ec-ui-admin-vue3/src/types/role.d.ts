export declare interface RoleDO {
    createBy: string
    createTime: Date
    delFlag: string
    id: string
    menuCheckStrictly: boolean
    name: string
    sort: number
    updateBy: string
    updateTime: Date
}

export declare interface RoleQueryReqVO {
    createBy?: string
    current?: number
    endTime?: Date
    name?: string
    pageSize?: number
    sortFieldPair?: Array<string>
    startTime?: Date
    updateBy?: string
}

export declare interface RoleAddReqVO {
    menuCheckStrictly?: boolean
    menuIds?: Array<string>
    name?: string
    sort?: number
}