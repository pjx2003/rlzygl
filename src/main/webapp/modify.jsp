<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改界面</title>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="bootstrap/js/jquery-3.6.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        #bg {
            background-image: url("bootstrap/image/beijing.gif");
        }

        .container {
            margin-top: 20px;
            width: 400px;
            background-color: steelblue;
            border-radius: 10px;
        }

    </style>
</head>
<body id="bg">
<div class="container">
    <h3 style="text-align: center;">员工修改</h3>
    <form action="${pageContext.request.contextPath}/modify1servlet" method="post">
        <c:forEach var="v" items="${modify1}">
            <input type="text" name="id" style="display: none" value="${v.id}">
            <div class="form-group">
                <label for="username">姓名：</label>
                <input type="text" class="form-control" id="username" name="username" value="${v.username}"/>
            </div>

            <div class="form-group">
                <label for="password">密码：</label>
                <input type="text" class="form-control" id="password" name="password" value="${v.password}"/>
            </div>

            <div class="form-group">
                <label>性别：</label>
                <c:if test="${v.gender=='男'}">
                    <input type="radio" name="gender" value="男" checked/>男
                    <input type="radio" name="gender" value="女"/>女
                </c:if>

                <c:if test="${v.gender=='女'}">
                    <input type="radio" name="gender" value="男"/>男
                    <input type="radio" name="gender" value="女" checked/>女
                </c:if>
            </div>

            <div class="form-group">
                <label for="age">年龄：</label>
                <input type="text" class="form-control" id="age" name="age" value="${v.age}"/>
            </div>

            <div class="form-group">
                <label for="phone">手机：</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${v.phone}"/>
            </div>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8" style="font-size: 15px;color: red;text-align: center"></div>
                <div class="col-md-2"></div>
            </div>

            <div class="form-group" style="text-align: center">
                <input class="btn btn-success" type="submit" value="修改"/>
                <input class="btn btn-danger" type="reset" value="重置"/>
                <input class="btn btn-default" type="button" value="返回" onclick="Javascript:history.back(-1)">
            </div>
        </c:forEach>
    </form>
</div>
</body>
</html>
