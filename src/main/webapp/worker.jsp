<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工界面</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <style>
        .success th {
            text-align: center;
        }

        #tianjia {
            float: left;
        }

        .form-inline {
            float: right;
        }

        #select {
            text-align: center;
            font-size: 15px;
            color: red;
        }
    </style>
    <script>
        function delU(v) {
            if (confirm("确定要删除吗?")) {
                location.href = "${pageContext.request.contextPath}/deleteservlet?id=" + v;
                window.alert("成功")
            }
        }
    </script>
</head>
<body>
<%--导航栏--%>
<%@include file="header.jsp" %>
<%--导航栏结束--%>
<div class="row">
    <div class="col-md-4">
        <div id="tianjia">
            <a href="register.jsp" class="btn btn-default">员工注册</a>
        </div>
    </div>

    <div class="col-md-2">
        <span id="select">${null1}</span>
    </div>

    <div class="col-md-6">
        <form class="form-inline" method="post" action="${pageContext.request.contextPath}/paginationservlet">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control" id="name" name="username" value="${pg1.username[0]}">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
            <br/>
        </form>
    </div>
</div>

<table border="1" class="table table-bordered table-hover" style="text-align: center">
    <tr class="success">
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>手机号</th>
        <th>操作</th>
    </tr>

    <c:forEach var="u" varStatus="us" items="${pg.pageShow}">

        <tr>
            <td>${us.count}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.gender}</td>
            <td>${u.age}</td>
            <td>${u.phone}</td>
            <td><a class="btn btn-default btn-sm"
                   href="${pageContext.request.contextPath}/modify1servlet?id=${u.id}">修改</a>&nbsp;
                <a class="btn btn-default btn-sm" href="javascript:delU(${u.id})">删除</a>
            </td>
        </tr>

    </c:forEach>

</table>

<%--分页--%>
<nav aria-label="Page navigation">
    <ul class="pagination">
    <%--判断当前页是否为第一页--%>
    <c:if test="${pg.nowPageCount==1}">
        <li class="disabled">
            <a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${pg.nowPageCount}&pageShowrow=5&username=${pg1.username[0]}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
    </c:if>

    <c:if test="${pg.nowPageCount!=1}">
        <li>
        <a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${pg.nowPageCount-1}&pageShowrow=5&username=${pg1.username[0]}" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
        </a>
    </c:if>
        </li>

        <c:forEach begin="1" end="${pg.pagePageCount}" var="i">
            <%--判断当前页和选中的项是否相同--%>
            <c:if test="${pg.nowPageCount==i}">
                <li class="active"><a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${i}&pageShowrow=5&username=${pg1.username[0]}">${i}</a></li>
            </c:if>
            <c:if test="${pg.nowPageCount!=i}">
                <li><a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${i}&pageShowrow=5&username=${pg1.username[0]}">${i}</a></li>
            </c:if>
        </c:forEach>

        <%--判断是否为最后一页--%>
        <c:if test="${pg.nowPageCount==pg.pagePageCount}">
        <li class="disabled">
            <a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${pg.nowPageCount}&pageShowrow=5&username=${pg1.username[0]}" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </c:if>
        <c:if test="${pg.nowPageCount!=pg.pagePageCount}">
        <li>
        <a href="${pageContext.request.contextPath}/paginationservlet?nowPageCount=${pg.nowPageCount+1}&pageShowrow=5&username=${pg1.username[0]}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
        </a>
        </c:if>

        </li>
        <span style="font-size: 20px;margin-left: 10px;">一共${pg.pageCount}条数据,共${pg.pagePageCount}页</span>
    </ul>
</nav>

</body>
</html>
