<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>addtoy</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>

<body>
<form action="addToy" method="post">
  <table >
    <tr><td style="align:right;">玩具名字：</td><td><input type="text" name="name"></td></tr>
    <tr><td style="align:right;">玩具价格：</td><td><input type="number" name="price"></td></tr>
    <tr><td style="align:right;">制造时间：</td><td><input type="text" name="saleDate"></td></tr>
    <tr><td colspan="2"><button type="submit" class="btn btn-primary">添加</button></td></tr>
  </table>
</form>
<p>${requestScope.meassage}</p>
</body>
</html>
