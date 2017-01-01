<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>NaiveMS→日志表</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/materialize.min.css"
          media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <script>
        var pageNum;
        function goToNextPage() {
            pageNum = parseInt(pageNum) + 1;

            $.ajax({
                type: "GET",
                url: '<%=request.getContextPath()%>/actionLog/findLogList?pageNum=' + pageNum + '&pageSize=15',
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (data.code == 1) {
                        updateList(data);
                        pageNum = data.pageNum;
                        $("#log-controller-now").html(pageNum);
                    }
                }
            });
        }

        function goToLastPage() {
            pageNum = parseInt(pageNum) - 1;
            $.ajax({
                type: "GET",
                url: '<%=request.getContextPath()%>/actionLog/findLogList?pageNum=' + pageNum + '&pageSize=15',
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (data.code == 1) {
                        updateList(data);
                        pageNum = data.pageNum;
                        $("#log-controller-now").html(pageNum);
                    }
                }
            });
        }
    </script>
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

<div class="container">
    <table class="highlight responsive-table">
        <thead>
        <tr>
            <th>id</th>
            <th>用户</th>
            <th>请求方法</th>
            <th>访问地址</th>

            <th>IP地址</th>
            <th>时间</th>
            <th>会话ID</th>

            <th>系统名称</th>
            <th>浏览器名</th>
        </tr>
        </thead>

        <tbody id="log-table-body">
        <script id="pagetmpl" type="text/x-dot-template">
            {{ for(var i=0; i < it.length ; i++){  }}
            <tr>
                <td>{{=it[i].id}}</td>
                <td>{{=it[i].username}}</td>
                <td>{{=it[i].method}}</td>
                <td>{{=it[i].description}}</td>

                <td>{{=it[i].ipAddrV4}}</td>
                <td>{{=it[i].time}}</td>
                <td>{{=it[i].sessionId}}</td>

                <td>{{=it[i].osName}}</td>
                <td>{{=it[i].browserName}}</td>
            </tr>
            {{ } }}
        </script>
        <%--<hr>--%>
        </tbody>
    </table>

    <ul class="pagination">
        <li class="waves-effect">
            <a onclick="goToLastPage()"><i class="material-icons">chevron_left</i></a>
        </li>
        <li class="active">
            <a id="log-controller-now">1</a>
        </li>
        <li class="waves-effect">
            <a onclick="goToNextPage()"><i class="material-icons">chevron_right</i></a>
        </li>
    </ul>
</div>

<!--Import jQuery before materialize.js-->
<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.tips.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.ajaxfileupload.js"></script>
<script src="${pageContext.request.contextPath}/static/js/doT.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/materialize.min.js"></script>
</body>
<script>
    $.ajax({
        type: "GET",
        url: '<%=request.getContextPath()%>/actionLog/findLogList?pageNum=1&pageSize=15',
        dataType: 'json',
        cache: false,
        success: function (data) {
            if (data.code == 1) {
                pagefn = doT.template($("#pagetmpl").html());
                updateList(data);
                pageNum = data.pageNum;
                console.log("PageNum: " + pageNum);
            }
        }
    });

    function updateList(data) {
        $("#pagetmpl").empty();
        $("#log-table-body").html(pagefn(data.data));
    }
</script>
</html>
