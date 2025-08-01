<script setup lang="ts">
import {ref} from "vue";
import type {ProblemsetDO, ProblemsetQueryReqVO} from "@/types/problemset";
import {getProblemsetPage, removeProblemset} from "@/api/problemset.ts";
import {Delete} from "@element-plus/icons-vue";
import ProblemsetForm from "@/views/resume/problemset/ProblemsetForm.vue";

const problemsetList = ref<Array<ProblemsetDO>>([])
const total = ref<number>(0)
const queryParams = ref<ProblemsetQueryReqVO>({
  current: 1,
  pageSize: 10,
  title: '',
  startTime: undefined,
  endTime: undefined
})
const dataRange = ref<Array<Date>>([])
const queryFormRef = ref()
const ids = ref([])
const multiple = ref(true)
const problemsetFormRef = ref()

const getProblemsetList = () => {
  getProblemsetPage(addDataRange()).then(res => {
    problemsetList.value = res.data.list
    total.value = res.data.total
  })
}

const addDataRange = () => {
  queryParams.value.startTime = dataRange.value[0]
  queryParams.value.endTime = dataRange.value[1]
  return queryParams.value
}

const resetQueryParams = () => {
  queryFormRef.value.resetFields()
  dataRange.value = []
  getProblemsetList()
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  multiple.value = !selection.length
}

const handleDelete = (id?: string) => {
  const problemsetId = id || ids.value
  ElMessageBox.confirm(
      '是否确定删除编号为"' + problemsetId + '"的数据项？',
      '系统提示',
      {
        cancelButtonText: '取消',
        confirmButtonText: '确认',
        type: "warning"
      }
  ).then(() => {
    removeProblemset(problemsetId).then(() => {
      getProblemsetList()
      ElMessage.success('删除成功')
    })
  })
}

const openForm = (id?: string) => {
  problemsetFormRef.value.open(id)
}

getProblemsetList()
</script>

<template>
  <div class="app-container">
    <el-row :gutter="10">
      <el-col>
        <el-form :model="queryParams" ref="queryFormRef" inline>
          <el-form-item label="标题" prop="title">
            <el-input v-model="queryParams.title" placeholder="请输入标题" />
          </el-form-item>
          <el-form-item label="创建时间">
            <el-date-picker
                v-model="dataRange"
                type="daterange"
                start-placeholder="开始时间"
                end-placeholder="结束时间"
                value-format="YYYY-MM-DD mm:HH:ss"
            />
          </el-form-item>
        </el-form>
      </el-col>
      <el-col style="margin-bottom: 8px;">
        <el-row :gutter="20">
          <el-col :span="1.5">
            <el-button type="primary" icon="Search" @click="getProblemsetList">查询</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button icon="Refresh" @click="resetQueryParams">重置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="primary" icon="Plus" plain @click="openForm()">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="Delete" plain :disabled="multiple" @click="handleDelete()">删除</el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col>
        <el-table :data="problemsetList" @selection-change="handleSelectionChange" border style="margin-bottom: 8px;">
          <el-table-column type="selection" />
          <el-table-column label="标题" prop="title" />
          <el-table-column label="描述" prop="description" />
          <el-table-column label="创建时间" prop="createTime" />
          <el-table-column label="更新时间" prop="updateTime" />
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" @click="openForm(scope.row.id)" link><el-icon><Edit /></el-icon>修改</el-button>
              <el-button type="danger" @click="handleDelete(scope.row.id)" link><el-icon><Delete /></el-icon>删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            v-model:current-page="queryParams.current"
            v-model:page-size="queryParams.pageSize"
            :page-sizes="[5, 10, 15, 20]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="getProblemsetList"
            @current-change="getProblemsetList"
        />
        <ProblemsetForm ref="problemsetFormRef" @success="getProblemsetList" />
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>
</style>
