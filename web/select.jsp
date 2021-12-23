<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>addEmp</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">


</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
            <div class="form-group">
                <label class="col-sm-2 control-label">欢迎您：${sessionScope.user.username}</label>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg" onclick="location.href='emplist'">员工列表</button>
                    <button type="button" class="btn btn-primary btn-lg" onclick="location.href='deptlist'">部门列表</button>
                </div>
            </div>


    </div>
    <div class="row foot"></div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
