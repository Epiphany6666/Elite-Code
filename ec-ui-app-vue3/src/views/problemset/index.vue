<script setup lang="ts" name="problemset">
import { ref } from 'vue'
import { getProblemsetAll } from '@/api/problemset.ts'
import type { ProblemsetType } from '@/types/problemset'
import { useRouter } from 'vue-router'

const router = useRouter()
const problemsetList = ref<Array<ProblemsetType>>([])

/* 查询题库列表 */
function getProblemsetList() {
  getProblemsetAll().then((res) => {
    problemsetList.value = res.data
  })
}

function getDescription(description: string) {
  if (description.length > 8) {
    description = description.substring(0, 7) + '...'
  }
  return description
}

function goQuestion(problemsetId: string) {
  router.push(`/problemset/${problemsetId}`)
}

getProblemsetList()
</script>

<template>
  <el-row :gutter="10">
    <el-col :span="6" v-for="problemset in problemsetList" :key="problemset.id">
      <el-card class="problemset-card" shadow="hover" @click="goQuestion(problemset.id)">
        <img :src="problemset.picture" class="problemset-card__icon" />
        <div class="problemset-card__content">
          <span class="problemset-card__title">{{ problemset.title }}</span>
          <span class="problemset-card__description">{{
            getDescription(problemset.description)
          }}</span>
        </div>
      </el-card>
    </el-col>
  </el-row>
</template>

<style scoped lang="scss">
.problemset-card {
  cursor: pointer;
  margin-bottom: 20px;

  :deep(.el-card__body) {
    display: flex;
    align-items: center;

    .problemset-card__icon {
      height: 50px;
    }

    .problemset-card__content {
      display: flex;
      flex-direction: column;
      margin-left: 20px;

      .problemset-card__title {
        font-size: 16px;
        font-weight: 600;
        margin-bottom: 10px;
      }

      .problemset-card__description {
        font-size: 15px;
        color: #909399;
      }
    }
  }
}
</style>
