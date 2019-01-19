<%@page contentType="text/html;charset=utf-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<body>
<h2>Hello World!</h2>
<form action="/login">
    用户名
    <input type="text" name="userName"/>
    密码
    <input type="text" name="userPass"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
