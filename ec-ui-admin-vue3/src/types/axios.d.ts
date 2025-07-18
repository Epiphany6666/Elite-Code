export declare interface CommonPage<T> {
    total: number
    list: Array<T>
}

//
declare module 'axios' {
    export interface AxiosResponse<T = unknown> {
        msg: string
        code: string
        data: T | CommonPage<T>
    }
}