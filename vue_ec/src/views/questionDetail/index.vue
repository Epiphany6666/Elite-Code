<script setup lang="ts" name="QuestionDetail">
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import { getQuestionById } from '@/api/question.ts'

const route = useRoute()
const questionId = route.params.id
const questionDetail = ref({})

function getQuestionDetail() {
  getQuestionById(questionId).then(res => {
    questionDetail.value = res.data.question
  })
}


getQuestionDetail()
</script>

<template>
  <el-card>
    {{ questionDetail.title }}
  </el-card>
  <el-card>
    {{ questionDetail.content }}
  </el-card>
</template>

<style scoped>
</style>
