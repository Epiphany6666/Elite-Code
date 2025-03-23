<script setup lang="ts" name="NavbarItem">
import type { RouteRecordRaw } from 'vue-router'
import { computed, type PropType, ref } from 'vue'

const props = defineProps({
  route: {
    type: Object as PropType<RouteRecordRaw>,
    required: true
  },
  basePath: {
    type: String,
    required: true
  }
})

const onlyOneChild = ref({} as RouteRecordRaw)
const hasOneShowingChildren = (children: RouteRecordRaw[] | undefined, parent: RouteRecordRaw) => {
  if (!children) {
    children = []
  }
  const showingChildren = children.filter(router => {
    if (router?.meta?.hidden) {
      return false
    }
    onlyOneChild.value = router
    return true
  })

  // When there is only one child router, the child router is displayed by default
  if (showingChildren.length === 1) {
    console.log('@@1onlyOneChild', onlyOneChild)
    return true
  }

  // Show parent if there are no child router to display
  if (showingChildren.length === 0) {
    onlyOneChild.value = { ...parent, path: '' }
    console.log('@@0onlyOneChild', onlyOneChild)
    return true
  }
  return false
}

const resolvePath = computed(() => {
  let path = props.basePath + '/' + onlyOneChild.value.path
  if (path[path.length - 1] === '/') {
    path = path.substring(0, path.length - 1)
  }
  return path
})
</script>

<template>
  <template v-if="!route?.meta?.hidden">
    <!-- 外链功能 -->
    <a v-if="route.path.startsWith('http')" :href="route.path" target="_blank">
      <el-menu-item>
        {{ route.meta.title }}
      </el-menu-item>
    </a>
    <router-link v-else-if="hasOneShowingChildren(route.children, route) && !onlyOneChild.children"
                 :to="resolvePath">
      <el-menu-item :index="resolvePath">
        {{ onlyOneChild.meta.title }}
      </el-menu-item>
    </router-link>

    <el-sub-menu v-else :index="route.name || route.path">
      <template #title>
        {{ route.meta.title }}
      </template>

      <navbar-item
        v-for="child in route.children"
        :key="child.path"
        :route="child"
        :base-path="basePath + '/' + child.path"
      />
    </el-sub-menu>
  </template>
</template>

<style scoped lang="scss">
a {
  text-decoration: none;
}

.el-menu-item {
  height: 50px;
  padding: 0;
  margin-right: 20px;
  --el-menu-hover-text-color: #333;
  font-size: 16px;
  position: relative;

  &.is-active {
    color: #333;
    font-weight: 500;
    box-sizing: border-box;

    &:after {
      content: '';
      position: absolute;
      bottom: 0;
      left: 0;
      right: 0;
      height: 2px;
      background-color: var(--el-menu-active-color);
      z-index: 1;
    }
  }
}
</style>
