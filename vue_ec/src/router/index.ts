import { createWebHistory, createRouter, type RouteRecordRaw } from 'vue-router'
import Layout from '@/views/layout/index.vue'

const constantRoutes:Array<RouteRecordRaw> = [
  // { path: '/', component: HomeView },
  {
    path: '/login',
    component: () => import('@/views/login/index.vue'),
  },
  {
    path: '/register',
    component: () => import('@/views/register/index.vue')
  },
  {
    path: '',
    component: Layout,
    redirect: '/home',
    children: [
      {
        path: 'home',
        component: () => import('@/views/home/index.vue')
      },
      {
        path: 'about',
        component: () => import('@/views/about/index.vue')
      }
    ]
  },
  {
    path: '/404',
    component: () => import('@/views/error/404.vue'),
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/404'
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes,
})

export default router
