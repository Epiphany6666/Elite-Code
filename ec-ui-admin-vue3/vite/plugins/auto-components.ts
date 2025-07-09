import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import Components from 'unplugin-vue-components/vite'
import { Plugin } from 'vite'

export default function createAutoComponents():Plugin {
  return Components({
    resolvers: [ElementPlusResolver()],
  })
}
