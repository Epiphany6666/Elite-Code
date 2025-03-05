<script setup lang="ts" name="login">
import { reactive, ref } from 'vue'
import { Lock, User } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/modules/user.ts'
import { login } from '@/api/user.ts'
import type { LoginUserVO, userLoginDTO } from '@/types/user'
import type { FormRules } from 'element-plus'

const router = useRouter()
const userStore = useUserStore()
const loginFormRef = ref()
const loginForm = reactive<userLoginDTO>({
  account: 'luoyan',
  password: '12345678'
})

const handleGoHome = () => {
  router.push('/home')
}

const loginRules = reactive<FormRules<userLoginDTO>>({
  account: [
    { type: 'string', required: true, trigger: 'blur', message: '请输入您的账号' },
    { type: 'string', min: 2, max: 20, trigger: 'blur', message: '账号长度必须在2到20个字符之间' }
  ],
  password: [
    { type: 'string', required: true, trigger: 'blur', message: '请输入您的密码' },
    { type: 'string', min: 6, max: 20, trigger: 'blur', message: '密码长度必须在6到20个字符之间' }
  ]
})

const handleLogin = async () => {
  await loginFormRef.value.validate(valid => {
    if (valid) {
      login(loginForm.account, loginForm.password).then(res => {
        console.log(res)
        const user: LoginUserVO = res.data
        userStore.id = user.id
        userStore.account = user.account
        userStore.avatar = user.avatar
        userStore.roles = user.roles
        // 跳转到主页
        handleGoHome()
      })
    }
  })
}
</script>

<template>
  <div class="login">
    <el-form
      ref="loginFormRef"
      :model="loginForm"
      :rules="loginRules"
      label-width="auto"
      style="width: 250px"
    >
      <h3 class="title">面试刷题平台</h3>
      <el-form-item prop="account">
        <el-input
          v-model="loginForm.account"
          type="text"
          placeholder="账号"
          :prefix-icon="User"
        />
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          placeholder="密码"
          :prefix-icon="Lock"
        />
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click="handleLogin"
          style="width: 100%"
        >
          登录
        </el-button>
        <div>
          <router-link to="/register">没有账号？去注册</router-link>
        </div>
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
