export declare interface LoginUserVO {
  /** 用户ID */
  id: string
  /** 账号 */
  account: string
  /** 用户昵称 */
  nickName: string
  /** 用户头像 */
  avatar: string
  /** 用户简介 */
  profile: string
  /** 用户角色：user/admin/ban */
  roles: string[]
  /** 创建者 */
  createBy: string
  /** 创建时间 */
  createTime: Date
  /** 更新者 */
  updateBy: string
  /** 编辑时间 */
  updateTime: Date
}
