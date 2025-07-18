import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";
import pinia from "@/store";
import '@/permmision.ts' // 权限控制

const app = createApp(App)
app.use(pinia)
app.use(router)
app.mount('#app')