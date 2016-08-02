<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>NETFLIX</title>

<link rel="stylesheet" href="mystles.css">
<style  type="text/css">
body {
	background-color: white ;
}
#center { position:absolute; top:50%; left:50%; width:380px; height:600px; overflow:hidden; 
 margin-top:-300px; margin-left:-150px;}
h { font-size=30px
	color: red;
}

</style>
</head>
<body>
	
	<span  style="color: red; font-size: 30px;text-align: =left">NETFLIX</span>


	<span  style="color: red; font-size: 20px; text-align:=right ">로그인</span>


</head>
<p></p>
<p></p>

	<h2 text-align:=left>계정등록</h2>

	<br />
	<br />
	
	<form action="${context}/member.do" method="get">
		email<br> <input type="text" name="userid">
		<span>#이미 등록된 이메일입니다</span>
		
		<br> </br> password <br> <input type="password"
			name="psw"> <br /> <br />

		
			<input type="checkbox" id="myCheck" onmouseover="myFunction()"
				onclick="alert('click event occured')"> email 수신여부 </br/>
		<input type="hidden" name = "directory" value="global"/>
		<input type="hidden" name = "action" value="payment"/>
		<input type="submit" value="등록"/>	
		</form>
	
</body>
</html>
