import type { ProblemsetType } from '@/types/problemset'

export declare interface QuestionType {
  id: string
  title: string
  content: string
  answer: string
  createBy: string
  createTime: string
  updateBy: string
  updateTime: string
  problemsets: Array<ProblemsetType>
}
