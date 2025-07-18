import router from '@/router/index.ts'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import {getToken} from "@/utils/auth.ts";
import {useUserStore} from "@/store/modules/user.ts";
import {ElMessage} from "element-plus";

const whiteList = ['/login', '/register', '/404']
router.beforeEach((to, from) => {
    NProgress.start();
    if (getToken()) {
        if (to.path === '/login' || to.path === '/register') {
            return '/'
        } else {
            useUserStore().getInfo().then(() => {
                return true
            }).catch(error => {
                useUserStore().logout().then(() => {
                    ElMessage.error(error || 'Verification failed, please login again')
                    return '/'
                })
            })
        }
    } else {
        if (whiteList.includes(to.path)) {
            return true
        } else {
            return `/login`
        }
    }
})

router.afterEach((to, from) => {
    NProgress.done()
})