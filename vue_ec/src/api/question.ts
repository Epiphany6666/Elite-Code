import request from '@/utils/request.ts'
import type { QuestionType } from '@/types/question'

export function getQuestionById(questionId) {
  return request<QuestionType>({
    url: `/question/${questionId}`,
    method: 'get'
  })
}
