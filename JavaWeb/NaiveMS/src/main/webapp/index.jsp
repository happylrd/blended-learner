<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>NaiveMS→初始页</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css"
          media="screen,projection"/>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>

<body>
<div class="slider fullscreen">
    <ul class="slides">
        <li>
            <img src="${pageContext.request.contextPath}/static/images/scenery1.jpg">
            <div class="caption center-align">
                <h3>NaiveMS</h3>
                <h5 class="light grey-text text-lighten-3">A naive management system</h5>
            </div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/static/images/scenery2.jpg">
            <div class="caption left-align">
                <h3>NaiveMS</h3>
                <h5 class="light grey-text text-lighten-3">A naive management system</h5>
            </div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/static/images/scenery3.jpg">
            <div class="caption right-align">
                <h3>NaiveMS</h3>
                <h5 class="light grey-text text-lighten-3">A naive management system</h5>
            </div>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/static/images/scenery4.jpg">
            <div class="caption center-align">
                <h3>NaiveMS</h3>
                <h5 class="light grey-text text-lighten-3">A naive management system</h5>
            </div>
        </li>
    </ul>
</div>

<div class="container">
    <div class="row mock-vertical-center-big">
        <div class="col s6 offset-s3">
            <div class="card grey lighten-3 hoverable" style="z-index: 9999">
                <div class="card-content black-text">
                    <span class="card-title">NaiveMS</span>
                    <p>A naive management system</p>
                </div>
                <div class="card-action">
                    <a href="${pageContext.request.contextPath}/mvc/login">去登录</a>
                    <a href="${pageContext.request.contextPath}/mvc/signUp">去注册</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!--Import jQuery before materialize.js-->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.tips.js"></script>
<script src="${pageContext.request.contextPath}/static/js/materialize.min.js"></script>
<script>
    $(document).ready(function () {
        $('.slider').slider({full_width: true});
    });
</script>
</body>
</html>
