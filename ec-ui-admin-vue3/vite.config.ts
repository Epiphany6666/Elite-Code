import { fileURLToPath, URL } from 'node:url'
import { defineConfig, loadEnv } from 'vite'
import createVitePlugins from './vite/plugins'

// https://vite.dev/config/#conditional-config
export default defineConfig(({ mode }) => {
  // https://vite.dev/guide/api-javascript.html#loadenv
  // https://vite.dev/config/shared-options.html#root
  const env = loadEnv(mode, process.cwd())
  return {
    plugins: createVitePlugins(),
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url))
      },
    },
    server: {
      host: true,
      port: 80,
      // https://vite.dev/config/server-options.html#server-proxy
      proxy: {
        [env.VITE_APP_BASE_API]: {
          target: env.VITE_API_URL,
          changeOrigin: true, // 需要代理跨域
          rewrite: (path) => path.replace(new RegExp(`^${env.VITE_APP_BASE_API}`), '')
        }
      }
    }
  }
})
