<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
</head>
<body>
<center>
	<b>Fullname:</b> ${fullname}
	<br>
	<b>Phone:</b> ${phone}
	<br>
	<b>Images:</b> ${images}
	<form action="/Week2/MultipartServlet" enctype="multipart/form-data" method="post">
	<input type="submit" value="Upload Image" />
	<div>
	</div>
		<a href="/Week2/home">HOME</a>
		<div>
		</div>
		<a href="/Week2/update">CẬP NHẬT THÔNG TIN</a>
		
	</form>
	</center>
</body>
</html>