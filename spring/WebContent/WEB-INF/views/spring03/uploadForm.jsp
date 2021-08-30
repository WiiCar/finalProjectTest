<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm</title>
</head>
<body>

	<h2>! 업로드 폼 !</h2>
	
	<form action="/spring/upload/uploadPro.git" method="post" enctype="multipart/form-data">
		name : <input type="text" name="name" /><br />
		img : <input type="file" name="img" /><br />
		<input type="submit" value="전송" />
	</form>

</body>
</html>