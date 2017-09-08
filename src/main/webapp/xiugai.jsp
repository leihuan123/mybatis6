<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

</head>

<body>
<form action="updateToy" method="post">
  <table>
    <tr><td>玩具编号：</td><td>${requestScope.toy.id} <input type="hidden" name="id" value="${requestScope.toy.id}"></td></tr>
    <tr><td>玩具名字：</td><td><input type="text" name="name" value="${requestScope.toy.name}"></td></tr>
    <tr><td>玩具价格：</td><td><input type="number" name="price" value="${requestScope.toy.price}"></td></tr>
    <tr><td>制造时间：</td><td><input type="text" name="saleDate" value="${requestScope.date}"></td></tr>
    <%--  <fmt:formatDate value="${requestScope.toy.saleDate}" pattern="yyyy-MM-dd"/> --%>
    <tr><td><button type="submit" class="btn btn-primary">提交</button></td>
      <td><button type="reset" class="btn btn-default">重置</button></td>
    </tr>
  </table>
  <p style="color:red;">${requestScope.message}</p>
</form>
</body>
</body>
</html>
