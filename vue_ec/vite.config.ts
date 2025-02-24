import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import createVitePlugins from './vite/plugins'

// https://vite.dev/config/
export default defineConfig({
  plugins: createVitePlugins(),
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
})
