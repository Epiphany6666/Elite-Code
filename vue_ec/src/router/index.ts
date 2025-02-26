import { createWebHistory, createRouter, type RouteRecordRaw } from 'vue-router'

const constantRoutes:Array<RouteRecordRaw> = [
  // { path: '/', component: HomeView },
  {
    path: '/login',
    component: () => import('@/views/login/index.vue'),
  },
  {
    path: '/register',
    component: () => import('@/views/register/index.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,
})

export default router
