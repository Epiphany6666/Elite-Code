import AutoImport from 'unplugin-auto-import/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'
import { Plugin } from 'vite'

export default function createAutoImport(): Plugin {
  return AutoImport({
    resolvers: [ElementPlusResolver()],
  })
}
