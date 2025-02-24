// vite.config.ts
import vueSetupExtend from 'unplugin-vue-setup-extend-plus/vite'
import { PluginOption } from 'vite'

export default function createSetupExtend():PluginOption {
  return vueSetupExtend({ /* options */ })
}
