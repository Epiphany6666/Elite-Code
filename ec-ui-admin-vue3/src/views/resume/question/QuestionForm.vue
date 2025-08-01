<script setup lang="ts">
import {nextTick, ref} from "vue";
import type {QuestionAddReqVO} from "@/types/quetion";
import {addQuestion, getQuestion, updateQuestion} from "@/api/question.ts";
import type {ProblemsetDO} from "@/api/problemset.ts";
import type {TagDO} from "@/types/tag"
import 'bytemd/dist/index.css'
import gfm from '@bytemd/plugin-gfm'
import {Editor} from '@bytemd/vue-next'
import {upload} from "@/api/minio.ts";
// bytemd中文语言包
import zh_Hans from 'bytemd/locales/zh_Hans.json'
import gfm_zh_Hans from '@bytemd/plugin-gfm/locales/zh_Hans.json'

const formData = ref<QuestionAddReqVO>({
  id: undefined,
  title: undefined,
  content: '',
  answer: '',
  problemsetIds: [],
  tagIds: [],
})
const dialogVisible = ref(false)
const dialogTitle = ref('')
const formRef = ref()
const problemsetAll = ref<Array<ProblemsetDO>>([])
const tagAll = ref<Array<TagDO>>([])
const plugins = [
  gfm({
    locale: gfm_zh_Hans
  }),
  // Add more plugins here
]

const handleChangeContent = (v) => {
  formData.value.content = v
}

const handleChangeAnswer = (v) => {
  formData.value.answer = v
}

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
    title: '',
    content: '',
    answer: '',
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

const handleUploadImage = async (files) => {
  const uploadPromises = files.map(file => {
    const formData = new FormData()
    formData.append('file', file)
    return upload(formData)
  })
  const responses = await Promise.all(uploadPromises)
  console.log("@@responses", responses)
  return responses.map(res => res.data)
}
</script>

<template>
  <el-dialog
      v-model="dialogVisible"
      :title="dialogTitle"
      width="1000"
  >
    <el-form ref="formRef" :model="formData" :inline="true">
      <el-form-item label="标题" :inline="true" prop="title" style="width: 300px;">
        <el-input v-model="formData.title" placeholder="请输入标题"/>
      </el-form-item>
      <el-form-item label="内容" prop="content" style="width: 1000px;">
        <Editor
            :value="formData.content"
            mode="split" placeholder="请输入内容..."
            :plugins="plugins"
            :uploadImages="handleUploadImage"
            @change="handleChangeContent"
            :locale="zh_Hans"
        />
      </el-form-item>
      <el-form-item label="答案" prop="answer" style="width: 1000px;">
        <Editor
            :value="formData.answer"
            mode="split"
            placeholder="请输入答案..."
            :plugins="plugins"
            :uploadImages="handleUploadImage"
            @change="handleChangeAnswer"
            :locale="zh_Hans"
        />
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
.el-form-item {
  :deep(.bytemd) {
    width: 900px;
    height: 300px;

    [bytemd-tippy-path="0"],
    [bytemd-tippy-path="5"] {
      display: none;
    }

    /* 控制 Bytemd 编辑器预览区域和编辑区域的图片大小 */

    :deep(.bytemd-preview img),
    :deep(.cm-line img) {
      max-width: 100%; /* 图片最大宽度为其容器的100% */
      height: auto; /* 高度自动缩放以保持比例 */
      display: block; /* 确保图片为块级元素，避免奇怪的行内对齐问题 */
    }
  }
}
</style>
