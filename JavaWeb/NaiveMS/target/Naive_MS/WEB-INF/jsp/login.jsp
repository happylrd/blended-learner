<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>NaiveMS→登录</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css"
          media="screen,projection"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script>
        function checkLoginInfo() {
            if ("" == $("#loginUsername").val()) {
                $("#loginUsername").tips({
                    side: 2,
                    msg: '用户名不得为空',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#loginUsername").focus();
                return false;
            }
            if ($("#loginPassword").val() == "") {

                $("#loginPassword").tips({
                    side: 2,
                    msg: '密码不得为空',
                    bg: '#AE81FF',
                    time: 3
                });
                $("#loginPassword").focus();
                return false;
            }
            return true;
        }

        function webLogin() {
            if (checkLoginInfo()) {
                var username = $("#loginUsername").val();
                var password = $("#loginPassword").val();
                $.ajax({
                    type: "POST",
                    url: '<%=request.getContextPath()%>/userAction/login',
                    data: {username: username, password: password},
                    dataType: 'json',
                    cache: false,
                    success: function (data) {
                        if (data.code == 1) {
                            window.location.href = data.data.nextUrl;
                        } else {
                            alert(data.msg);
                            $("#loginUsername").focus();
                        }
                    }
                });
            }
        }
    </script>
</head>

<body background="${pageContext.request.contextPath}/static/images/bg_login.jpg">
<nav>
    <div class="nav-wrapper cyan">
        <a href="#" class="brand-logo"><i class="material-icons">cloud</i>NaiveMS</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#"><i class="material-icons">search</i></a></li>
            <li><a href="${pageContext.request.contextPath}/mvc/signUp">前往注册页</a></li>
            <li><a href="#"><i class="material-icons">refresh</i></a></li>
            <li><a href="#"><i class="material-icons">more_vert</i></a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row mock-vertical-center">
        <div class="col s6 offset-s3">
            <div class="card-panel white">
                <div class="row">

                    <form class="col s12" action=""
                          accept-charset="utf-8" method="post">
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">account_circle</i>

                                <input id="loginUsername" type="text" class="validate">

                                <label for="loginUsername">用户名</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">lock</i>
                                <input id="loginPassword" type="password" class="validate">
                                <label for="loginPassword">密码</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s6 offset-s3">
                                <a class="waves-effect waves-light btn" onclick="webLogin()">
                                    <i class="material-icons right">send</i>登录
                                </a>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<!--Import jQuery before materialize.js-->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.tips.js"></script>
<script src="${pageContext.request.contextPath}/static/js/materialize.min.js"></script>
</body>
</html>
