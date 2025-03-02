import request from '@/utils/request.ts'
import type { CommonResult } from '@/types/response'
import type { LoginUserVO, userRegisterDTO } from '@/types/user'

// 登录
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

// 注册
export function register(account: string, password: string, checkPassword: string) {
  return request<CommonResult<userRegisterDTO>>({
    url: '/user/register',
    method: 'post',
    data: {
      account,
      password,
      checkPassword
    }
  })
}
