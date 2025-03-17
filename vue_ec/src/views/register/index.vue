<script setup lang="ts" name="register">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { register } from '@/api/user.ts'
import type { FormRules } from 'element-plus'
import type { UserRegisterDTO } from '@/types/user'

const loading = ref(false)
const router = useRouter()
const registerFormRef = ref()
const registerForm = reactive({
  username: '',
  password: '',
  checkPassword: ''
})

const equalToPassword = (rule: any, value: any, callback: any) => {
  if (value !== registerForm.password) {
    callback(new Error('两次输入密码不一致'))
  } else {
    callback()
  }
}

const registerRules = reactive<FormRules<UserRegisterDTO>>({
  username: [
    { type: 'string', required: true, trigger: 'blur', message: '请输入您的账号' },
    { type: 'string', min: 2, max: 20, trigger: 'blur', message: '账号长度必须在2到20个字符之间' }
  ],
  password: [
    { type: 'string', required: true, trigger: 'blur', message: '请输入您的密码' },
    { type: 'string', min: 6, max: 20, trigger: 'blur', message: '密码长度必须在6到20个字符之间' }
  ],
  checkPassword: [
    { type: 'string', required: true, trigger: 'blur', message: '请再次输入您的密码' },
    { type: 'string', validator: equalToPassword, trigger: 'blur' }
  ]
})

const handleRegister = () => {
  registerFormRef.value.validate(valid => {
    if (valid) {
      loading.value = true
      register(registerForm.username, registerForm.password, registerForm.checkPassword).then(res => {
        ElMessage({
          message: `${registerForm.username} 注册成功，即将跳转登录页...`,
          type: 'success',
        })
        setTimeout(() => {
          router.push('/login')
        }, 3000)
      }).finally(() => {
        loading.value = false
      })
    }
  })
}

</script>

<template>
  <div class="register">
    <el-form
      ref="registerFormRef"
      :model="registerForm"
      :rules="registerRules"
      class="register-form"
    >
      <h3 class="title">注册</h3>
      <el-form-item prop="username">
        <el-input
          type="text"
          v-model="registerForm.username"
          size="large"
          placeholder="账号"
        >
          <template #prefix>
            <svg-icon icon-class="user" class="input_icon" />
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="registerForm.password"
          size="large"
          placeholder="密码"
        >
          <template #prefix>
            <svg-icon icon-class="password" class="input_icon" />
          </template>
        </el-input>
      </el-form-item>
      <el-form-item prop="checkPassword">
        <el-input
          type="password"
          v-model="registerForm.checkPassword"
          size="large"
          placeholder="确认密码"
          @keyup.enter="handleRegister"
        >
          <template #prefix>
            <svg-icon icon-class="password" class="input_icon" />
          </template>
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-button
          type="primary"
          @click.prevent="handleRegister"
          style="width: 100%"
          :loading="loading"
        >
          <span v-if="!loading">注 册</span>
          <span v-else>注 册 中...</span>
        </el-button>
        <div>
          <router-link to="/login">已有账号？去登录</router-link>
        </div>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped lang="scss">
.register {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background: url("@/assets/images/login-background.png") center/cover;

  .register-form {
    width: 250px;

    .title {
      text-align: center;
      color: #5b9cf8;
    }

    .input_icon {
      height: 30px;
      width: 14px;
    }

    :deep(.el-input--large) .el-input__wrapper {
      padding: 1px 10px;
    }
  }
}
</style>
