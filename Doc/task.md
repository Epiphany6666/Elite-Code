# P0

**复习类**

- [x] JDBC回顾

- [x] ServerSocket回顾

- [ ] JavaWeb回顾

- [ ] SSM回顾

  前端

- [x] TS回顾

- [x] React回顾

- [ ] 学习SpringSecurity

**项目搭建（后端）**

- [x] 创建Maven项目
- [x] 搭建SpringBoot工程，使用2.7.2版本
- [ ] 库表设计
  - [x] 用户表
  - [ ]  题目表
  - [ ] 题库表
  - [ ] 题目关联表
- [x] 使用CDN和轻量应用服务器搭建个人图床
  - [x] 搭建宝塔
  - [x] 静态网址绑定
  - [x] 搭建git
  - [x] 启动CDN加速
  - [x] 编写教程
- [x] 连接数据库
- [x] 整合Druid
- [x] 整合Knife4j：https://doc.xiaominfo.com/docs/quick-start
- [x] 封装自定义异常类
- [x] 全局异常处理器
- [x] 通用返回类
- [x] 规划后端项目目录
- [x] 分层领域模型包规划：创建用户DTO、VO
- [x] MyBatis别名配置
- [x] 解决跨域
- [x] 修改selectUserByUserAccountAndUserPassword为selectUserByUserAccount，原因：不仅仅是用户登录要用到selectUserByUserAccount，用户注册也需要用到
- [x] 将日志打印修改为自定义xml文件，同时修改MyBatis日志打印工具为Logback
- [ ] 实体类角色字段类型修改为List，修改XML文件使数据库字段String-JSON类型与实体类字段List类型进行转换
- [ ] 整理task，将已完成的任务移到后面，重新规划需要完成的任务
- [ ] 学习Excel，将task抽取为：开发进度.xlsx
- [ ] 坚持写工作周报
  参考：https://blog.csdn.net/qq_39609151/article/details/83780540

**项目搭建（前端）**

- [x] 初始化NextJS工程

- [x] 引入AntDesign组件库

- [x] 通用布局

- [ ] 登录 / 注册页面

- [x] 生产环境和本地环境配置：https://nextjs.org/docs/app/building-your-application/configuring/environment-variables

  ![image-20241203185346267](./assets/image-20241203185346267.png)

**用户模块（后端）**

- [x] 注册
- [x] 登录
- [ ] 注销
- [ ] 分页获取用户数据
- [ ] 修改用户信息
- [ ] 获取个人信息
- [ ] 整合ThreadLocal

---

# P1

- [ ] 登录改写JWT
- [ ] 将角色抽取成角色表，建立 "用户-角色" 关联表





---

# P2

用户模块



域名

- [ ] `elite-code.cn` 域名购买
- [ ] 域名备案





---

# P3

用户模块

- [ ] 忘记密码
- [ ] 将用户表中的角色字段抽取出来，做成用户表，然后新建 `用户-角色关联表`



其他

- [ ] 网站图标更换
- [ ] 将项目模块化
  - [ ] （写博客）使用IDEA查看模块之间的依赖关系：https://blog.csdn.net/qq_27579471/article/details/121557639



---

# git

- [x] Commit message（提交说明）规范

  阿里云的回答：https://zhuanlan.zhihu.com/p/182553920

- [ ] tag复习

- [ ] github中的release是如何产生的

- [ ] Issue 提问的正确方式

  教程：https://blog.csdn.net/cool99781/article/details/105821546

  提问规范：https://github.com/ReadingPapers/Report/issues/2