import vueDevTools from 'vite-plugin-vue-devtools'
import { PluginOption } from 'vite'

export default function createDevTools():PluginOption {
  return vueDevTools()
}
