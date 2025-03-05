import axios, { type AxiosInstance } from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
// 创建axios实例
const request: AxiosInstance = axios.create({
  baseURL: 'http://localhost:8901/', // api的base_url
  timeout: 10000, // 请求超时时间
});

// request拦截器
request.interceptors.request.use(function (config) {
  // Do something before request is sent
  return config;
}, function (error) {
  // Do something with request error
  return Promise.reject(error);
});

// response拦截器
request.interceptors.response.use(response => {
  const res = response.data
  if (res.code !== 200) {
    console.log("res", res)
    ElMessage.error(res.msg)
    return Promise.reject('error')
  } {
    return response.data;
  }
}, error => {
  return Promise.reject(error);
});

export default request
