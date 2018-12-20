<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
	<ul>
		<li>이름 : <input type="text" name="username"></li>
		<li>File : <input type="file" name="file1"></li>
		<li><input type="submit" value="파일 업로드"></li>
	</ul>
</form>
</body>
</html>