<%--
  Created by IntelliJ IDEA.
  User: Xoste
  Date: 2020/12/5
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function() {
		    let username = false;
		    let password = false;
		    let confirmPassword = false;
		    // 用户名验证
		    $(":text:eq(0)").blur(function() {
		        if ($(this).val() !== "") {
                    $(this).next().css("color", "#40D534").html("✔");
                    username = true;
		        } else {
		            $(this).next().css("color", "red").html("✘");
		            username = false;
		        }
		    });
		    // 密码验证
            $(":password:eq(0)").blur(function() {
                if ($(this).val().match(/^\w{6,12}$/)) {
                    $(this).next().css("color", "#40D534").html("✔");
                    password = true;
                } else {
                    $(this).next().css("color", "red").html("✘");
                    password = false;
                }
            });
            // 确认密码验证
            $(":password:eq(1)").blur(function() {
                if ($(this).val() !== "" && $(this).val() === $(":password:eq(0)").val()) {
                    $(this).next().css("color", "#40D534").html("✔");
                    confirmPassword = true;
                } else {
                    $(this).next().css("color", "red").html("✘");
                    confirmPassword = false;
                }
            });
            // 头像
			$(":submit").click(function() {
			    if (username === false || password === false || confirmPassword === false || $(":file").val() === "") {
			        alert("请将信息填写完整");
                    return false;
			    }
			});
		});
	</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" enctype="multipart/form-data" method="post">
	<label>
		用户名：<input type="text" name="username" placeholder="用户名"><span></span><br/>
		密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" placeholder="密码"><span></span><br/>
		确认密码：<input type="password" name="confirmPassword" placeholder="确认密码"><span></span><br/>
		头像：<input type="file" name="file"><br/>
		<input type="submit" value="注册">
	</label>
</form>
</body>
</html>
