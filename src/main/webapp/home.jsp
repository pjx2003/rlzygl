<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<%--轮播图--%>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="bootstrap/image/a.jpg" alt="员工管理" style="height: 400px;width: 1500px">
        </div>
        <div class="item">
            <img src="bootstrap/image/b.jpg" alt="员工管理" style="height: 400px;width: 1500px">
        </div>
        <div class="item">
            <img src="bootstrap/image/c.jpg" alt="员工管理" style="height: 400px;width: 1500px">
        </div>
    </div>
</div>

<%--下方的按钮--%>
<div class="row">
    <div class="col-md-3 text-center">
        <a href="#" type="button" class="btn btn-primary btn-lg btn-block">首页</a>
    </div>
    <div class="col-md-3 text-center">
        <a href="${pageContext.request.contextPath}/paginationservlet" type="button" class="btn btn-primary btn-lg btn-block">员工管理</a>
    </div>
    <div class="col-md-3 text-center">
        <a href="${pageContext.request.contextPath}/networkservlet" type="button" class="btn btn-primary btn-lg btn-block">系统管理</a>
    </div>
    <div class="col-md-3 text-center">
        <a href="${pageContext.request.contextPath}/trainingservlet" type="button" class="btn btn-primary btn-lg btn-block">培训管理</a>
    </div>
</div>

<footer class="container-fluid">
    <div class="row">
        <img src="bootstrap/image/footer_service.png" class="img-responsive">
    </div>

    <div class="row">
        <span style="font-size: 15px;color: deepskyblue">人力资源管理,人事管理的升级，是指在经济学与人本思想指导下，通过招聘、甄选、培训、
            报酬等管理形式对组织内外相关人力资源进行有效运用，满足组织当前及未来发展的需要，保
            证组织目标实现与成员发展的最大化的一系列活动的总称。</span>
    </div>
</footer>
</body>
</html>
