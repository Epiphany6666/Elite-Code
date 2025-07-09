import { defineStore } from 'pinia'
import type { SettingsState } from '@/store/types'

const useSettingsStore = defineStore('settings', {
  state: () => ({
    title: '',
    theme: '#333'
  } as SettingsState),
  actions: {
    setTitle(title: string) {
      this.title = title
      if (this.title) {
        document.title = this.title + ' - ' + import.meta.env.VITE_APP_TITLE
      } else {
        document.title = import.meta.env.VITE_APP_TITLE
      }
    }
  }
})

export default useSettingsStore
