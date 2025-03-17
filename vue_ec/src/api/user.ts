import request from '@/utils/request.ts'
import type { UserLoginVO, UserAddDTO, UserRegisterDTO } from '@/types/user'
import type { CommonResult } from '@/types/axios'

// 登录
export function login(username: string, password: string) {
  return request<CommonResult<UserLoginVO>>({
    url: '/user/login',
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
    url: '/user/register',
    method: 'post',
    data: {
      username,
      password,
      checkPassword
    }
  })
}

// 新增用户
export function addUser(userAddDTO: UserAddDTO) {
  return request({
    url: '/user/',
    method: 'post',
    data: userAddDTO
  })
}

// 获取用户信息
export function getInfo() {
  return request({
    url: '/user/getInfo',
    method: 'get'
  })
}

// 退出登录
export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
