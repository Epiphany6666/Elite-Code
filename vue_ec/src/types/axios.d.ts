import 'axios'

export declare interface CommonPage<T = unknown> {
  total: number,
  list: Array<T>
}

// 扩展 axios 数据返回类型(因为在请求拦截器中去掉了一层data)
declare module 'axios' {
  export interface AxiosResponse<T = unknown> {
    msg: string
    code: string
    data: T | CommonPage
  }
}
