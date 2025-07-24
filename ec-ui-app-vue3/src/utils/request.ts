import axios, { type AxiosInstance } from 'axios'
import useUserStore from '@/store/modules/user.ts'
import { getToken } from '@/utils/auth.ts'

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
// 创建axios实例
const request: AxiosInstance = axios.create({
  baseURL: import.meta.env.VITE_APP_BASE_API, // api的base_url
  timeout: 10000, // 请求超时时间
});

// request拦截器
request.interceptors.request.use(function (config) {
  // Do something before request is sent
  config.headers.set("Authorization", "Bearer " + getToken())
  return config;
}, function (error) {
  // Do something with request error
  return Promise.reject(error);
});

// response拦截器
request.interceptors.response.use(response => {
  const res = response.data
  if (res.code === 401) {
    useUserStore().logOut().then(() => {
      location.reload() // 为了重新实例化vue-router对象，避免bug，例如缓存
    })
    return Promise.reject('无效的会话，或者会话已过期，请重新登录。')
  } else if (res.code !== 200) {
    ElMessage.error(res.msg)
    return Promise.reject('error')
  } else {
    return response.data;
  }
}, error => {
  let { message } = error
  if (message == "Network Error") {
    message = "后端接口连接异常"
  } else if (message.includes("timeout")) {
    message = "系统接口请求超时"
  } else if (message.includes("Request failed with status code")) {
    message = "系统接口" + message.substring(message.length - 3) + "异常"
  }
  ElMessage({
    message: message,
    type: 'error',
    duration: 3 * 1000
  })
  return Promise.reject(error);
});

export default request
