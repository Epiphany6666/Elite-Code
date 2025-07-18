export declare interface ProblemsetQueryDTO {
  title?: string
  createBy?: string
  updateBy?: string
  startTime?: string
  endTime?: string
}

export declare interface ProblemsetType {
  id: string
  title: string
  description: string
  picture: string
  delFlag: string
  createBy: string
  createTime: string
  updateBy: string
  updateTime: string
}

export declare interface ProblemQueryQuestionDTO {
  problemsetId?: string
  problemsetTitle?: string
  problemsetContent?: string
}
