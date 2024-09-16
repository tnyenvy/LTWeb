<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>

<html>
<head>
<meta charset="UTF-8">
<title>Create New Password</title>
</head>
<body>
	<form action="/MVC/newpass" method="post">
		<c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<div class="container">
			<br><label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email" name="email"><br>
			<br><label for="text"><b>Mật khẩu mới</b></label> <input type="text"
				placeholder="Enter New Password" name="newpass"><br>
			<br><label for="text"><b>Nhập lại mật khẩu</b></label> <input type="text"
				placeholder="Enter Password Again" name="passagain"><br>
			<br><button type="submit">Xác nhận</button><br>
		</div>
	</form>
</body>
</html>