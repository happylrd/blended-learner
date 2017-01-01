<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>NaiveMS→注册</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css"
          media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script>
        function webReg() {
            if ($('#signUpUsername').val() == "") {
                $('#signUpUsername').focus();
                $("#signUpUsername").tips({
                    side: 2,
                    msg: '用户名不能为空',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            if ($('#signUpUsername').val().length < 4 || $('#signUpUsername').val().length > 16) {
                $('#signUpUsername').focus();
                $("#signUpUsername").tips({
                    side: 2,
                    msg: '用户名位6-16字符',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            if ($('#signUpPasswordOne').val().length < 6) {
                $('#signUpPasswordOne').focus();
                $("#signUpPasswordOne").tips({
                    side: 2,
                    msg: '密码不能小于6位',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }
            if ($('#signUpPasswordTwo').val() != $('#signUpPasswordOne').val()) {
                $('#signUpPasswordTwo').focus();
                $("#signUpPasswordTwo").tips({
                    side: 2,
                    msg: '两次密码不一致',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            var sqq = /^1[34578]\d{9}$/;
            if (!sqq.test($('#cellphoneNumber').val())
                    || $('#cellphoneNumber').val().length < 11
                    || $('#cellphoneNumber').val().length > 14
                    || $('#cellphoneNumber').val() == "") {

                $('#cellphoneNumber').focus();
                $("#cellphoneNumber").tips({
                    side: 2,
                    msg: '手机号不正确',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            if ($('#name').val().length < 2
                    || $('#name').val().length > 16
                    || $('#name').val() == "") {

                $('#name').focus();

                $("#name").tips({
                    side: 2,
                    msg: '用户姓名必须为4-16位字符',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            if ($('#sex').val() == "") {
                $('#sex').focus();
                $("#sex").tips({
                    side: 2,
                    msg: '性别不能为空',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            if ($('#age').val() == "") {
                $('#age').focus();
                $("#age").tips({
                    side: 2,
                    msg: '年龄不能为空',
                    bg: '#AE81FF',
                    time: 3
                });
                return false;
            }

            var username = $("#signUpUsername").val();
            var password = $("#signUpPasswordOne").val();
            var cellphoneNumber = $("#cellphoneNumber").val();
            var name = $("#name").val();
            var sex = $("#sex").val();
            var age = $("#age").val();

            $.ajax({
                type: "POST",
                url: '<%=request.getContextPath()%>/userAction/doSignUp',
                data: {
                    username: username,
                    password: password,
                    cellphoneNumber: cellphoneNumber,
                    name: name,
                    sex: sex,
                    age: age
                },
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (data.code == 1) {
                        window.location.href = data.data.nextUrl;
                    } else {
                        alert(data.msg);
                        $("#signUpUsername").focus();
                    }
                }
            });
        }
    </script>
</head>

<body background="${pageContext.request.contextPath}/static/images/sign_up.jpg">
<nav>
    <div class="nav-wrapper cyan">
        <a href="#" class="brand-logo"><i class="material-icons">cloud</i>NaiveMS</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="#"><i class="material-icons">search</i></a></li>
            <li><a href="${pageContext.request.contextPath}/mvc/login">前往登录页</a></li>
            <li><a href="#"><i class="material-icons">refresh</i></a></li>
            <li><a href="#"><i class="material-icons">more_vert</i></a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <div class="col s6 offset-s3">
            <div class="card-panel white">
                <div class="row">


                    <form class="col s12" action=""
                    accept-charset="utf-8" method="post">

                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">account_circle</i>

                                <input id="signUpUsername" type="text" class="validate">

                                <label for="signUpUsername">用户名</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">lock</i>

                                <input id="signUpPasswordOne" type="password" class="validate">

                                <label for="signUpPasswordOne">密码</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">lock</i>

                                <input id="signUpPasswordTwo" type="password" class="validate">

                                <label for="signUpPasswordTwo">确认密码</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">phone_android</i>

                                <input id="cellphoneNumber" type="text" class="validate">

                                <label for="cellphoneNumber">手机号</label>
                            </div>
                        </div>


                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">face</i>

                                <input id="name" type="text" class="validate">

                                <label for="name">姓名</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">person_pin_circle</i>

                                <input id="sex" type="text" class="validate">

                                <label for="sex">性别</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6 offset-s3">
                                <i class="material-icons prefix">date_range</i>

                                <input id="age" type="text" class="validate">

                                <label for="age">年龄</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col s6 offset-s3">
                                <a class="waves-effect waves-light btn" onclick="webReg()">
                                    <i class="material-icons right">send</i>注册
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
