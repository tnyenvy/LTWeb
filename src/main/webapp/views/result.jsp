<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Demo</title>
</head>
<body>
<center>
	<div>Apache FileUpload</div>
	<form method="post" action="/Week2/MultipartServlet"
		enctype="multipart/form-data">
		Choose a file: <input type="file" name="uploadFile" /> <input
			type="submit" value="Upload" />
	</form>

	<div>Servlet Multipart</div>
	<form method="post" action="/Week2/MultipartServlet"
		enctype="multipart/form-data">
		Choose a file: <input type="file" name="MultipartServlet" /> <input
			type="submit" value="Upload" />
	</form>

	<div>Cloudary</div>
	<form method="post" action="/Week2/cloudary"
		enctype="multipart/form-data">
		Choose a file: <input type="file" name="cloudary" /> <input
			type="submit" value="Upload" />
	</form>
	</center>
</body>
</html>