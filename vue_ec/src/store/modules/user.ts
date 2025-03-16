import { defineStore } from 'pinia'
import type { UserState } from '@/types/userState.d.ts'
import type { UserLoginDTO } from '@/types/user'
import { getInfo, login } from '@/api/user.ts'
import { getToken, setToken } from '@/utils/auth.ts'

const useUserStore = defineStore('user', {
  state: () => ({
    token: getToken(),
    id: '',
    username: '',
    avatar: '',
    roles: []
  } as UserState),
  actions: {
    // 登录
    login(userInfo: UserLoginDTO) {
      const username = userInfo.username
      const password = userInfo.password
      return new Promise((resolve, reject) => {
        login(username, password).then(res => {
          const { tokenHead, token } = res.data
          const tokenStr = tokenHead + token
          setToken(tokenStr)
          this.token = tokenStr
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 获取用户信息
    getInfo() {
      return new Promise((resolve, reject) => {
        getInfo().then(res => {
          const user = res.data
          this.id = user.id
          this.username = user.username
          this.avatar = user.avatar
          this.roles = user.roles
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
})

export default useUserStore
