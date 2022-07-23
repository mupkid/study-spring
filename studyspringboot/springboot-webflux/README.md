本 Demo 演示如何使用 SpringBoot 结合 Spring WebFlux 实现一个简单的 Web 程序。

WebFlux 可基于注解编程，也可基于函数式编程

### 注解编程
注解编程与 Spring WebMVC 方式一样。所以能够很方便从 SpringMVC 转移到 Spring WebFlux。

### 函数式编程
使用函数式编程模型时，需要自己初始化服务器

基于函数式编程模型时候，有两个核心接口：RouterFunction（实现路由功能，请求转发给对应的 handler）和 HandlerFunction（处理请求生成响应的函数）。核心任务定义两个函数式接口的实现并且启动需要的服务器。

SpringWebflux 请 求和响应不再是 ServletRequest 和 ServletResponse ，而是 ServerRequest 和 ServerResponse