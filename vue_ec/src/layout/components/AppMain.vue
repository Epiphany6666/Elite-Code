<script setup lang="ts" name="AppMain">
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
  <section class="app-main">
    <router-view v-slot="{ Component }" :key="route.fullPath">
      <transition name="fade" mode="out-in">
        <component :is="Component" />
      </transition>
    </router-view>
  </section>
</template>

<style scoped>
.app-main {
  margin: 0 5px;
  padding: 24px;
}
</style>
