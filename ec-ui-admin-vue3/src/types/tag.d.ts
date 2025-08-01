export declare interface TagDO {
    createBy?: string
    createTime?: Date
    delFlag?: string
    id?: string
    name?: string
    updateBy?: string
    updateTime?: Date
}

export declare interface TagAddDTO {
    name: string
}

export declare interface TagQueryDTO {
    createBy?: string
    current?: number
    endTime?: Date
    name?: string
    pageSize?: number
    sortFieldPair?: Array<string>
    startTime?: Date
    updateBy?: string
}

export declare interface TagUpdateDTO {
    id: string
    name: string
}