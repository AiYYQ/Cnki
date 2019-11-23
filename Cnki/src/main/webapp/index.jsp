<%--
  Created by IntelliJ IDEA.
  User: YQ520
  Date: 2019/11/21
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form enctype="multipart/form-data" action="uploadFile" method="post">
    <input type="file" name="file"/><br>
    <input type="submit" value="提交"/>
</form>

<hr>

<form method="post" action="insertUser">
    学号:<input type="text" name="siid"/><br>
    姓名:<input type="text" name="siname"/><br>
    <input type="submit" value="提交" />
</form>
</body>
</html>
