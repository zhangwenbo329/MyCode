<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/18
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="studentUpdateSave" method="post">
    <table>
        <tr>
            <td>姓名</td>
            <td><input type="hidden" name="stuId" value="${student.stuId}">
                <input type="text" name="stuName" value="${student.stuName}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="stuSex" value="1" <c:if test="${student.stuSex==1}">checked</c:if>>男
                <input type="radio" name="stuSex" value="0"<c:if test="${student.stuSex==0}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="stuBirth" value="<fmt:formatDate value='${student.stuBirth}' pattern="yyyy-MM-dd"/>"></td>
        </tr>
        <tr>
            <td>班级</td>
            <td>
                <select name="classInfo.classId" id="classId">
                    <c:forEach var="c" items="${classInfoList}">
                        <c:choose>
                            <c:when test="${student.classInfo.classId==c.classId}">
                                <option value="${c.classId}" selected>${c.className}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${c.classId}">${c.className}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</html>
