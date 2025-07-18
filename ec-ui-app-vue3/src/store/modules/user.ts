import { defineStore } from 'pinia'
import type { UserState } from '@/store/types'
import type { LoginForm } from '@/types/user'
import { getToken, removeToken, setToken } from '@/utils/auth.ts'
import { login, logout, getInfo } from '@/api/login.ts'

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
    login(userInfo: LoginForm) {
      const username = userInfo.username
      const password = userInfo.password
      return new Promise((resolve, reject) => {
        login(username, password).then(res => {
          const { tokenHead, token } = res.data
          const tokenStr = tokenHead + token
          setToken(tokenStr)
          this.token = tokenStr
          resolve(res)
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
    },
    logOut() {
      return new Promise((resolve, reject) => {
        logout().then(() => {
          this.token = ''
          this.roles = []
          removeToken()
          resolve('ok')
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
})

export default useUserStore
