<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/8
  Time: 11:37
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

  <title>ssmo</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
  <script type="text/javascript"
          src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js">
  </script>
  <script>
    function ck(co, ct) {
      if (confirm("确认删除" + ct + "?")) {
        alert(co);
        //window.location.href="deleteToy?id="+co;
        $.post("deleteToy", {
          id:co
        }, function(data) {

          $("#" + co).remove();

        }, "json")
      }
    }
  </script>

  <script>
    function cn() {
      alert("co");
      window.location.href="add.jsp";
    }
  </script>
</head>

<body>

<div class="container" style="margin-top:10px">
  <h1>Spring MVC +Spring mybatis + Oracle</h1>
</div>
<div style="margin:10px;">
  <form action="toylist" method="post">
    <div class="form-group">
      <input type="text" name="name" placeholder="玩具名"
             class="form-control">
    </div>
    <button type="submit" class="btn btn-success btn-block">查询</button>
  </form>
  <br>
  <button onclick="cn()" class="btn btn-info btn-block">新增</button>
</div>
<div class="container" style="...">
  <table class="table table-striped table-hover">
    <thead>
    <tr>
      <td>玩具名</td>
      <td>价格</td>
      <td>销售日期</td>
      <td>操作</td>
    </tr>
    </thead>
    <c:forEach items="${requestScope.toys }" var="toy">
      <tr id="${toy.id}">
        <td>${toy.name}</td>
        <td>${toy.price}</td>
        <td><fmt:formatDate value="${toy.saleDate}"
                            pattern="yyyy-MM-dd" /></td>
        <td><a class="btn btn-primary" role="button"
               href="findById?id=${toy.id}">修改</a> &nbsp; <a
                class="btn btn-danger" role="button"
                href="javascript:ck(${toy.id},'${toy.name}')">删除</a></td>
      </tr>
    </c:forEach>

  </table>

</div>
<p style="color:red;">${message}</p>

</body>
</html>
