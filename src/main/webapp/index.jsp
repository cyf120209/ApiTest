<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String socketPath=request.getServerName()+":"+request.getServerPort()+path;
%>
<head>
    <meta charset="UTF-8">
    <title>云后台API接口平台</title>
    <link href='//fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
    <link href='css/reset.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='css/reset.css' media='print' rel='stylesheet' type='text/css'/>
    <link href='css/screen.css' media='print' rel='stylesheet' type='text/css'/>
    <script type="text/javascript" src="lib/shred.bundle.js"></script>
    <script src='lib/jquery-1.8.0.min.js' type='text/javascript'></script>
    <script src='lib/jquery.slideto.min.js' type='text/javascript'></script>
    <script src='lib/jquery.wiggle.min.js' type='text/javascript'></script>
    <script src='lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
    <script src='lib/jquery.form.js' type='text/javascript'></script>
    <script src='lib/handlebars-1.0.0.js' type='text/javascript'></script>
    <script src='lib/underscore-min.js' type='text/javascript'></script>
    <script src='lib/backbone-min.js' type='text/javascript'></script>
    <script src='lib/swagger.js' type='text/javascript'></script>
    <script src='lib/swagger-client.js' type='text/javascript'></script>
    <script src='swagger-ui.js' type='text/javascript'></script>
    <script src='lib/highlight.7.3.pack.js' type='text/javascript'></script>

    <!-- enabling this will enable oauth2 implicit scope support -->
    <script src='lib/swagger-oauth.js' type='text/javascript'></script>
    <script type="text/javascript">
        $(function () {
            var url = window.location.search.match(/url=([^&]+)/);
            if (url && url.length > 1) {
                url = url[1];
            } else {
                url = "<%=basePath%>"+"v2/api-docs";
                <%--url = "<%=basePath%>"+"<%=request.getContextPath()%>"+"/api-docs";--%>
            }
            window.swaggerUi = new SwaggerUi({
                url: url,
                dom_id: "swagger-ui-container",
                supportedSubmitMethods: ['get', 'post', 'put', 'delete'],
                onComplete: function(swaggerApi, swaggerUi){
                    log("Loaded SwaggerUI");
                    if(typeof initOAuth == "function") {
                        /*
                         initOAuth({
                         clientId: "your-client-id",
                         realm: "your-realms",
                         appName: "your-app-name"
                         });
                         */
                    }
                    $('pre code').each(function(i, e) {
                        hljs.highlightBlock(e)
                    });
                },
                onFailure: function(data) {
                    log("Unable to Load SwaggerUI");
                },
                docExpansion: "none",
                sorter : "alpha",
            });

            function addApiKeyAuthorization() {
                var key = $('#input_apiKey')[0].value;
                log("key: " + key);
                if(key && key.trim() != "") {
                    log("added key " + key);
                    window.authorizations.add("api_key", new ApiKeyAuthorization("api_key", key, "query"));
                }
            }

            $('#input_apiKey').change(function() {
                addApiKeyAuthorization();
            });

            // if you have an apiKey you would like to pre-populate on the page for demonstration purposes...
            /*
             var apiKey = "myApiKeyXXXX123456789";
             $('#input_apiKey').val(apiKey);
             addApiKeyAuthorization();
             */

            window.swaggerUi.load();
        });

        function uploadFile() {
//        $.ajax({
//            url:"http://localhost:8080/v1/upgrade/upload",
//            type:"POST",
//            enctype: 'multipart/form-data',
//            async:true,
//            data:$("#upload").serialize()
//        }).done(function (data) {
//            alert(data);
//        }).fail(function (d) {
//            alert(d);
//        });
            $("#upload").ajaxSubmit({
                success: function (data) {
                    alert(data.corrupt);
                    $("#type").val(data.type);
                    $("#typeNum").val(data.typeNum);
                    $("#majorNum").val(data.majorNum);
                    $("#minorNum").val(data.minorNum);
                    $("#patchNum").val(data.patchNum);
                },
                error: function (error) {
                    alert("error"+error);
                },
                url: 'upgrade/chooseFirmware', /*设置post提交到的页面*/
                type: "post", /*设置表单以post方法提交*/
                async:true,
                dataType: "json" /*设置返回值类型为文本*/
            });
        }

        function upgrade() {
            $("#show-upgrade-tip").text("升级准备中...");
//        $("#mymodal").modal({backdrop:'static',keyboard:'false'});
            $.ajax({
                url:'upgrade/upgrade',
                type:"POST",
                dataType:"json",
                data:{
                    draperID:-1
                },
                success:function () {
                    $("#progress").css("width",0+"%")
//                ref=setInterval("getPercent()",1000);
//                $( "#dialog-confirm" ).dialog({
//                    resizable: false,
//                    height:140,
//                    modal: true,
//                    buttons: {
//                        "确认": function() {
//                            $( this ).dialog( "close" );
//                        },
//                        "Cancel": function() {
//                            $( this ).dialog( "close" );
//                        }
//                    }
//                });
                }
            });
        }
    </script>
</head>

<body class="swagger-section">
<div id='header'>
    <div class="swagger-ui-wrap">
        <a id="logo" href="#">Draper API 接口</a>
        <form id='api_selector'>
            <div class='input'><input placeholder="http://mousycoder.com" id="input_baseUrl" name="baseUrl" type="text"/></div>
            <div class='input'><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"/></div>
            <div class='input'><a id="explore" href="#">Explore</a></div>
        </form>
    </div>
</div>
<%--<a href="admin" target="_blank">Explore</a>--%>
<div id="message-bar" class="swagger-ui-wrap">&nbsp;</div>
<div id="swagger-ui-container" class="swagger-ui-wrap"></div>
<%--<div >--%>
    <%--<form name="upload" id="upload" enctype="multipart/form-data">--%>
        <%--<input type="file" name="file">--%>
        <%--<button type="button"  class="btn btn-default" onclick="uploadFile()">upload</button>--%>
    <%--</form>--%>
    <%--<button type="button" class="btn btn-default" onclick="upgrade()">upgrade</button><br/>--%>

<%--</div>--%>
</body>
</html>
