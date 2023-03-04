<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
    <link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
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
<div class="container" style="width: 420px">
    <form action="${pageContext.request.contextPath}/forgetservlet" method="post">
        <h3 style="text-align: center">忘记密码</h3>
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="newusername" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">请输入新密码:</label>
            <input type="password" name="newpassword" class="form-control" id="password" placeholder="请输入新密码"/>
        </div>

        <div class="form-group">
            <label for="againpassword">请再输入一次新密码:</label>
            <input type="password" name="againpass" class="form-control" id="againpassword" placeholder="请再输入一次新密码"/>
        </div>

        <div class="form-group">
            <input type="submit" class="btn btn-success" value="修改" style="float: left">
            <input type="reset" class="btn btn-primary" value="清空内容" style="float: right">
        </div>
        <br/><br/>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6"><span style="font-size: 20px;color: red">${nullzhi}</span></div>
            <div class="col-md-3"></div>
        </div>
    </form>
</div>
</body>
</html>
