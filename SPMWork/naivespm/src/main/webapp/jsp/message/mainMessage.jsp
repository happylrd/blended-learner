<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/common/taglibs.jsp" %>

<html>
<head>
    <title>"教育部-IBM精品课程建设项目"软件项目管理课程</title>
</head>

<script type="text/javascript" language="javascript">
    function iFrameHeight() {
        var ifm = document.getElementById("iframepage");
        var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
        if (ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
            ifm.width = subWeb.body.scrollWidth;
        }
    }

    function publishMessage() {
        if (checkMessage()) {
            $('#message_form').submit();
        } else {
            alert('留言信息不能为空');
        }
    }

    function checkMessage() {
        var name = $('#message_name').val();
        var title = $('#message_title').val();
        var detail = $('#message_detail').val();

        return name !== '' && title !== '' && detail !== '';
    }

</script>

<body>
<iframe id="iframepage" width="100%" scrolling="no" marginheight="0" marginwidth="0" onLoad="iFrameHeight()"
        frameborder="0" src="${ctx}/listMessage.do" height="" scrolling="no">
</iframe>

<div class="article">
    <h1>
        我要留言
    </h1>
    <form id="message_form" action="${ctx}/publishMessage.do" method="post">
        <table>
            <tr>
                <td>
                    姓名
                </td>
                <td>
                    <input id="message_name" class="easyui-textbox" type="text" name="name" required="true"
                           style="height: 30px; width: 200px; margin-left: 20px;"/>
                </td>
                <td>
                    标题
                </td>
                <td>
                    <input id="message_title" class="easyui-textbox" type="text" name="title" required="true"
                           style="height: 30px; width: 200px; margin-left: 20px"/>
                </td>
            </tr>
        </table>

        <textarea id="message_detail" class="textarea easyui-validatebox" required="true" name="detail"
                  style="width: 100%; height: 100px; margin: 10px; margin-top: 20px;font-size: 15px;"></textarea>
        <div align="center">
            <input type="button" onclick="publishMessage()" class="btn btn-default" value="提交留言"/>
        </div>
    </form>
</div>
</body>
</html>