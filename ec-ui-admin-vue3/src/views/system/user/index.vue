<script setup lang="ts">
import {reactive, ref} from "vue";
import {listUser} from "@/api/user.ts";
import type {UserDO, UserQueryReqVO} from "@/types/user";

const total = ref(0)
const queryParams = reactive<UserQueryReqVO>({
  current: 1, // 当前页
  pageSize: 5, // 每页大小
})

const userList = ref<Array<UserDO>>([])
function getList() {
  listUser(queryParams).then(res => {
    userList.value = res.data.list
    total.value = res.data.total
  })
}
getList()
</script>

<template>
  <el-table :data="userList" style="width: 100%">
    <el-table-column type="selection" width="55" />
    <el-table-column prop="username" label="用户名" width="180" />
    <el-table-column prop="nickName" label="用户别名" width="180" />
    <el-table-column prop="createTime" label="创建时间" width="180" />
    <el-table-column prop="updateTime" label="更新时间" width="180" />
  </el-table>
  <br>
  <el-pagination
      v-model:current-page="queryParams.current"
      v-model:page-size="queryParams.pageSize"
      :page-sizes="[5, 10, 15, 20]"
      size="default"
      layout="sizes, prev, pager, next"
      :total="total"
      @size-change="getList"
      @current-change="getList"
  />
</template>

<style scoped>
</style>
