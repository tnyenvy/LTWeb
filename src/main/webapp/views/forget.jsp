<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
</head>
<body>
<center>
	<form action="/Week2/forget" method="post">
	<h3> Nhập email xác nhận </h3>
		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<div class="container">
			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email">

			<button type="submit">Lấy lại mật khẩu</button>
		</div>
	</form>
	</center>
</body>
</html>