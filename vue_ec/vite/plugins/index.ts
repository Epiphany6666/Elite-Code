import vue from '@vitejs/plugin-vue'
import createSetupExtend  from './setup-extends'
import createDevTools from './dev-tools'
import createAutoImport from './auto-import'
import createAutoComponents from './auto-components'

export default function createVitePlugins() {
  const vitePlugins = [vue()]
  vitePlugins.push(createSetupExtend())
  vitePlugins.push(createDevTools())
  vitePlugins.push(createAutoImport())
  vitePlugins.push(createAutoComponents())
  return vitePlugins
}
