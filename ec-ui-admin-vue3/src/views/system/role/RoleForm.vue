<script setup lang="ts">
import {ref} from 'vue'
import {addRole, getRole, updateRole} from "@/api/role.ts";

const dialogVisible = ref(false)
const dialogTitle = ref(undefined)
const formData = ref({
  id: undefined, // 角色id
  name: undefined, // 角色名称
  sort: 0, // 显示顺序
  menuIds: [], // 菜单列表
})
const formRef = ref()
const open = (id?: string) => {
  dialogVisible.value = true
  resetForm()
  if (!id) {
    formData.value.id = id
    dialogTitle.value = '新增'
  } else {
    dialogTitle.value = '修改'
    getRole(id).then(res => {
      formData.value = res.data
    })
  }
}

const handleChange = (value) => {
  formData.value.sort = value
}

const emit = defineEmits(['success'])
const submitForm = () => {
  if (!formData.value.id) {
    addRole(formData.value).then(() => {
      dialogVisible.value = false
      resetForm()
      emit('success')
      ElMessage.success('新增成功')
    })
  } else {
    updateRole(formData.value).then(() => {
      dialogVisible.value = false
      resetForm()
      emit('success')
      ElMessage.success('修改成功')
    })
  }
}

const resetForm = () => {
  formData.value = {
    name: undefined, // 角色名称
    sort: 0, // 显示顺序
    menuIds: [], // 菜单列表
  }
  formRef.value.resetFields()
}

defineExpose({ open })
</script>

<template>
  <el-dialog v-model="dialogVisible" :title="dialogTitle" width="600" :inline="true">
    <el-form :model="formData" ref="formRef">
      <el-form-item label="角色名称">
        <el-input v-model="formData.name" placeholder="请输入角色名称"></el-input>
      </el-form-item>
      <el-form-item label="显示顺序">
        <el-input-number v-model="formData.sort" :min="0" :max="10" @change="handleChange" />
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
