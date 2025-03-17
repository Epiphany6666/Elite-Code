import request from '@/utils/request.ts'
import type { LoginUserVO, UserAddDTO, UserRegisterDTO } from '@/types/user'

// 登录
export function login(username: string, password: string) {
  return request<LoginUserVO>({
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
  return request<UserRegisterDTO>({
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
    url: '/user/profle',
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
