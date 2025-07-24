<script setup lang="ts">
import {nextTick, ref} from "vue";
import type {QuestionAddReqVO} from "@/types/quetion";
import {addQuestion, getQuestion, updateQuestion} from "@/api/question.ts";
import type {ProblemsetDO} from "@/api/problemset.ts";
import type {TagDO} from "@/types/tag";
const formData = ref<QuestionAddReqVO>({
  id: undefined,
  title: undefined,
  content: undefined,
  answer: undefined,
  problemsetIds: [],
  tagIds: [],
})
const dialogVisible = ref(false)
const dialogTitle = ref('')
const formRef = ref()
const problemsetAll = ref<Array<ProblemsetDO>>([])
const tagAll = ref<Array<TagDO>>([])

const open = (id?: string) => {
  dialogVisible.value = true
  resetForm()
  if (!id) { // id不存在，新增
    dialogTitle.value = '新增'
    getQuestion().then(res => {
      problemsetAll.value = res.data.problemsetAll
      tagAll.value = res.data.tagAll
    })
  } else {
    dialogTitle.value = '修改'
    formData.value.id = id
    getQuestion(id).then(res => {
      problemsetAll.value = res.data.problemsetAll
      tagAll.value = res.data.tagAll
      formData.value.problemsetIds = res.data.problemsetIds
      formData.value.tagIds = res.data.tagIds
      formData.value.title = res.data.question?.title
      formData.value.content = res.data.question?.content
      formData.value.answer = res.data.question?.answer
    })
  }
}
defineExpose({open})

const resetForm = () => {
  formData.value = {
    title: undefined,
    content: undefined,
    answer: undefined,
    problemsetIds: [],
    tagIds: [],
  }
  nextTick(() => formRef.value.resetFields())
}

const emit = defineEmits('success')
const submitForm = () => {
  if (!formData.value.id) { // 新增
    addQuestion(formData.value).then(() => {
      dialogVisible.value = false
      emit('success')
      ElMessage.success('新增成功')
    })
  } else { // 修改
    updateQuestion(formData.value).then(() => {
      dialogVisible.value = false
      emit('success')
      ElMessage.success('修改成功')
    })
  }
}
</script>

<template>
  <el-dialog
    v-model="dialogVisible"
    :title="dialogTitle"
  >
    <el-form ref="formRef" :model="formData" :inline="true">
      <el-form-item label="标题" :inline="true" prop="title">
        <el-input v-model="formData.title" placeholder="请输入标题" />
      </el-form-item>
      <el-form-item label="内容" prop="content">
        <el-input v-model="formData.content" placeholder="请输入内容" />
      </el-form-item>
      <el-form-item label="答案" prop="answer">
        <el-input v-model="formData.answer" placeholder="请输入答案" />
      </el-form-item>
      <el-form-item label="题库" prop="problemsetIds" style="width: 300px;">
        <el-select v-model="formData.problemsetIds" multiple placeholder="请选择题库">
          <el-option
              v-for="item in problemsetAll"
              :key="item.id"
              :label="item.title"
              :value="item.id"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="标签" prop="tagIds" style="width: 300px;">
        <el-select v-model="formData.tagIds" multiple placeholder="请选择标签">
          <el-option
              v-for="item in tagAll"
              :key="item.id"
              :label="item.name"
              :value="item.id"
          />
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="submitForm()">确认</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
</style>
