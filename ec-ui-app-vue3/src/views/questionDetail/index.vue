<script setup lang="ts" name="QuestionDetail">
import { computed, ref } from 'vue'
import { useRoute } from 'vue-router'
import { getQuestionById } from '@/api/question.ts'
import MarkdownIt from 'markdown-it'
import markdownItHighlightjs from 'markdown-it-highlightjs'

const route = useRoute()
const questionId = route.params.id
const questionDetail = ref({
  content: '',
  answer: '',
})

function getQuestionDetail() {
  getQuestionById(questionId).then((res) => {
    questionDetail.value = res.data
  })
}

const md = new MarkdownIt().use(markdownItHighlightjs)

const renderedContentMarkdown = computed(() => {
  return md.render(questionDetail.value.content)
})

const renderedAnswerMarkdown = computed(() => {
  return md.render(questionDetail.value.answer)
})

getQuestionDetail()
</script>

<template>
  <div>
    <h3>题目</h3>
    <el-card>
      {{ questionDetail.title }}
    </el-card>
    <h3 v-if="questionDetail.content">内容</h3>
    <el-card v-if="questionDetail.content">
      <div v-html="renderedContentMarkdown" />
    </el-card>
    <h3>答案</h3>
    <el-card>
      <div v-html="renderedAnswerMarkdown" />
    </el-card>
  </div>
</template>

<style scoped>
.el-card :deep(.markdown-body img) {
  max-width: 50%;
  height: auto;
  display: block;
}
</style>
