<script setup lang="ts" name="login">
import { reactive } from 'vue'
import axios from 'axios'

// do not use same name with ref
const loginForm = reactive({
  userAccount: '',
  userPassword: '',
})

const onSubmit = async () => {
  const res = await axios.post('http://localhost:8901/user/login', {
    ...loginForm,
  })
  console.log(res)
}
</script>

<template>
  <div class="login">
    <el-form :model="loginForm" label-width="auto" style="max-width: 200px">
      <h3>面试刷题平台</h3>
      <el-form-item label="账号">
        <el-input v-model="loginForm.userAccount" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="loginForm.userPassword" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped></style>
