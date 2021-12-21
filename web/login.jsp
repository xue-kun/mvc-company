<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>addEmp</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">

    <script>

        $(".sendLogin").click(function () {

            <c:forEach items="${stateCode}" var="code">
            var c=${code.code}
            alert(c);
            if ( c===1){
                location.href="emplist";
            }else {
                alert(${code.message})
            }
            </c:forEach>
        })


    </script>



</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal" action="iflogin" method="get">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" placeholder="username" name="username">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">password</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="password" name="password">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default sendLogin">登陆</button>
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
