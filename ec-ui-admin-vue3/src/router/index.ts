import {createRouter, createWebHistory} from "vue-router";
import Layout from '@/layout/index.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
          path: '/login',
          component: () => import('@/views/login/index.vue')
        },
        {
            path: '/',
            component: Layout,
            redirect: '/system/user',
            children: [
                {
                    path: '/system/user',
                    component: () => import('@/views/system/user/index.vue')
                },
                {
                    path: '/system/role',
                    component: () => import('@/views/system/role/index.vue')
                },
                {
                    path: '/resume/question',
                    component: () => import('@/views/resume/question/index.vue')
                },
                {
                    path: '/resume/problemset',
                    component: () => import('@/views/resume/problemset/index.vue')
                }
            ]
        }
    ]
})

export default router