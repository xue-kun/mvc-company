<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>deptlist</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <script>
        $(function () {

            $(".selectAll").click(function () {
                $(".selectOne").prop("checked",$(".selectAll").prop("checked"))
            })

            $(".deletedept").click(function () {
                var dept_ids=new Array();
                $(".selectOne").each(function (index,value) {
                    if (value.checked){
                        dept_ids.push(value.getAttribute("dept_id"))
                    }
                })
                location.href="deletedept?dept_ids=" + dept_ids
            })

        })


    </script>
</head>
<body>
<div class="container">
    <div class="row head"></div>
    <div class="row">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th><input type="checkbox" class="selectAll"></th>
                <th>#</th>
                <th>部门名称</th>
                <th>工作地点</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="dept" items="${deptlist}" varStatus="index">
                <tr>
                    <td><input type="checkbox" class="selectOne" dept_id="${dept.dept_id}"></td>
                    <td>${index.index+1}</td>
                    <td>${dept.name}</td>
                    <td>${dept.location}</td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="row">
        <div class="col-sm-9">
            <button type="button" class="btn btn-primary" onclick="location.href='adddeptview'">增加</button>
            <button type="button" class="btn btn-danger deletedept">删除</button>
        </div>
        <div class="col-sm-3">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <div class="row foot"></div>
</div>


</body>
</html>
