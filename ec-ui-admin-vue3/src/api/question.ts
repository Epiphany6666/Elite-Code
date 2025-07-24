import type {
    QuestionAddReqVO,
    QuestionDO,
    QuestionQueryReqVO,
    QuestionQueryRespVO,
    QuestionUpdateReqVO
} from "@/types/quetion";
import request from "@/utils/request.ts";
import type {CommonPage} from "@/types/axios";

/* 根据分页条件查询题目信息 */
export function getQuestionPage(questionQueryReqVO: QuestionQueryReqVO) {
    return request<CommonPage<QuestionDO>>({
        url: '/admin-api/question/list',
        method: 'post',
        data: questionQueryReqVO
    })
}

/* 根据id查询题目信息 */
export function getQuestion(questionId?: string) {
    return request<QuestionQueryRespVO>({
        url: '/admin-api/question/' + parseStrEmpty(questionId),
        method: 'get'
    })
}

/* 新增题目 */
export function addQuestion(questionAddReqVO?: QuestionAddReqVO) {
    return request<string>({
        url: '/admin-api/question',
        method: 'post',
        data: questionAddReqVO
    })
}

/* 根据id更新题目信息 */
export function updateQuestion(questionUpdateReqVO?: QuestionUpdateReqVO) {
    return request({
        url: '/admin-api/question',
        method: 'put',
        data: questionUpdateReqVO
    })
}

/* 批量删除题目 */
export function removeQuestions(questionIds) {
    return request({
        url: '/admin-api/question/' + questionIds,
        method: 'delete'
    })
}

function parseStrEmpty(str: undefined | string) {
    if (!str) {
        return ''
    }
    return str
}