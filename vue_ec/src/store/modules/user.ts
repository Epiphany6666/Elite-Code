import { defineStore } from 'pinia'
import type { UserState } from '@/types/userState.d.ts'
import type { UserLoginDTO } from '@/types/user'
import { login } from '@/api/user.ts'
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
    login(userInfo: UserLoginDTO) {
      const username = userInfo.username
      const password = userInfo.password
      return new Promise((_, reject) => {
        login(username, password).then(res => {
          const { tokenHead, token } = res.data
          const tokenStr = tokenHead + token
          setToken(tokenStr)
          this.token = tokenStr
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
})

export default useUserStore
