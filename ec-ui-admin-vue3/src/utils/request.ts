// 创建实例时配置默认值
import axios from "axios";
import {getToken} from "@/utils/auth.ts";
import {useUserStore} from "@/store/modules/user.ts";
import {ElMessage} from "element-plus";

const request = axios.create({
    baseURL: import.meta.env.VITE_APP_BASE_API,
    timeout: 10000,
});

// 添加请求拦截器
request.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    config.headers.set('Authorization', 'Bearer ' + getToken())
    return config;
}, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
});

// 添加响应拦截器
request.interceptors.response.use(function (response) {
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    const res = response.data
    if (res.code === 401) {
        useUserStore().logout().then(() => {
            location.reload() // 为了重新实例化vue-router对象，避免bug，例如缓存
        })
        return Promise.reject('无效会话，或会话已过期，请重新登陆')
    } else if (res.code !== 200) {
        ElMessage.error(res.message)
        return Promise.reject('error')
    } else {
        return response.data
    }
}, function (error) {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    return Promise.reject(error);
});

export default request