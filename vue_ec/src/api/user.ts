import request from '@/utils/request.ts'
import type { UserAddDTO } from '@/types/user'

// 新增用户
export function addUser(userAddDTO: UserAddDTO) {
  return request({
    url: '/user/',
    method: 'post',
    data: userAddDTO
  })
}
