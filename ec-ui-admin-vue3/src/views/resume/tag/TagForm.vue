<script setup lang="ts">
import {ref} from "vue";
import {addTag, getTag, updateTag} from "@/api/tag.ts";
import type {TagUpdateDTO} from "@/types/tag";

const dialogVisible = ref(false)
const dialogTitle = ref('')
const tagFormRef = ref()
const formData = ref<TagUpdateDTO>({
  id: '',
  name: ''
})

const open = (id?: string) => {
  resetForm()
  dialogVisible.value = true
  if (!id) { // 新增
    dialogTitle.value = '新增'
  } else { // 修改
    dialogTitle.value = '修改'
    getTag(id).then(res => {
      formData.value = res.data
    })
  }
}
defineExpose({open})

const resetForm = () => {
  formData.value = {
    id: '',
    name: ''
  }
  tagFormRef.value?.resetFields()
}

const emit = defineEmits(['success'])
const submitForm = async () => {
  if (!formData.value.id) { // 新增
    await addTag(formData.value)
    ElMessage.success('新增成功！')
  } else { // 修改
    await updateTag(formData.value)
    ElMessage.success('修改成功！')
  }
  emit('success')
  dialogVisible.value = false
}
</script>

<template>
  <el-dialog
      :title="dialogTitle"
      v-model="dialogVisible"
      width="300"
  >
    <el-form :data="formData" ref="tagFormRef" inline>
      <el-form-item label="标签名" prop="name">
        <el-input v-model="formData.name" placeholder="请输入标签名" />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="submitForm">确认</el-button>
    </template>
  </el-dialog>
</template>

<style scoped>
</style>
