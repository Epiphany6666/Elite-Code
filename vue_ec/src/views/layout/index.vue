<script setup lang="ts">
import { CaretBottom, Document, Menu } from '@element-plus/icons-vue'
import useUserStore from '@/store/modules/user'
const userStore = useUserStore()
</script>

<template>
  <div>
    <el-container>
      <el-aside width="200px">
        <div class="title">易扣刷题平台</div>
        <el-menu
          default-active="/home"
          class="el-menu-vertical-demo"
          background-color="#6a9af1"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
          unique-opened
        >
          <el-menu-item index="/home">
            <el-icon><Menu /></el-icon>
            <span>HOME</span>
          </el-menu-item>
          <el-menu-item index="/about">
            <el-icon><document /></el-icon>
            <span>ABOUT</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header class="homeHeader">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">homepage</el-breadcrumb-item>
            <el-breadcrumb-item>
              <a href="/">promotion management</a>
            </el-breadcrumb-item>
            <el-breadcrumb-item>promotion list</el-breadcrumb-item>
            <el-breadcrumb-item>promotion detail</el-breadcrumb-item>
          </el-breadcrumb>
          <div>
            <el-dropdown placement="bottom-end" trigger="click">
              <div class="avatar-wrapper">
                <el-avatar shape="square" class="user-avatar" :src="userStore.avatar || '/notLoginUser.png'" />
                <el-icon><CaretBottom /></el-icon>
              </div>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>个人中心</el-dropdown-item>
                  <el-dropdown-item divided>退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.homeHeader {
  background: #5b9cf8;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.title {
  font-size: 30px;
  color: #ffffff;
  background-color: #5b9cf8;
  height: 60px;
  line-height: 60px;
}

.avatar-wrapper {
  display: flex;
  justify-content: center;
  align-items: end;
  cursor: pointer;
}

.avatar-wrapper .user-avatar {
}
</style>
