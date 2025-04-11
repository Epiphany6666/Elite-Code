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
    url: '/problemset/list',
    method: 'post',
    data: problemsetQueryDTO
  })
}

/**
 * 根据分页条件查询所在题库的题目
 * @param problemQueryQuestionDTO
 */
export function listProblemsetQuestion(problemQueryQuestionDTO: ProblemQueryQuestionDTO) {
  return request<CommonPage<QuestionType>>({
    url: '/problemset/questionList',
    method: 'post',
    data: problemQueryQuestionDTO
  })
}
