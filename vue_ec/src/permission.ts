import router from '@/router/index.ts'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css'// Progress 进度条样式
import { getToken } from '@/utils/auth.js'
import useUserStore from '@/store/modules/user.ts'
import useSettingsStore from '@/store/modules/settings.ts'

const whiteList = ['/login', '/register'] // 不重定向白名单
router.beforeEach((to) => {
  NProgress.start()
  // 动态设置网页标题
  if (to.meta.title) {
    useSettingsStore().setTitle(to.meta.title)
  }
  if (getToken()) {
    if (to.path === '/login' || to.path === '/register') {
      return '/'
    } else {
      useUserStore().getInfo().then(() => {
        return true
      }).catch(error => {
        useUserStore().logOut().then(() => {
          ElMessage.error(error || 'Verification failed, please login again')
          return '/'
        })
      })
    }
  } else {
    // 没有token
    if (whiteList.includes(to.path)) {
      // 在免登录白名单，直接进入
      return true
    } else {
      return `/login?redirect=${to.fullPath}` // 否则全部重定向到登录页
    }
  }
})

router.afterEach(() => {
  NProgress.done()
})
