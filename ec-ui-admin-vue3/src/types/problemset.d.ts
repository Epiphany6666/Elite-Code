export declare interface ProblemsetDO {
    createBy?: string
    createTime?: Date
    updateTime?: Date
    delFlag?: string
    description?: string
    id?: string
    picture?: string
    title?: string
    updateBy?: string
}

export declare interface ProblemsetQueryReqVO {
    createBy?: string
    current?: number
    endTime?: Date
    pageSize?: number
    sortFieldPair?: Array<string>
    startTime?: Date
    title?: string
    updateBy?: string
}

export declare interface ProblemsetAddReqVO {
    title: string,
    description: string
}

export declare interface ProblemsetUpdateReqVO {
    id: string
    title: string
    description: string
}