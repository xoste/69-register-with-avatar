<%--
  Created by IntelliJ IDEA.
  User: Xoste
  Date: 2020/12/5
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
	<title>Title</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function() {
		    $("a").click(function() {
		        // parent() 父标签
			    // prev() 前一个兄弟标签
			    // jquery规范，对象名以$开头
		        let $td = $(this).parent().prev();
		        // html() 返回字符串
		        $td.html(parseInt($td.html()) + 1);
		    });
		});
	</script>
</head>
<body>
<table border="1">
	<thead>
	<tr>
		<td>资料名称</td>
		<td>下载次数</td>
		<td>操作</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${listFiles}" var="files">
		<tr>
			<td>${files.name }</td>
			<td>${files.count }</td>
			<td><a href="${pageContext.request.contextPath}/download?id=${files.id}&name=${files.name}">下载</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>
