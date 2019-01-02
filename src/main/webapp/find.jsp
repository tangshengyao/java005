<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<input type="text" name="mobilenumber" id="mobilenumber">
<input type="button" value="查询" onclick="finds()">
<script>
	function finds(){
	$.post("${pageContext.request.contextPath}/mobile/finds",{"mobilenumber":$("#mobilenumber").val()},function(data){
	alert(data);
	},"text")
	}
</script>
</body>
</html>