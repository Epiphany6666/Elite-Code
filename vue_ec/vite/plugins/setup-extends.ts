// vite.config.ts
import vueSetupExtend from 'unplugin-vue-setup-extend-plus/vite'
import { Plugin } from 'vite'

export default function createSetupExtend() {
  return vueSetupExtend({ /* options */ })
}
