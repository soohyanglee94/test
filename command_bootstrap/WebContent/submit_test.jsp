<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form id="form" action="http://www.naver.com">
		<input type="text"/>
		<input type="submit" id="submit_btn" onclick="return false;" value=""/>
	</form>
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>
$('input#submit_btn').click(function(event){
	alert("submit btn");
	
	//return false;
});
</script>
</body>
</html>