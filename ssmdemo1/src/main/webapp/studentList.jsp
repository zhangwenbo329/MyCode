<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/15
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/studentAddEdit">新增</a>
<table width="100%" border="1">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>生日</td>
        <td>班级</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr><td>${student.stuId}</td>
            <td>${student.stuName}</td>
             <td>${student.stuSex==0?"女":"男"}</td>
            <td><fmt:formatDate value="${student.stuBirth}" pattern="yyyy-MM-dd"/></td>
            <td>${student.classInfo.className}</td>
        <td><a href="/studentUpdateEdit?stuId=${student.stuId}">修改</a></td></tr>
        <td><a href="/delete?stuId=${student.stuId}">删除</a></td>
    </c:forEach>
    <%--<tr>
        <td><a href="/students/${pageNo-1}">上一页</a></td>
        <td>当前${pageNo}页</td>
        <td></td>
        <td><a href="/students/${pageNo+1}">下一页</a></td>
        <td>共${pageCnt}页</td>
    </tr>--%>
</table>
</body>
</html>
