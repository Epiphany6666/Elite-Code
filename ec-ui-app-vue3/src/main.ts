import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import pinia from './store/index.ts'
import 'virtual:svg-icons-register'
import 'normalize.css/normalize.css' // A modern alternative to CSS resets
import '@/assets/styles/index.scss' // global css
import SvgIcon from '@/components/SvgIcon/index.vue'
import '@/permission' // 权限控制
import 'bytemd/dist/index.css'
import 'highlight.js/styles/github.css'

const app = createApp(App)
app.use(router)
app.use(pinia)

app.component('SvgIcon', SvgIcon)
app.mount('#app')
