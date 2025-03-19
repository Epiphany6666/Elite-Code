import request from '@/utils/request.ts'
import type { UserLoginVO, UserRegisterDTO } from '@/types/user'
import type { CommonResult } from '@/types/axios'

// 登录
export function login(username: string, password: string) {
  return request<CommonResult<UserLoginVO>>({
    url: '/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

// 注册
export function register(username: string, password: string, checkPassword: string) {
  return request<CommonResult<UserRegisterDTO>>({
    url: '/register',
    method: 'post',
    data: {
      username,
      password,
      checkPassword
    }
  })
}

// 获取用户信息
export function getInfo() {
  return request({
    url: '/getInfo',
    method: 'get'
  })
}

// 退出登录
export function logout() {
  return request({
    url: '/logout',
    method: 'post'
  })
}
