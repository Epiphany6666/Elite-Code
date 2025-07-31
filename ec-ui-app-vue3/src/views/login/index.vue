<script setup lang="ts" name="Login">
import { reactive, ref, watch } from 'vue'
import { type LocationQueryValue, useRoute, useRouter } from 'vue-router'
import useUserStore from '@/store/modules/user'
import type { LoginForm } from '@/types/user'
import type { FormRules } from 'element-plus'

const title = import.meta.env.VITE_APP_TITLE
const loading = ref(false)
const route = useRoute()
const router = useRouter()

const redirect = ref('')
watch(route, (newRoute) => {
  redirect.value = newRoute.query && newRoute.query.redirect as string
}, { immediate: true })

const userStore = useUserStore()
const loginFormRef = ref()
const loginForm = reactive<LoginForm>({
  username: '13187237183',
  password: '12345678'
})

const loginRules = reactive<FormRules<LoginForm>>({
  username: [
    { required: true, trigger: 'blur', message: '请输入您的账号' },
    { trigger: 'blur', message: '账号长度必须在2到20个字符之间' }
  ],
  password: [
    { required: true, trigger: 'blur', message: '请输入您的密码' },
    { min: 6, max: 20, trigger: 'blur', message: '密码长度必须在6到20个字符之间' }
  ]
})

const handleLogin = async () => {
  await loginFormRef.value.validate((valid: boolean) => {
    if (valid) {
      loading.value = true
      userStore.login(loginForm).then(() => {
        const query = route.query
        const otherQueryParams = Object.keys(query).reduce((acc, cur) => {
          if (cur !== 'redirect') {
            acc[cur] = query[cur]
          }
          return acc
        }, {} as { [key: string]: LocationQueryValue | LocationQueryValue[] })
        router.push({ path: redirect.value || '/', query: otherQueryParams })
      }).finally(() => {
        loading.value = false
      })
    }
  })
}

// 睁眼/闭眼
const pwdType = ref('password')
const showPwd = () => {
  if (pwdType.value === 'password') {
    pwdType.value = ''
  } else {
    pwdType.value = 'password'
  }
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
          :type="pwdType"
          size="large"
          placeholder="密码"
          @keyup.enter="handleLogin"
        >
          <template #prefix>
            <svg-icon icon-class="password" class="input_icon" />
          </template>
          <template #suffix>
            <svg-icon :icon-class="pwdType ? 'closeEye' : 'openEye'" class="input_icon password-icon" @click="showPwd" />
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

<style scoped lang="scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;

  .login-form {
    width: 250px;

    .el-input {
      .input_icon {
        height: 30px;
        width: 14px;
      }

      .password-icon {
        cursor: pointer;
      }
    }

    .title {
      text-align: center;
      color: #5b9cf8;
    }

    :deep(.el-input--large) .el-input__wrapper {
      padding: 1px 10px;
    }
  }
}
</style>
