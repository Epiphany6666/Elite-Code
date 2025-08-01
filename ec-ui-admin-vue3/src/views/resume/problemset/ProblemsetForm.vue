<script setup lang="ts">
import {ref} from "vue";
import {addProblemset, getProblemset, updateProblemset} from "@/api/problemset.ts";

const dialogVisible = ref(false)
const dialogTitle = ref('')
const formData = ref({
  id: '',
  title: '',
  description: ''
})
const formRef = ref()

const open = (id?: string) => {
  dialogVisible.value = true
  reset()
  if (!id) { // 新增
    dialogTitle.value = '新增'
  } else { // 修改
    dialogTitle.value = '修改'
    getProblemset(id).then(res => {
      formData.value = res.data
    })
  }
}

const reset = () => {
  formData.value = {
    id: '',
    title: '',
    description: ''
  }
  formRef.value?.resetFields()
}

const emit = defineEmits(['success'])
const submitForm = () => {
  if (!formData.value.id) { // 新增
    addProblemset(formData.value).then(() => {
      emit('success')
      dialogVisible.value = false
      ElMessage.success('新增成功')
    })
  } else { // 更新
    updateProblemset(formData.value).then(() => {
      emit('success')
      dialogVisible.value = false
      ElMessage.success('修改成功')
    })
  }
}

defineExpose({open})
</script>

<template>
  <el-dialog
      :title="dialogTitle"
      v-model="dialogVisible"
      width="400"
  >
    <el-form ref="formRef">
      <el-form-item label="标题">
        <el-input v-model="formData.title" placeholder="请输入题目标题" style="width: 300px" />
      </el-form-item>
      <el-form-item label="描述">
        <el-input
            v-model="formData.description"
            style="width: 300px"
            :rows="3"
            type="textarea"
            resize="none"
            placeholder="描述..."
        />
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="submitForm">确定</el-button>
    </template>
  </el-dialog>
</template>

<style scoped>
</style>
