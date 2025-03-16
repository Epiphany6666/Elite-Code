<script setup lang="ts" name="login">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import useUserStore from '@/store/modules/user'
import type { UserLoginDTO } from '@/types/user'
import type { FormRules } from 'element-plus'

const title = import.meta.env.VITE_APP_TITLE
const loading = ref(false)
const router = useRouter()
const userStore = useUserStore()
const loginFormRef = ref()
const loginForm = ref<UserLoginDTO>({
  username: 'luoyan',
  password: '12345678'
})

const handleGoHome = () => {
  router.push('/home')
}

const loginRules = reactive<FormRules<UserLoginDTO>>({
  username: [
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
      loading.value = true
      userStore.login(loginForm.value).then(() => {
        // 跳转到主页
        handleGoHome()
      }).finally(() => {
        loading.value = false
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
      class="login-form"
    >
      <h3 class="title">{{ title }}</h3>
      <el-form-item prop="username">
        <el-input
          v-model="loginForm.username"
          type="text"
          size="large"
          placeholder="账号"
        >
          <template #prefix>
            <svg-icon icon-class="user" class="input-icon" />
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          size="large"
          placeholder="密码"
          @keyup.enter="handleLogin"
        >
          <template #prefix>
            <svg-icon icon-class="password" class="input_icon" />
          </template>
        </el-input>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          @click.prevent="handleLogin"
          style="width: 100%"
          :loading="loading"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div>
          <router-link to="/register">没有账号？去注册</router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped lang="less">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background: url("@/assets/images/login-background.png") center/cover;
}

.login-form {
  width: 250px;

  .input_icon {
    height: 30px;
    width: 14px;
  }
}

.title {
  text-align: center;
  color: #5b9cf8;
}

:deep(.el-input--large) .el-input__wrapper {
  padding: 1px 10px;
}
</style>
