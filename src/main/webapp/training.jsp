<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>培训管理</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        .success th {
            text-align: center;
        }
    </style>
</head>
<body>
<%--导航栏--%>
<%@ include file="header.jsp" %>

<table border="1" class="table table-bordered table-hover" style="text-align: center">
    <tr class="success">
        <th>编号</th>
        <th>培训名称</th>
        <th>培训负责人员</th>
        <th>培训周期</th>
        <th>操作</th>
    </tr>
    <c:forEach var="v" varStatus="vs" items="${train}">
        <tr>
            <td>${vs.count}</td>
            <td>${v.trainname}</td>
            <td>${v.trainpeople}</td>
            <td>${v.traintime}</td>
            <td><a class="btn btn-default btn-sm" href="">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a>
            </td>
        </tr>
    </c:forEach>


</table>

</body>
</html>
