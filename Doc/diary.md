# 2025-6-7

开发到现在，才意识到一个很严重的问题：我没有将 **客户端** 和 **后台** 的API区分开来。

一开始我自信的以为用户使用的系统和后台管理系统可以使用同一套API，但这样做所面临的问题就是：

1. 用户和管理员能看见的题目信息是不一样的，客户端只需要返回必要的数据，例如创建者、更新者、创建时间、更新时间等就没必要返回给前端
2. 两者所接受的参数也可能不同，例如用户只可以使用title所搜题目；而后台应更灵活，可以根据内容、创建者、更新者、时间范围等分开进行搜索

我找到了相关资料：

- 这个贴支持分离：
  http://www.iteye.com/topic/1113741
  也有提到安全问题的
  http://stackoverflow.com/questions/9813174/best-practice-for-deploying-administration-area-in-java-web-application
- 有不支持分离的：
  http://programmers.stackexchange.com/questions/212938/shall-i-separate-the-admin-part-from-the-rest-of-the-war?answertab=votes#tab-top

最终，我决定将elitecode项目客户端与后台API分开。



---

