import { createSvgIconsPlugin } from 'vite-plugin-svg-icons'
import * as path from 'node:path'

export default function CreateSvgIcon() {
  return createSvgIconsPlugin({
    // Specify the icon folder to be cached
    iconDirs: [path.resolve(process.cwd(), 'src/assets/icons')],
    // Specify symbolId format
    symbolId: 'icon-[dir]-[name]',
  })
}
