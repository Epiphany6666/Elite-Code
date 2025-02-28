import axios, { type AxiosInstance } from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
// 创建axios实例
const request: AxiosInstance = axios.create({
  baseURL: 'http://localhost:8901/', // api的base_url
  timeout: 10000, // 请求超时时间
});

export default request
