import type {TagDO} from "@/types/tag";
import type {ProblemsetDO} from "@/types/problemset";

export declare interface QuestionDO {
    title?: string
    updateBy?: string
    answer?: string
    content?: string
    createBy?: string
    createTime?: Date
    delFlag?: string
    id?: string
}

export declare interface QuestionQueryRespVO {
    problemsetAll: Array<ProblemsetDO>
    problemsetIds?: Array<string>
    question?: QuestionDO
    tagAll: Array<TagDO>
    tagIds?: Array<string>
}

export declare interface QuestionQueryReqVO {
    createBy?: string
    current?: number
    endTime?: Date
    pageSize?: number
    sortFieldPair?: Array<string>
    startTime?: Date
    title?: string
    updateBy?: string
}

export declare interface QuestionAddReqVO {
    answer?: string
    content?: string
    problemsetIds?: Array<string>
    tagIds?: Array<string>
    title?: string
}

export declare interface QuestionUpdateReqVO {
    answer?: string
    content?: string
    id?: string
    problemsetIds?: Array<string>
    tagIds?: Array<string>
    title?: string
}