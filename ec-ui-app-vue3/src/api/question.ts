import request from '@/utils/request.ts'
import type { QuestionType } from '@/types/question'

export function getQuestionById(questionId) {
  return request<QuestionType>({
    url: `/app-api/question/get?id=` + questionId,
    method: 'get'
  })
}
