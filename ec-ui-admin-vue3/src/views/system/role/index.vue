<script setup lang="ts">
import {reactive, ref} from "vue";
import {getRolePage, removeRoles} from "@/api/role.ts";
import type {RoleDO, RoleQueryReqVO} from "@/types/role";
import RoleForm from "@/views/system/role/RoleForm.vue";

const queryParams = reactive<RoleQueryReqVO>(({
  current: 1, // 当前页
  pageSize: 10, // 每页大小
  name: undefined, // 角色名
  startTime: undefined, // 开始时间
  endTime: undefined, // 结束时间
}))
const dateRange = ref<Array<Date>>([])
const roleList = ref<Array<RoleDO>>([])
const total = ref(0)
const ids = ref([])
const multiple = ref(true)
const formRef = ref()
const queryFormRef = ref()

const getList = () => {
  getRolePage(addDateRange()).then(res => {
    roleList.value = res.data.list
    total.value = res.data.total
  })
}

const addDateRange = () => {
  queryParams['startTime'] = dateRange.value[0]
  queryParams['endTime'] = dateRange.value[1]
  return queryParams
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  multiple.value = !selection.length
}

const openForm = (id) => {
  formRef.value.open(id)
}

const resetForm = () => {
  queryFormRef.value.resetFields()
}

const handleDelete = (ids) => {
  ElMessageBox.confirm(
      '是否确认删除编号为"' + ids + '"的数据项？',
      '系统提示',
      {
        confirmButtonText: 'OK',
        cancelButtonText: 'Cancel',
        type: 'warning',
      }
  ).then(() => {
    removeRoles(ids).then(() => {
      getList()
      ElMessage.success('删除成功')
    })
  })
}

getList()

</script>

<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col>
        <!-- 表单查询 -->
        <el-form ref="queryFormRef" inline :model="queryParams">
          <el-form-item label="角色名称">
            <el-input v-model="queryParams.name" placeholder="请输入角色名称"></el-input>
          </el-form-item>
          <el-form-item v-model="dateRange" label="创建时间">
            <el-date-picker
                v-model="dateRange"
                type="daterange"
                start-placeholder="开始时间"
                end-placeholder="结束时间"
                format="YYYY-MM-DD"
                value-format="YYYY-MM-DD mm:HH:ss"
            />
          </el-form-item>
        </el-form>
      </el-col>
      <el-col>
        <el-row :gutter="10" style="margin-bottom: 8px;">
          <el-col :span="1.5">
            <el-button type="primary" icon="Search" @click="getList">查询</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button @click="resetForm">重置</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple">删除</el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col>
        <el-table :data="roleList" border @selection-change="handleSelectionChange" style="margin-bottom: 8px;">
          <el-table-column type="selection"></el-table-column>
          <el-table-column prop="name" label="角色名"/>
          <el-table-column prop="createBy" label="创建人"/>
          <el-table-column prop="updateBy" label="更新人"/>
          <el-table-column prop="createTime" label="创建时间"/>
          <el-table-column prop="updateTime" label="更新时间"/>
          <el-table-column label="操作">
            <template #default="scope">
              <el-button type="primary" link @click=""><el-icon><Edit/></el-icon>修改</el-button>
              <el-button type="danger" link @click="handleDelete(scope.row.id)"><el-icon><Delete/></el-icon>删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
            v-model:current-page="queryParams.current"
            v-model:page-size="queryParams.pageSize"
            :page-sizes="[5, 10, 15, 20]"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total"
            @size-change="getList"
            @current-change="getList"
        />
      </el-col>

      <!-- 添加/修改角色对话框 -->
      <RoleForm ref="formRef" @success="getList"/>
    </el-row>
  </div>
</template>

<style scoped>
</style>
