<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import { register } from '@/api/user.ts'
const router = useRouter()

const registerForm = reactive({
  account: '',
  password: '',
  checkPassword: ''
})

const handleRegister = () => {
  register(registerForm.account, registerForm.password, registerForm.checkPassword)
    .then(res => {
      console.log("@@register", res)
      ElMessage({
        message: `${registerForm.account} 注册成功，即将跳转登录页...`,
        type: 'success',
      })
      setTimeout(() => {
        router.push('/login')
      }, 3000)
    })
    .catch(error => {

    })
}

</script>

<template>
  <div class="register">
    <el-form :model="registerForm" style="max-width: 200px">
      <h3 class="title">注册</h3>
      <el-form-item label="账号">
        <el-input v-model="registerForm.account" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="registerForm.password" />
      </el-form-item>
      <el-form-item label="确认密码">
        <el-input v-model="registerForm.checkPassword" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="handleRegister">注册</el-button>
        <el-button type="info" @click="router.push('/login')">去登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>
.register {
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
