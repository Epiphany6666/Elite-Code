<script setup lang="ts" name="Layout">
import { CaretBottom } from '@element-plus/icons-vue'
import useUserStore from '@/store/modules/user.ts'
import AppMain from '@/layout/components/AppMain.vue'
import Navbar from '@/layout/components/Navbar/index.vue'

const userStore = useUserStore()
const handleCommand = (command: string) => {
  switch (command) {
    case 'logout':
      logout()
      break
    default:
      break
  }
}

const logout = () => {
  userStore.logOut().then(() => {
    location.reload() // 为了重新实例化vue-router对象，避免bug，例如缓存
  })
}
</script>

<template>
  <div class="app-wrapper">
    <div class="header-container">
      <navbar />
      <div class="avatar-container">
        <el-dropdown placement="bottom-end" trigger="click" @command="handleCommand">
          <div class="avatar-wrapper">
            <img :src="userStore.avatar || '/notLoginUser.png'" class="user-avatar">
          </div>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item>个人中心</el-dropdown-item>
              <el-dropdown-item divided command="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
    <div class="main-container">
      <app-main />
    </div>
    <div class="footer-container">
      <div class="footer-nav">
        <div class="nav-item">
          <span class="nav-title">易扣 EliteCode</span>
          <router-link to="#">竞赛</router-link>
          <router-link to="#">EliteBook</router-link>
          <router-link to="#">讨论社区</router-link>
          <router-link to="#">求职</router-link>
        </div>
        <div class="nav-item">
          <span class="nav-title">企业服务</span>
          <router-link to="#">在线面试</router-link>
          <router-link to="#">企业测评</router-link>
          <router-link to="#">招聘</router-link>
          <router-link to="#">培训</router-link>
        </div>
        <div class="nav-item">
          <span class="nav-title">商务</span>
          <router-link to="#">社区合作</router-link>
          <router-link to="#">活动</router-link>
          <router-link to="#">赞助竞赛</router-link>
          <router-link to="#">产品推广</router-link>
        </div>
        <div class="nav-item">
          <span class="nav-title">关于我们</span>
          <router-link to="#">价值观</router-link>
          <router-link to="#">工作机会</router-link>
        </div>
      </div>
    </div>
  </div>
</template>
