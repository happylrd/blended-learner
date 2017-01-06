<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>NaiveMS→后台</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css"
          media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
<nav>
    <div class="nav-wrapper cyan">
        <a href="#" class="brand-logo"><i class="material-icons">cloud</i>NaiveMS</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#"><i class="material-icons">search</i></a></li>
            <li><a href="#"><i class="material-icons">view_module</i></a></li>
            <li><a href="#"><i class="material-icons">refresh</i></a></li>
            <li><a href="#"><i class="material-icons">more_vert</i></a></li>
        </ul>
    </div>
</nav>

<ul id="slide-out" class="side-nav">
    <li>
        <div class="userView">
            <div class="background">
                <img src="${pageContext.request.contextPath}/static/images/bg_login.jpg">
            </div>
            <a href="#modal-head-portrait"><img class="circle" src="${pageContext.request.contextPath}/static/images/happylrd.jpg"></a>
            <a href="#"><span class="white-text name">Diego Li</span></a>
            <a href="#"><span class="white-text email">happylrd17@gmail.com</span></a>
        </div>
    </li>
    <li><a href="#"><i class="material-icons">cloud</i>Todo 1</a></li>
    <li><a class="waves-effect" href="#">Todo 2</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="subheader">Sub todo</a></li>
    <li><a class="waves-effect" href="#">Todo 3</a></li>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse">
    <i class="material-icons">menu</i>
</a>

<div class="container">
    <table class="highlight">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>手机号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>
        </thead>

        <tbody id="user-info-table">

        </tbody>
    </table>
</div>

<!-- Modal Structure -->
<div id="modal-head-portrait" class="modal">
    <div class="modal-content">
        <h4>Todo Modal</h4>
        <p>Todo info...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a>
    </div>
</div>

<!--Import jQuery before materialize.js-->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.tips.js"></script>
<script src="${pageContext.request.contextPath}/static/js/materialize.min.js"></script>
</body>
<script>
    $(".button-collapse").sideNav();
    $(document).ready(function(){
        $('.modal').modal();
    });
</script>
<script>
    $.ajax({
        type: "GET",
        url: '<%=request.getContextPath()%>/userAction/findOneUser?username=' + "${sessionScope.userInfo.username}",
        <%--url: '<%=request.getContextPath()%>/userAction/findUser?user='+"${sessionScope.userInfo}",--%>
        dataType: 'json',
        cache: false,
        success: function (data) {
            var logData = "${sessionScope.userInfo.username}";
            console.log(logData);

            if (data.code == 1) {
                console.log("Data: " + JSON.stringify(data));
                console.log("Data sex" + data.data.sex);

                $("#user-info-table").append("<tr><td>" + data.data.username + "</td><td>"
                        + data.data.password + "</td><td>"
                        + data.data.cellphoneNumber + "</td><td>"
                        + data.data.name + "</td><td>"
                        + data.data.sex + "</td><td>"
                        + data.data.age + "</td><td>");
            }
        }
    });
</script>
</html>
