<script setup lang="ts">
import {getQuestionPage, removeQuestions} from "@/api/question.ts";
import {ref} from "vue";
import type {QuestionDO, QuestionQueryReqVO} from "@/types/quetion";
import QuestionForm from "@/views/resume/question/QuestionForm.vue";

const queryParams = ref<QuestionQueryReqVO>({
  current: 1,
  pageSize: 5,
  title: undefined,
  startTime: undefined,
  endTime: undefined,
})

const questionList = ref<Array<QuestionDO>>([])
const total = ref(0)
const dateRange = ref<Array<Date>>([])
const queryFormRef = ref()
const formRef = ref()
const loading = ref(true)
const ids = ref([])
const multiple = ref(true)

const getQuestionList = () => {
  loading.value = true
  getQuestionPage(addDateRange()).then(res => {
    loading.value = false
    questionList.value = res.data.list
    total.value = res.data.total
  })
}

const resetQueryForm = () => {
  queryFormRef.value.resetFields()
  dateRange.value = []
}

const addDateRange = () => {
  queryParams.value.startTime = dateRange.value[0]
  queryParams.value.endTime = dateRange.value[1]
  return queryParams.value
}

const openForm = (id?: string) => {
  formRef.value.open(id)
}

const handleDelete = (id) => {
  const questionId = id || ids.value
  ElMessageBox.confirm(
      '是否确定删除编号为"' + questionId + '"的数据项？',
      '系统提示',
      {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type: 'warning',
      }
  ).then(async () => {
    await removeQuestions(questionId)
    getQuestionList()
    ElMessage.success('删除成功')
  })
}

const handleSelectChange = (selection) => {
  ids.value = selection.map(item => item.id)
  multiple.value = !selection.length
}
getQuestionList()
</script>

<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col>
        <el-form :model="queryParams" ref="queryFormRef" style="margin-bottom: 8px;" :inline="true">
          <el-form-item label="标题" prop="title">
            <el-input v-model="queryParams.title" placeholder="请输入题目标题"/>
          </el-form-item>
          <el-form-item label="创建时间">
            <el-date-picker
                v-model="dateRange"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                type="daterange"
                format="YYYY-MM-DD"
                value-format="YYYY-MM-DD mm:HH:ss"
                style="width: 308px;"
            />
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <el-row :gutter="10" style="margin-bottom: 8px;">
          <el-col :span="1.5">
            <el-button type="primary" icon="Search" @click="getQuestionList">查询</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button icon="Refresh" @click="resetQueryForm">重置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="primary" icon="Plus" plain @click="openForm()">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="Delete" plain @click="handleDelete()" :disabled="multiple">删除</el-button>
          </el-col>
        </el-row>

        <el-table :data="questionList" border v-loading="loading" @selection-change="handleSelectChange" style="margin-bottom: 8px;">
          <el-table-column type="selection"/>
          <el-table-column label="标题" prop="title"/>
          <el-table-column label="创建时间" prop="createTime"/>
          <el-table-column label="更新时间" prop="updateTime"/>
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" link @click="openForm(scope.row.id)">
                <el-icon>
                  <Edit/>
                </el-icon>
                修改
              </el-button>
              <el-button type="danger" link @click="handleDelete(scope.row.id)">
                <el-icon>
                  <Delete/>
                </el-icon>
                删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            v-model:current-page="queryParams.current"
            v-model:page-size="queryParams.pageSize"
            :page-sizes="[5, 10, 15, 20]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="getQuestionList"
            @current-change="getQuestionList"
        />
      </el-col>

      <QuestionForm ref="formRef" @success="getQuestionList"/>
    </el-row>
  </div>
</template>

<style scoped>
.app-container {

}
</style>
