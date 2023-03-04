<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>logon</title>
   <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        #img {
            background-image: url("bootstrap/image/beijing.gif");
        }

        .container {
            background-color: steelblue;
            border-radius: 15px;
            margin-top: 10px;
        }
    </style>
</head>
<body id="img">
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/indexservlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <hr/>
        <div class="form-group">
            <input class="btn btn btn-danger" type="submit" value="登录" style="float: left">
            <a href="${pageContext.request.contextPath}/forget.jsp" style="float: right"><input type="button" class="btn btn-warning" value="忘记密码"></a>
        </div>
        <br/><br/>
        <div class="row">
            <div class="col-md-3 "></div>
            <div class="col-md-6 text-center"><span style="color: red;font-size: 20px">${usernull}</span></div>
            <div class="col-md-3 "></div>
        </div>
    </form>
</div>

</body>
</html>