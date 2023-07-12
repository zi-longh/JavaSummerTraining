```url
/goods/updateGoodlocalhost/goods/updateGood?goodsNum=1&goodsName=绿茶&goodsType=饮料&goodsPrice=6&goodsCost=1
```

update 出现问题，如下

````
# HTTP Status 500 - Request processing failed; nested exception is org.springframework.jdbc.BadSqlGrammarException:

------

**type** Exception report

**message** Request processing failed; nested exception is org.springframework.jdbc.BadSqlGrammarException:

**description** The server encountered an internal error that prevented it from fulfilling this request.

**exception**

```
org.springframework.web.util.NestedServletException: Request processing failed; nested exception is org.springframework.jdbc.BadSqlGrammarException: 
### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
### The error may exist in file [C:\Users\penguinaiha\Desktop\JavaSummerTraining-main\target\classes\mapper\GoodsMapper.xml]
### The error may involve com.neu.edu.mapper.GoodsMapper.updateGood-Inline
### The error occurred while setting parameters
### SQL: update goods set goodsName = ?, goodsType = ?, goodsPrice = ?, goodsCost = ?     where id = ?
### Cause: java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:728)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:94)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
```



**root cause**

```
org.springframework.jdbc.BadSqlGrammarException: 
### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
### The error may exist in file [C:\Users\penguinaiha\Desktop\JavaSummerTraining-main\target\classes\mapper\GoodsMapper.xml]
### The error may involve com.neu.edu.mapper.GoodsMapper.updateGood-Inline
### The error occurred while setting parameters
### SQL: update goods set goodsName = ?, goodsType = ?, goodsPrice = ?, goodsCost = ?     where id = ?
### Cause: java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
	org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:239)
	org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:70)
	org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	com.sun.proxy.$Proxy35.update(Unknown Source)
	org.mybatis.spring.SqlSessionTemplate.update(SqlSessionTemplate.java:294)
	org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:67)
	org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:152)
	org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:85)
	com.sun.proxy.$Proxy36.updateGood(Unknown Source)
	com.neu.edu.service.impl.GoodsServiceImpl.updateGood(GoodsServiceImpl.java:130)
	com.neu.edu.controller.GoodsController.updateGoods(GoodsController.java:44)
	sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	java.lang.reflect.Method.invoke(Method.java:498)
	org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)
	org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)
	org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894)
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
	org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1060)
	org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962)
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:728)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:94)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
```



**root cause**

```
java.sql.SQLSyntaxErrorException: Unknown column 'id' in 'where clause'
	com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:121)
	com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
	com.mysql.cj.jdbc.ClientPreparedStatement.executeInternal(ClientPreparedStatement.java:916)
	com.mysql.cj.jdbc.ClientPreparedStatement.execute(ClientPreparedStatement.java:354)
	com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:483)
	org.apache.ibatis.executor.statement.PreparedStatementHandler.update(PreparedStatementHandler.java:47)
	org.apache.ibatis.executor.statement.RoutingStatementHandler.update(RoutingStatementHandler.java:74)
	org.apache.ibatis.executor.SimpleExecutor.doUpdate(SimpleExecutor.java:50)
	org.apache.ibatis.executor.BaseExecutor.update(BaseExecutor.java:117)
	org.apache.ibatis.executor.CachingExecutor.update(CachingExecutor.java:76)
	org.apache.ibatis.session.defaults.DefaultSqlSession.update(DefaultSqlSession.java:197)
	sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	java.lang.reflect.Method.invoke(Method.java:498)
	org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	com.sun.proxy.$Proxy35.update(Unknown Source)
	org.mybatis.spring.SqlSessionTemplate.update(SqlSessionTemplate.java:294)
	org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:67)
	org.apache.ibatis.binding.MapperProxy$PlainMethodInvoker.invoke(MapperProxy.java:152)
	org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:85)
	com.sun.proxy.$Proxy36.updateGood(Unknown Source)
	com.neu.edu.service.impl.GoodsServiceImpl.updateGood(GoodsServiceImpl.java:130)
	com.neu.edu.controller.GoodsController.updateGoods(GoodsController.java:44)
	sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	java.lang.reflect.Method.invoke(Method.java:498)
	org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197)
	org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141)
	org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894)
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808)
	org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1060)
	org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962)
	org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)
	org.springframework.web.servlet.FrameworkServlet.doPut(FrameworkServlet.java:920)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)
	javax.servlet.http.HttpServlet.service(HttpServlet.java:728)
	org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)
	org.springframework.web.filter.HiddenHttpMethodFilter.doFilterInternal(HiddenHttpMethodFilter.java:94)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
	org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)
```



**note** The full stack trace of the root cause is available in the Apache Tomcat/7.0.47 logs.

------

### Apache Tomcat/7.0.47
````

