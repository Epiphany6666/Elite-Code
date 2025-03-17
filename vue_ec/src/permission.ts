import router from '@/router/index.ts'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { getToken } from '@/utils/auth.js'
import useUserStore from '@/store/modules/user.ts'

const whiteList = ['/login', '/register'] // 不重定向白名单

router.beforeEach((to) => {
  NProgress.start()
  if (getToken()) {
    if (to.path === '/login') {
      return '/'
    } else {
      useUserStore().getInfo().catch(error => {
        ElMessage.error(error)
        return '/'
      })
    }
  } else if (whiteList.includes(to.path)) {
    return true
  } else {
    return '/login'
  }
})

router.afterEach(() => {
  NProgress.done()
})
