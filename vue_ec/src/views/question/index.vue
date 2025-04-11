<script setup lang="ts" name="QuestionList">
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { listProblemsetQuestion } from '@/api/problemset.ts'
import type { QuestionType } from '@/types/question'

const route = useRoute()
const router = useRouter()
const problemsetId = route.params.id as string

const questionList = ref<Array<QuestionType>>([])
const total = ref<number>(0)

/* 获取所属题库的题目 */
function getQuestion() {
  listProblemsetQuestion({ problemsetId }).then(res => {
    questionList.value = res.data.list
    total.value = res.data.total
  })
}

function goQuestionDetail(questionId) {
  router.push(`/question/${questionId}`)
}

getQuestion()
</script>

<template>
  <el-table :data="questionList" border style="width: 100%">
    <el-table-column type="selection" width="55" />
    <el-table-column prop="title" label="题目" width="180">
      <template #default="scope">
        <span @click="goQuestionDetail(scope.row.id)">
          {{ scope.row.title }}
        </span>
      </template>
    </el-table-column>
  </el-table>
</template>

<style scoped>
:deep(.cell):hover {
  cursor: pointer;
}
</style>
