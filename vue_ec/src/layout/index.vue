<script setup lang="ts">
import { CaretBottom } from '@element-plus/icons-vue'
import Logo from '@/layout/components/Navbar/Logo.vue'
import useUserStore from '@/store/modules/user.ts'

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
      <Logo></Logo>
      <el-menu
        default-active="/home"
        mode="horizontal"
        active-text-color="black"
        router
        unique-opened
      >
        <el-menu-item index="/home">
          <span>HOME</span>
        </el-menu-item>
        <el-menu-item index="/about">
          <span>ABOUT</span>
        </el-menu-item>
      </el-menu>
      <div class="avatar-container">
        <el-dropdown placement="bottom-end" trigger="click" @command="handleCommand">
          <div class="avatar-wrapper">
            <img :src="userStore.avatar || '/notLoginUser.png'" class="user-avatar">
            <el-icon>
              <CaretBottom />
            </el-icon>
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
      <router-view />
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

<style scoped lang="scss">
.app-wrapper {

  .header-container {
    height: 50px;
    margin: 0 5px;
    padding: 0 24px;
    display: flex;

    .el-menu {
      flex: 1;
      height: 50px;
      margin-left: 22px;

      .el-menu-item {
        line-height: 50px;
        padding: 0;
        margin-right: 20px;
        color: #737373;

        &:hover {
          color: black;
        }
      }

      // 子选项悬浮背景
      --el-menu-hover-bg-color: #fff;
    }

    .el-menu--horizontal.el-menu {
      border-bottom: 0 !important;
    }

    .avatar-container {
      padding: 10px 0;

      .user-avatar {
        height: 40px;
        margin-right: 5px;
      }
    }
  }

  .main-container {
    margin: 0 5px;
    padding: 24px;
  }

  .footer-container {
    background-color: black;
    padding: 0 89px;

    .footer-nav {
      display: flex;
      justify-content: space-between;

      .nav-item {
        display: flex;
        flex-direction: column;
        width: 197px;
        color: #fff;

        .nav-title {
          font-size: 20px;
          margin-top: 10px;
        }

        a {
          margin-top: 14px;
          text-decoration: none;
          color: #babbbf;

          &:hover {
            color: #fff;
          }
        }
      }
    }
  }

}
</style>
