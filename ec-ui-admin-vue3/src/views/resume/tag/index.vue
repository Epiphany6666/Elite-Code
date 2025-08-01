<script setup lang="ts">
import {ref} from "vue";
import type {TagDO, TagQueryDTO} from "@/types/tag";
import {getTagPage, removeTags} from "@/api/tag.ts";
import TagForm from "@/views/resume/tag/TagForm.vue";

const queryParams = ref<TagQueryDTO>({
  name: '',
  startTime: undefined,
  endTime: undefined
})
const dateRange = ref<Array<Date>>([])
const queryFormRef = ref()
const total = ref(0)
const tagList = ref<Array<TagDO>>([])
const ids = ref<Array<string>>([])
const multiple = ref(true)
const tagFormRef = ref()

const getTagList = () => {
  getTagPage(addDateRange()).then(res => {
    tagList.value = res.data.list
    total.value = res.data.total
  })
}

const addDateRange = () => {
  queryParams.value.startTime = dateRange.value[0]
  queryParams.value.endTime = dateRange.value[1]
  return queryParams.value
}

const resetQueryForm = () => {
  queryFormRef.value.resetFields()
  dateRange.value = []
  getTagList()
}

const openForm = (id?: string) => {
  tagFormRef.value.open(id)
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  multiple.value = !selection.length
}

const handleDelete = (id?: string) => {
  const tagId = id || ids.value
  ElMessageBox.confirm(
      '是否确认删除编号为"' + tagId + '"的数据项？',
      '系统提示',
      {
        cancelButtonText: '取消',
        confirmButtonText: '确认'
      }
  ).then(() => {
    removeTags(tagId).then(() => {
      getTagList()
      ElMessage.success('删除成功！')
    })
  })
}

getTagList()
</script>

<template>
  <div class="app-container">
    <el-row :gutter="10">
      <el-col>
        <el-form :model="queryParams" ref="queryFormRef" inline>
          <el-form-item label="标签名" prop="name">
            <el-input v-model="queryParams.name" placeholder="请输入标签名"/>
          </el-form-item>
          <el-form-item label="创建时间">
            <el-date-picker
                v-model="dateRange"
                type="daterange"
                start-placeholder="开始时间"
                end-placeholder="结束时间"
                value-format="YYYY-MM-DD HH:mm:ss"
            />
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <el-row :gutter="20" style="margin-bottom: 8px;">
          <el-col :span="1.5">
            <el-button type="primary" icon="Search" @click="getTagList">查询</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button icon="Refresh" @click="resetQueryForm">重置</el-button>
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
        <el-table :data="tagList" @selection-change="handleSelectionChange" border style="margin-bottom: 8px;">
          <el-table-column type="selection" />
          <el-table-column label="标签名" prop="name" />
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
            @size-change="getTagList"
            @current-change="getTagList"
        />
        <TagForm ref="tagFormRef" @success="getTagList" />
      </el-col>
    </el-row>
  </div>
</template>

<style scoped>
</style>
