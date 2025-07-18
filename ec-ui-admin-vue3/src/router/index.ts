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
            path: "/",
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
                }
            ]
        }
    ]
})

export default router