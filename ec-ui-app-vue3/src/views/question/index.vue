<script setup lang="ts" name="QuestionList">
import { ref } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { listProblemsetQuestion } from '@/api/problemset.ts'
import type { QuestionType } from '@/types/question'

const route = useRoute()
const router = useRouter()

const queryParam = ref({
  current: 1,
  pageSize: 5,
  problemsetId: route.params.id
})

const questionList = ref<Array<QuestionType>>([])
const total = ref<number>(0)

/* 获取所属题库的题目 */
function getQuestion() {
  listProblemsetQuestion(queryParam.value).then(res => {
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
  <div>
    <el-table :data="questionList" stripe border style="margin-bottom: 10px;">
      <el-table-column prop="title" label="题目">
        <template #default="scope">
        <span @click="goQuestionDetail(scope.row.id)">
          {{ scope.row.title }}
        </span>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      v-model:current-page="queryParam.current"
      v-model:page-size="queryParam.pageSize"
      :page-sizes="[5, 10, 15, 20]"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="getQuestion"
      @current-change="getQuestion"
    />
  </div>
</template>

<style scoped>
:deep(.cell):hover {
  cursor: pointer;
}
</style>
