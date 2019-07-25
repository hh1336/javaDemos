<%--这是jsp指令，用于导入资源--%>
<%--
<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 %>
1.page：配置JSP页面
2.include：页面包含的，导入页面的资源文件
3.taglib：导入资源

--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" %>
<%--
引入一个标签库
prefix="c"为使用该标签库时的前缀
uri为标签库的地址

--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>title</title>
</head>
<body>
<%--引入一个页面文件--%>
<%@ include file="top.jsp"%>
jsp本质上就是一个Servlet
<br/>
<%--  这里面可以定义成员，里面的代码将会被解析成一个成员--%>
<%! int i = 3; %>
<br/>
c:
<%
    System.out.println("这里的代码将会被解析到Server方法中");
    out.print("这是一个java的内置对象，用于输出内容到页面上");
%>
<br>
<%= "这里面可以把变量或其他的java内容输出到页面上" %>

</body>
</html>
