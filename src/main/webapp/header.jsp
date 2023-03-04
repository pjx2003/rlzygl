<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="home.jsp">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/paginationservlet" title="对所有的员工进行相应的操作">员工管理</a></li>
                <li><a href="${pageContext.request.contextPath}/networkservlet" title="对所有的管理员进行相应的操作">系统管理</a></li>
                <li><a href="${pageContext.request.contextPath}/trainingservlet" title="对所有的培训机构进行相应的操作">培训管理</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">用户: ${um.username}</a></li>
                <li><a href="#" id="del" onclick="del();" title="注销当前的用户">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
<script>
    function del() {
        if (confirm("确定注销吗?")) {
            <%request.getSession().removeAttribute("username");%>
            location.href = "index.jsp";
            window.alert("注销成功!")
        }
    }

</script>
</body>
</html>
