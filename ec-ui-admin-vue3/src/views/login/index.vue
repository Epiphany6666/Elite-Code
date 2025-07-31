<script lang="ts" setup="">
import {reactive, ref} from 'vue'

import type {FormInstance, FormRules} from 'element-plus'
import {setToken} from "@/utils/auth.ts";
import {useRouter} from "vue-router";
import {login} from "@/api/login.ts";
import type {UserLoginReqVO} from "@/types/user.d.ts";

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<UserLoginReqVO>({
  username: 'luoyan',
  password: '12345678',
})


const rules = reactive<FormRules<UserLoginReqVO>>({
  username: [
    {required: true, message: 'Please input Activity name', trigger: 'blur'},
    {min: 2, max: 20, message: 'Length should be 2 to 20', trigger: 'blur'},
  ],
  password: [
    {required: true, message: 'Please select Activity zone', trigger: 'change'},
  ],
})

const router = useRouter()
const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      login(ruleForm).then(res => {
        setToken(res.data.token)
        router.push('/')
      })
    } else {
      console.log('error submit!', fields)
    }
  })
}
</script>

<template>
  <div class="login-container">
    <h1>登录页</h1>
    <el-form
        ref="ruleFormRef"
        style="max-width: 250px"
        :model="ruleForm"
        :rules="rules"
        label-width="auto"
    >
      <el-form-item label="账号" prop="username">
        <el-input v-model="ruleForm.username"/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" v-model="ruleForm.password"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleFormRef)">
          登录
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>
.login-container {
  height: 100vh;
  width: 100vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
