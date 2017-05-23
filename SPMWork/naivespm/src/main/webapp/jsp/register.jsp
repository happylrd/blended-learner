<%@ page language="java" import="java.util.*" contentType="text/html;  charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>"教育部-IBM精品课程建设项目”软件项目管理课程</title>

    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <style>
        <%-- just for footer --%>
        body {
            display: flex;
            min-height: 100vh;
            flex-direction: column;
        }

        main {
            flex: 1 0 auto;
        }
    </style>

    <script type="text/javascript">
        function doLogin() {
            $('#login_form').submit();
        }

        function loginCheck() {
            // TODO: will add check later
        }

        function doRegister() {
            $('#register_form').submit();
        }
    </script>
</head>

<body>

<nav>
    <div class="nav-wrapper light-blue lighten-2">
        <a href="https://github.com/happylrd/buptsse-workbooks/tree/master/SPMWork" class="brand-logo"><i
                class="material-icons">cloud</i>软件项目管理</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="http://sse.bupt.edu.cn/">buptsse</a></li>
        </ul>
    </div>
</nav>

<main style="margin-top: 30px">
    <div class="container">

        <div class="row">
            <div class="col s6 offset-s3">
                <ul class="tabs tabs-fixed-width">
                    <li class="tab col s3"><a class="active" href="#login_tab">登录</a></li>
                    <li class="tab col s3"><a href="#register_tab">注册</a></li>
                </ul>
            </div>
        </div>

        <div class="row" id="login_tab">
            <div class="col s6 offset-s3">
                <div class="center-align">
                    <div class="card-panel white">
                        <div class="row">

                            <form class="col s12" action="login.do" method="post" id="login_form">

                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">account_circle</i>

                                        <input id="login_username" type="text" class="validate" pattern="^\d{10}$"
                                               name="username">
                                        <label for="login_username" data-error="用户名必须为10位数字"
                                               data-success="right">用户名</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="login_password" type="password" class="validate"
                                               pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,30}$"
                                               name="password">
                                        <label for="login_password" data-error="密码不少于6位，不多于30位，只能包含并同时包含字母和数字"
                                               data-success="right">密码</label>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col s12">
                                        <a class="waves-effect waves-light btn" onclick="doLogin()">
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

        <div class="row" id="register_tab">
            <div class="col s6 offset-s3">
                <div class="center-align">
                    <div class="card-panel white">
                        <div class="row">

                            <form class="col s12" action="register.do" method="post" id="register_form">

                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">account_circle</i>

                                        <input id="register_username" type="text" class="validate" pattern="^\d{10}$"
                                               name="username">
                                        <label for="register_username" data-error="用户名必须为10位数字"
                                               data-success="right">用户名</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="register_password" type="password" class="validate"
                                               pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,30}$"
                                               name="password">
                                        <label for="register_password" data-error="密码不少于6位，不多于30位，只能包含并同时包含字母和数字"
                                               data-success="right">密码</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <i class="material-icons prefix">lock</i>
                                        <input id="register_password_again" type="password" class="validate"
                                               name="password1">
                                        <label for="register_password_again">再次输入密码</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col s12">
                                        <a class="waves-effect waves-light btn" onclick="doRegister()">
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
    </div>
</main>

<footer class="page-footer light-blue lighten-2">
    <div class="footer-copyright">
        <div class="container">
            © 2017 Copyright BUPTSSE-SPM
            <a class="grey-text text-lighten-4 right" href="#">更多链接</a>
        </div>
    </div>
</footer>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
</body>
</html>