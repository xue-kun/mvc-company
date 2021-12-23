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
                $("#errorusername").remove()
                if ($(this).val() === ""){
                    $("#username").after("<span id='errorusername' style=\"color: red;margin-left: 10px\"><small>用户名不能为空</small></span>")
                }
            })

            $("#password").blur(function () {
                $("#errorupassword").remove()
                if ($(this).val() === ""){
                    $("#password").after("<span id='errorupassword' style=\"color: red;margin-left: 10px\"><small>密码不能为空</small></span>")
                }
            })

            $(".sendLogin").click(function () {
                var username=$("#username").val()
                var password=$("#password").val()
                $.ajax({
                    type : "post",
                    url : "iflogin",
                    data : {
                        "username":username,
                        "password":password
                    },
                    success : function (data) {
                        if (data === "0"){
                            alert(0)
                            location.href="select"
                        }
                        if (data === "1"){
                            alert(1)
                            $("#username").after("<span id='errorusername' style=\"color: red;margin-left: 10px\"><small>用户名错误</small></span>")
                        }
                        if (data === "2"){
                            alert(2)
                            $("#password").after("<span id='errorupassword' style=\"color: red;margin-left: 10px\"><small>密码错误</small></span>")
                        }

                    },
                    error:function () {
                        alert("服务器很忙")
                    }
                })

            })
        })


    </script>

</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row body">
        <form class="form-horizontal" method="post">
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
                    <button type="button" class="btn btn-default sendLogin">登陆</button>
                    <button type="button" class="btn btn-default" onclick="location.href='registerView'">注册</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>

</body>
</html>
