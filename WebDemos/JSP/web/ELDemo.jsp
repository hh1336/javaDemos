<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%--EL表达式用于运算与获取值操作--%>
    ${3 > 4}
<br>
\\${3 > 4} 这样写可以把EL表达式当作字符串输出

<hr>
<h3>EL表达式获取值</h3>
<%
    request.setAttribute("name","李四");
    session.setAttribute("age",18);
    User user = new User();
    user.setAge(10);
    user.setName("李四");
    session.setAttribute("user",user);
%>

${requestScope.name}
<br>
<%--从最小的域开始查找key为age的值--%>
${age}
<br>
${user.name}<br>
${user.age}<br>
${empty list}<br>
<h3>动态获取虚拟目录</h3>
${pageContext.request.contextPath}
</body>
</html>
