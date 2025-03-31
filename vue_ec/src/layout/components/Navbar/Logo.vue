<script setup lang="ts" name="Logo">
import { useRouter } from 'vue-router'

const router = useRouter()
const goHome = () => {
  router.push({ path: '/' })
}
</script>

<template>
  <div class="navbar-logo-container" @click="goHome">
    <img class="navbar-logo" src="/favicon.ico" />
    <span class="navbar-title">易扣</span>
  </div>
</template>
