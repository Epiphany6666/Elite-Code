import { defineStore } from 'pinia'
import type { UserState } from '@/types/userState.d.ts'

export const useUserStore = defineStore('user', {
  state: () => ({
    id: '',
    account: '',
    avatar: '',
    roles: []
  } as UserState)
})
