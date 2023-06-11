<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="bootstrap/css/main.css">
</head>
<body id="img">
<div class="container">
    <h3 style="text-align: center;">员工注册</h3>
    <form action="${pageContext.request.contextPath}/registerservlet" method="post">
        <div class="form-group">
            <label for="username">姓名：</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" value="男" checked/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label for="department">部门：</label>
            <select name="department" class="form-control" id="department">
                <option value="人事部">人事部</option>
                <option value="培训管理部">培训管理部</option>
                <option value="财务部">财务部</option>
                <option value="研发部">研发部</option>
            </select>
        </div>

        <div class="form-group">
            <label for="phone">手机：</label>
            <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号码"/>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8" style="font-size: 15px;color: red;text-align: center">${error}</div>
            <div class="col-md-2"></div>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-success" type="submit" value="注册"/>
            <input class="btn btn-danger" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回" onclick="Javascript:history.back(-1)">
        </div>
    </form>
</div>
</body>
</html>
