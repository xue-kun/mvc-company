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
            /*
            * 判断username是否合法以及存在
            * */
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
                            if (data.trim() === "false"){
                                $("#errorname").remove();
                                $("#username").after("<span id='errorname' style=\"color: red;margin-left: 10px\"><small>用户名已存在</small></span>")
                            }else {
                                $("#errorname").remove();
                            }
                        },
                        error:function () {
                            $("#errorname").remove();
                            $("#username").after("<span id='errorname' style=\"color: red;margin-left: 10px\"><small>服务器很忙</small></span>")
                        }
                    });
                }else {
                    $("#errorname").remove();
                    $("#username").after("<span id='errorname' style=\"color: red;margin-left: 10px\"><small>用户名请使用4-6位小数</small></span>")
                }
            })

            /*
            * 判断二次输入密码是否与第一次一致
            * */

            $("#checkpassword").blur(function () {
                var password=$("#password").val();
                var newpassword=$(this).val();
                if (password === newpassword){
                    $("#errorpassword").remove()
                }else {
                    $("#errorpassword").remove()
                    $("#checkpassword").after("<span id='errorpassword' style=\"color: red;margin-left: 10px\"><small>两次输入密码不一致</small></span>")
                }
            })


            /*
            * 判断验证码是否一致
            * */

            $("#checkcode").blur(function () {
                    $("#errorcode").remove()
                var codeNum=$(this).val();

                if (codeNum === ""){
                    $("#checkcode").after("<span id='errorcode' style=\"color: red;margin-left: 10px\"><small>验证码不能为空</small></span>")
                }else {
                    $.ajax({
                        async:false,
                        type:"get",
                        url: "getSession",
                        success:function (data) {
                            if (data === codeNum){
                                $("#errorcode").remove()

                            }else {
                                $("#errercode").remove()
                                $("#checkcode").after("<span id='errorcode' style=\"color: red;margin-left: 10px\"><small>验证码错误</small></span>")
                                $(".imageCode").attr("src","selectcodeimg?id=" + Math.random())
                            }
                        },
                        error:function () {
                        }
                    })
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
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="username" placeholder="username" name="username">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">password</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="password" placeholder="password" name="password">
                </div>
            </div>
            <div class="form-group">
                <label for="checkpassword" class="col-sm-2 control-label">Verify password</label>
                <div class="col-sm-5">
                    <input type="password" class="form-control" id="checkpassword" placeholder="username" >
                </div>
            </div>
            <div class="form-group">
                <label for="checkcode" class="col-sm-2 control-label">checkcode</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="checkcode">
                </div>
                <img class="imageCode" src="selectcodeimg">
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default register">注册</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row foot"></div>
</div>

</body>
</html>
