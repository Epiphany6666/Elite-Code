<script setup lang="ts">
import {Location,} from '@element-plus/icons-vue'
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
          <el-sub-menu index="/system">
            <template #title>
              <el-icon>
                <Tools />
              </el-icon>
              <span>系统管理</span>
            </template>
            <el-menu-item index="/system/user">用户管理</el-menu-item>
            <el-menu-item index="/system/role">角色管理</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="/resume">
            <template #title>
              <el-icon><ChatLineRound /></el-icon>
              <span>面试管理</span>
            </template>
            <el-menu-item index="/resume/question">题目管理</el-menu-item>
            <el-menu-item index="/resume/problemset">题库管理</el-menu-item>
            <el-menu-item index="/resume/tag">标签管理</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header>
          <el-dropdown>
            <span class="el-dropdown-link">
              <el-avatar size="default" :src="userStore.avatar" />
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

<style scoped lang="scss">
.el-header {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  .el-dropdown {
    cursor: pointer;
  }
}
</style>
