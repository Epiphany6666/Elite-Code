import type { RouteRecordRaw } from 'vue-router'

export declare interface PermissionState {
  routes: Array<RouteRecordRaw>
}

export declare interface UserState {
  token: string,
  id: string
  username: string
  avatar: string
  roles: Array<string>
}

export declare interface SettingsState {
  title: string,
  theme: string
}

