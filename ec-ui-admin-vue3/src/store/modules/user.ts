import {defineStore} from "pinia";
import {getToken, removeToken} from "@/utils/auth.ts";
import {getInfo, logou} from "@/api/login.ts";
import type {UserStore} from "@/store/types";

export const useUserStore = defineStore('admin-user', {
    state: () => ({
        token: getToken(),
        avatar: '',
        id: '',
        nickName: '',
        profile: '',
        roles: []
    } as UserStore),
    actions: {
        getInfo() {
            return new Promise((resolve, reject) => {
                getInfo().then(res => {
                    const user = res.data
                    this.avatar = user.avatar
                    this.id = user.id
                    this.nickName = user.nickName
                    this.profile = user.profile
                    this.roles = user.roleList
                    resolve(res)
                }).catch(error => {
                    reject(error)
                })
            })
        },
        logout() {
            return new Promise((resolve, reject) => {
                logou().then(() => {
                    this.token = getToken()
                    this.avatar = ''
                    this.id = ''
                    this.nickName = ''
                    this.profile = ''
                    this.roles = []
                    removeToken()
                    resolve('ok')
                }).catch(error => {
                    reject(error)
                })
            })
        }
    },
})