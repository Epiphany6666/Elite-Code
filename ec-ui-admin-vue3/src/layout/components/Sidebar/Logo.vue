<script setup lang="ts">
import logo from '@/assets/logo/logo.png'
</script>

<template>
  <div class="sidebar-logo-container">
    <router-link to="/" class="sidebar-logo-link">
      <img :src="logo" class="sidebar-logo" />
      <h1 class="sidebar-title">易扣后台管理</h1>
    </router-link>
  </div>
</template>

<style scoped lang="scss">
.sidebar-logo-container {
  .sidebar-logo-link {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: black;
    .sidebar-logo {
      width: 32px;
      height: 32px;
    }
  }
}
</style>
