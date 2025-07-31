import request from '@/utils/request.ts'
import type {
  ProblemQueryQuestionDTO,
  ProblemsetQueryDTO,
  ProblemsetType
} from '@/types/problemset'
import type { CommonPage } from '@/types/axios'
import type { QuestionType } from '@/types/question'

export function listProblemset(problemsetQueryDTO?: ProblemsetQueryDTO) {
  return request<CommonPage<ProblemsetType>>({
    url: '/app-api/problemset/list',
    method: 'post',
    data: problemsetQueryDTO
  })
}

export function getProblemsetAll() {
  return request({
    url: '/app-api/problemset/getAll',
    method: 'get'
  })
}

/**
 * 根据分页条件查询所在题库的题目
 * @param problemQueryQuestionDTO
 */
export function listProblemsetQuestion(problemQueryQuestionDTO: ProblemQueryQuestionDTO) {
  return request<CommonPage<QuestionType>>({
    url: '/app-api/problemset/page',
    method: 'get',
    params: problemQueryQuestionDTO
  })
}
