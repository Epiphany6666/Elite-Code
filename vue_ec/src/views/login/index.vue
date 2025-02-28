<script setup lang="ts" name="login">
import { reactive } from 'vue'
import axios from 'axios'
import { User, Lock } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/modules/user.ts'
import { login } from '@/api/user.ts'
import type { LoginUserVO } from '@/types/user'

const router = useRouter()
const userStore = useUserStore()

// do not use same name with ref
const loginForm = reactive({
  account: '',
  password: '',
})

const handleGoHome = () => {
  router.push('/home')
}

const handleLogin = async () => {
  const res = await login(loginForm.account, loginForm.password)
  console.log(res)
  const user:LoginUserVO = res.data.data
  userStore.id = user.id
  userStore.account = user.account
  userStore.avatar = user.avatar
  userStore.roles = user.roles
  // 跳转到主页
  handleGoHome()
}
</script>

<template>
  <div class="login">
    <el-form :model="loginForm" label-width="auto" style="max-width: 200px">
      <h3 class="title">面试刷题平台</h3>
      <el-form-item label="账号">
        <el-input
          v-model="loginForm.account"
          type="text"
          size="large"
          autocomplete="true"
          placeholder="请输入账号"
          :prefix-icon="User"
        />
      </el-form-item>
      <el-form-item label="密码">
        <el-input
          v-model="loginForm.password"
          type="password"
          size="large"
          autocomplete="true"
          placeholder="请输入密码"
          :prefix-icon="Lock"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleLogin">登录</el-button>
        <el-button type="info" @click="router.push('/register')">去注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}
.title {
  text-align: center;
  color: #5b9cf8;
}
</style>
