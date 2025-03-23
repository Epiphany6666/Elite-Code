import { defineStore } from 'pinia'
import { constantRoutes } from '@/router/index.ts'

const usePermissionStore = defineStore('permission', {
  state: () => ({
    routes: constantRoutes
  })
})

export default usePermissionStore
