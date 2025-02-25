import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

import 'normalize.css/normalize.css' // A modern alternative to CSS resets

const app = createApp(App)
app.use(router)

app.mount('#app')
