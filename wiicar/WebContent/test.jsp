<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<script>
	function ActivityJoinAjax(){
		var group_num = <%=activity_num%> 
		var userID="<%=userID%>"   
		propage ='/ecopang/ecoProject/group/activityJoinPro.jsp';
		$.post(
			propage,  
			{ 
				group_num : group_num,
				userID : userID
			},
			function(data){
				$('.joinBtn').empty().append(data);
			},
			'html'
		);
	}
</script>
	
	
<body>
	<h1> test </h1>
</body>
</html>
