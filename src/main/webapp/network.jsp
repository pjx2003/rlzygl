<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统人员管理</title>
    <style>
        .success th {
            text-align: center;
        }
    </style>
</head>
<body>
<%--导航栏--%>
<%@ include file="header.jsp" %>

<div>
    <table border="1" class="table table-bordered table-hover" style="text-align: center">
        <tr class="success">
            <th>编号</th>
            <th>管理员名称</th>
            <th>管理部门</th>
            <th>所得工资(万)</th>
            <th>相关操作</th>
        </tr>
        <c:forEach var="v" varStatus="vs" items="${user}">
            <tr>
                <td>${vs.count}</td>
                <td>${v.username}</td>
                <td>${v.department}</td>
                <td>${v.wage}</td>
                <td><a class="btn btn-default btn-sm" href="">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
