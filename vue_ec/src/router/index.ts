import { createWebHistory, createRouter, type RouteRecordRaw } from 'vue-router'
import Layout from '@/layout/index.vue'

export const constantRoutes: Array<RouteRecordRaw> = [
  {
    path: '/login',
    component: () => import('@/views/login/index.vue'),
    meta: {
      hidden: true
    }
  },
  {
    path: '/register',
    component: () => import('@/views/register/index.vue'),
    meta: {
      hidden: true
    }
  },
  {
    path: '/',
    component: () => import('@/views/problemset/index.vue'),
    meta: {
      title: '题库'
    }
  },
  {
    path: '/problemset/:id',
    component: () => import('@/views/question/index.vue'),
    meta: {
      title: '题目',
      hidden: true
    }
  },
  {
    path: '/question/:id',
    component: () => import("@/views/questionDetail/index.vue"),
    meta: {
      title: '题目详情',
      hidden: true
    }
  },
  {
    path: '/contest',
    component: () => import('@/views/contest/index.vue'),
    meta: {
      title: '竞赛'
    }
  },
  {
    path: '/404',
    component: () => import('@/views/error/404.vue'),
    meta: {
      hidden: true
    }
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/404',
    meta: {
      hidden: true
    }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes: constantRoutes
})

export default router
