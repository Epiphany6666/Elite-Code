import type {ProblemsetAddReqVO, ProblemsetDO, ProblemsetQueryReqVO, ProblemsetUpdateReqVO} from "@/types/problemset";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

export function getProblemsetPage(problemsetQueryReqVO: ProblemsetQueryReqVO) {
    return request<CommonPage<ProblemsetDO>>({
        url: '/admin-api/problemset/list',
        method: 'post',
        data: problemsetQueryReqVO
    })
}

export function removeProblemset(problemsetIds: string) {
    return request({
        url: '/admin-api/problemset/' + problemsetIds,
        method: 'delete'
    })
}

export function getProblemset(problemsetId: string) {
    return request<ProblemsetDO>({
        url: '/admin-api/problemset/' + problemsetId,
        method: 'get'
    })
}

/* 新增题库 */
export function addProblemset(problemsetAddReqVO: ProblemsetAddReqVO) {
    return request<string>({
        url: '/admin-api/problemset',
        method: 'post',
        data: problemsetAddReqVO
    })
}

/* 根据id修改题库信息 */
export function updateProblemset(problemsetUpdateReqVO: ProblemsetUpdateReqVO) {
    return request({
        url: '/admin-api/problemset',
        method: 'put',
        data: problemsetUpdateReqVO
    })
}