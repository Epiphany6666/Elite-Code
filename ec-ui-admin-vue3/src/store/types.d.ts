import type {RoleDO} from "@/types/role";

export declare interface UserStore {
    token?: string
    avatar?: string
    id?: string
    nickName?: string
    profile?: string
    roles?: Array<RoleDO>
}