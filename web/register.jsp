<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>addEmp</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <script>
        $(function () {

            $("#username").blur(function () {
                var username=$(this).val()
                var register=/^[a-z]{4,6}$/;

                if (register.test(username)){

                    $.ajax({
                        type: "get",
                        url: "checkRegister",
                        data: {
                            username:username
                        },
                        success:function (data) {
                            if (data.trim() == "false"){
                                alert("用户名已存在")
                            }
                        },
                        error:function () {
                            alert("服务器很忙")
                        }
                    });

                }else {
                    alert("请输入4-6位小写英文字母")
                }

            })
        })


    </script>


</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal" action="register" method="post">
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
                    <button type="submit" class="btn btn-default">注册</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>

</body>
</html>
