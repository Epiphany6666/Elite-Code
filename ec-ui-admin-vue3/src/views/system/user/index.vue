<script setup lang="ts">
import {reactive, ref} from "vue";
import {listUser, removeUsers} from "@/api/user.ts";
import type {UserDO, UserQueryReqVO} from "@/types/user";
import UserForm from "@/views/system/user/UserForm.vue";
import {Delete} from "@element-plus/icons-vue";

const loading = ref(true)

const total = ref(0)
const dateRange = ref<Array<Date>>([])
const queryParams = reactive<UserQueryReqVO>({
  current: 1, // 当前页
  pageSize: 10, // 每页大小
})

const formRef = ref()
const userList = ref<Array<UserDO>>([])
const ids = ref<Array<string>>([])
const multiple = ref(true)

function getList() {
  loading.value = true
  listUser(addDateRange(queryParams)).then(res => {
    loading.value = false
    userList.value = res.data.list
    total.value = res.data.total
  })
}

const addDateRange = (queryParams: UserQueryReqVO) => {
  queryParams['startTime'] = dateRange.value[0]
  queryParams['endTime'] = dateRange.value[1]
  return queryParams
}

/* 打开新增/修改的表单 */
const openFrom = (id?: string) => {
  formRef.value.open(id)
}

const handleSelectionChange = (selection) => {
  ids.value = selection.map(item => item.id)
  multiple.value = !selection.length
}

/* 删除用户信息 */
const handleDelete = (id: string) => {
  const userId = id || ids.value
  ElMessageBox.confirm(
      '是否确认删除用户编号为"' + userId + '"的数据项？',
      '系统提示',
      {
        confirmButtonText: '确认',
        cancelButtonText: '取消',
        type: 'warning',
      }
  ).then(() => {
    return removeUsers(userId)
  }).then(() => {
    getList()
    ElMessage.success('删除成功')
  })
}

getList()
</script>

<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col>
        <el-form :inline="true">
          <el-form-item label="用户名称">
            <el-input v-model="queryParams.nickName" placeholder="请输入用户名称"></el-input>
          </el-form-item>
          <el-form-item label="创建时间" style="width: 308px;">
            <el-date-picker
                v-model="dateRange"
                type="daterange"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                format="YYYY-MM-DD"
                value-format="YYYY-MM-DD HH:mm:ss"
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
            <el-button type="primary" icon="Plus" plain @click="openFrom()">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="Delete" plain :disabled="multiple" @click="handleDelete">删除</el-button>
          </el-col>
        </el-row>

        <!-- 用户列表 -->
        <el-table
            v-loading="loading"
            :data="userList"
            border
            style="width: 100%;margin-bottom: 8px;"
            @selection-change="handleSelectionChange"
        >
          <el-table-column type="selection" width="55"/>
          <el-table-column prop="username" label="用户名" width="180"/>
          <el-table-column prop="nickName" label="用户别名" width="180"/>
          <el-table-column prop="createBy" label="创建人" width="100"/>
          <el-table-column prop="updateBy" label="更新人" width="100"/>
          <el-table-column prop="createTime" label="创建时间" width="180"/>
          <el-table-column prop="updateTime" label="更新时间" width="180"/>
          <el-table-column label="操作">
            <template #default="scope">
              <el-button link type="primary" @click="openFrom(scope.row.id)">
                <el-icon><Edit/></el-icon>修改
              </el-button>
              <el-button type="danger" link @click="handleDelete(scope.row.id)">
                <el-icon><Delete/></el-icon>删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <el-pagination
            v-model:current-page="queryParams.current"
            v-model:page-size="queryParams.pageSize"
            :page-sizes="[5, 10, 15, 20]"
            size="default"
            layout="prev, pager, next, sizes, total, jumper"
            :total="total"
            @size-change="getList"
            @current-change="getList"
        />
      </el-col>

      <!-- 添加或修改用户对话框 -->
      <UserForm ref="formRef" @success="getList"/>
    </el-row>
  </div>
</template>

<style scoped>
</style>
