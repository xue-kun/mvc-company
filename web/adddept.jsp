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
        <form class="form-horizontal" action="adddept" method="get">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" placeholder="name" name="name">
                </div>
            </div>
            <div class="form-group">
                <label for="location" class="col-sm-2 control-label">location</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="location" placeholder="localhost" name="location">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
