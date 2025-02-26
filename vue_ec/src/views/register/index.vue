<script setup lang="ts">
import { reactive } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
const router = useRouter()

const registerForm = reactive({
  userAccount: '',
  userPassword: '',
  checkPassword: ''
})

const handleRegister = async () => {
  const res = await axios.post('http://localhost:8901/user/register', {
    ...registerForm
  })
  console.log("@@register", res)
  router.push('/login')
}

</script>

<template>
  <div class="register">
    <el-form :model="registerForm" style="max-width: 200px">
      <h3 class="title">注册</h3>
      <el-form-item label="账号">
        <el-input v-model="registerForm.userAccount" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="registerForm.userPassword" />
      </el-form-item>
      <el-form-item label="确认密码">
        <el-input v-model="registerForm.checkPassword" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="handleRegister">注册</el-button>
        <el-button type="info" @click="$router.push('/login')">去登录</el-button>
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
