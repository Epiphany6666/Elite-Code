<script setup lang="ts" name="Navbar">
import Logo from '@/layout/components/Navbar/Logo.vue'
import NavbarItem from '@/layout/components/Navbar/NavbarItem.vue'
import { useRoute } from 'vue-router'
import usePermissionStore from '@/store/modules/permission.ts'

const route = useRoute()
const permissionStore = usePermissionStore()
const routes = permissionStore.routes
</script>

<template>
  <div class="navbar-container">
    <Logo />
    <el-menu
      :default-active="route.path"
      mode="horizontal"
      text-color="#737373"
      active-text-color="#333"
      unique-opened
    >
      <navbar-item
        v-for="route in routes"
        :key="route.path"
        :route="route"
        :base-path="route.path"
      />
    </el-menu>
  </div>
</template>
