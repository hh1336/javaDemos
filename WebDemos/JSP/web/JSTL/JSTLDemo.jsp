<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--test为必须属性，接收一个boolean，true才显示--%>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list", list);
    request.setAttribute("week", 7);
%>
<h2>这是if标签</h2>
<c:if test="${not empty requestScope.list}">
    <h3>这是真的</h3>
</c:if>
<hr>
<h2>这是choose标签，相当于which</h2>
<c:choose>
    <c:when test="${week == 1}">周一</c:when>
    <c:when test="${week == 2}">周二</c:when>
    <c:when test="${week == 3}">周三</c:when>
    <c:when test="${week == 4}">周四</c:when>
    <c:when test="${week == 5}">周五</c:when>
    <c:when test="${week == 6}">周六</c:when>
    <c:otherwise>周Ⅶ</c:otherwise>
</c:choose>
<hr>
<h2>这是for标签</h2>
<%--
forEach的属性：
begin:开始值
ned:结束值
var：临时变量
step：步长
varStatus: 循环状态对象   index：容器中元素的索引     count：循环次数
items: 需要遍历的数据源
--%>
<c:forEach var="str" begin="0" end="${list.size()-1}" step="1" >
    <h3>${list[str]}</h3>
</c:forEach>
<hr>
<%--这是foreach循环--%>
<c:forEach var="str" items="${list}" varStatus="s">
    <h3>${str}</h3>
</c:forEach>
</body>
</html>
