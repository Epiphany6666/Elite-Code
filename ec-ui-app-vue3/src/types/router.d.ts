import 'vue-router'

// 扩展 RouteMeta 接口
declare module 'vue-router' {
  interface RouteMeta {
    title?: string;
    hidden?: boolean;
  }
}
