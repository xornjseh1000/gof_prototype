<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>NETFLIX</title>


<style  type="text/css">
body {
	background-color: white ;
}
#center { position:absolute; top:50%; left:50%; width:380px; height:600px; overflow:hidden; 
 margin-top:-300px; margin-left:-150px;}
h { font-size=30px
	color: red;
}
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
	
	<span  style="color: red; font-size: 30px;text-align: =left">NETFLIX</span>


	<span  style="color: red; font-size: 20px; float: right;">
	<a href="${context}/member.do?page=login&action=move"">로그인</a></span>


</head>
<p></p>
<p></p>
	${regist_fail}
	<h2 text-align:=left>계정등록</h2>

	<br />
	<br />
	
	<form action="${context}/member.do" method="get">
		
		email<br/> <input type="text" name="userid"><br/><br/>
		password <br/><input type="password" name="userpw"><br/><br/> 

			<input type="checkbox" name = "email_chk" value="" > email 수신여부 <br/><br/>
		<input type="hidden" name = "directory" value="global"/>
		<input type="hidden" name = "action" value="regist"/>
		<input type="submit" value="등록"/>	
		</form>
	
</body>
</html>
