<script setup lang="ts">
import {nextTick, ref} from "vue";
import {addUser, getUser, updateUser} from "@/api/user.ts";

const dialogVisible = ref(false)
const dialogTitle = ref('')
const formData = ref({
  id: '',
  username: '',
  nickName: '',
  password: '',
  roleIds: []
})
const roleOptions = ref({})
const formRef = ref()

const open = (id?: string) => {
  dialogVisible.value = true
  nextTick(() => {
    resetForm()
  })
  // 加载下拉框列表
  getUser(id).then(res => {
    if (!id) {
      dialogTitle.value = '新增'
    } else {
      dialogTitle.value = '修改'
      formData.value.id = res.data.user.id
      formData.value.roleIds = res.data.roleIds
      formData.value.username = res.data.user.username
      formData.value.nickName = res.data.user.nickName
    }
    roleOptions.value = res.data.roleAll
  })
}

const emit = defineEmits(['success'])
const submitForm = async () => {
  if (!formData.value.id) {
    await addUser(formData.value)
    ElMessage.success('增加成功')
  } else {
    await updateUser(formData.value)
    ElMessage.success('修改成功')
  }
  dialogVisible.value = false
  emit('success')
}

const resetForm = () => {
  formData.value = {
    id: '',
    username: '',
    nickName: '',
    password: '',
    roleIds: []
  }
  formRef.value.resetFields()
}

defineExpose({ open })
</script>

<template>
  <el-dialog
      v-model="dialogVisible"
      :title="dialogTitle"
      width="600"
  >
    <el-form :model="formData" ref="formRef" :inline="true">
      <el-form-item label="账号" prop="username">
        <el-input v-model="formData.username" />
      </el-form-item>
      <el-form-item label="别名" prop="nickName">
        <el-input v-model="formData.nickName" />
      </el-form-item>
      <el-form-item v-if="!formData.id" label="密码" prop="password">
        <el-input v-model="formData.password" />
      </el-form-item>
      <el-form-item label="角色" prop="roleIds">
        <el-select multiple v-model="formData.roleIds" placeholder="请选择角色" style="width: 240px">
          <el-option
              v-for="item in roleOptions"
              :key="item.id"
              :label="item.name"
              :value="item.id"
          />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="submitForm">确定</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
</style>
