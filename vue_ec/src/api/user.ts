import request from '@/utils/request.ts'
import type { CommonResult } from '@/types/response'
import type { LoginUserVO } from '@/types/user'

export function login(account: string, password: string) {
  return request<CommonResult<LoginUserVO>>({
    url: '/user/login',
    method: 'post',
    data: {
      account,
      password
    }
  })
}
