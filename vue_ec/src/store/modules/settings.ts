import { defineStore } from 'pinia'

const useSettingsStore = defineStore('settings', {
  state: () => ({
    title: '',
    theme: '#333'
  }),
  actions: {
    setTitle(title) {
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
