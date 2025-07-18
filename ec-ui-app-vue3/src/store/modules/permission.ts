import { defineStore } from 'pinia'
import { constantRoutes } from '@/router/index.ts'
import type { PermissionState } from '@/store/types'

const usePermissionStore = defineStore('permission', {
  state: () => ({
    routes: constantRoutes
  } as PermissionState)
})

export default usePermissionStore
