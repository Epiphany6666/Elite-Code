<script setup lang="ts">
import {ArrowDown, Location,} from '@element-plus/icons-vue'
import Logo from "@/layout/components/Sidebar/Logo.vue";
import {useRoute} from "vue-router";
import {useUserStore} from "@/store/modules/user.ts";

const route = useRoute()
const userStore = useUserStore()

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

const logout = () => {
  userStore.logout().then(() => {
    location.reload()
  })
}
</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px">
        <Logo/>
        <el-menu
            :default-active="route.path"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            router
        >
          <el-sub-menu index="1">
            <template #title>
              <el-icon>
                <location/>
              </el-icon>
              <span>系统管理</span>
            </template>
            <el-menu-item index="/system/user">用户管理</el-menu-item>
            <el-menu-item index="/system/role">角色管理</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <el-dropdown>
            <span class="el-dropdown-link">
              <el-avatar size="small" :src="userStore.avatar" />
              <span>{{ userStore.nickName }}</span>
              <el-icon class="el-icon--right">
                <arrow-down/>
              </el-icon>
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item>个人中心</el-dropdown-item>
                <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-header>

        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
</style>
