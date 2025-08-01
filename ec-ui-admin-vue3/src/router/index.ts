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
                    path: 'system',
                    children: [
                        {
                            path: 'user',
                            component: () => import('@/views/system/user/index.vue')
                        },
                        {
                            path: 'role',
                            component: () => import('@/views/system/role/index.vue')
                        }
                    ]
                },
                {
                    path: 'resume',
                    children: [
                        {
                            path: 'question',
                            component: () => import('@/views/resume/question/index.vue')
                        },
                        {
                            path: 'problemset',
                            component: () => import('@/views/resume/problemset/index.vue')
                        },
                        {
                            path: 'tag',
                            component: () => import('@/views/resume/tag/index.vue')
                        }
                    ]
                }
            ]
        },
    ]
})

export default router