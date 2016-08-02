<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<!doctype html>
	<html lang="en">
	<style type="text/css">
		<head>
		<meta charset="UTF-8" />
		<title>로그인</title>
		<link rel="stylesheet" href="mystles.css">

	
body {margin-left: 300px; margin-top: 300px; margin-right: 300px; margin-bottom: 300px;}
#center {font-color:red; position:absolute; top:50%; left:50%; width:400px; height:400px; overflow:hidden; 
background-color:#FC0; margin-top:-150px; margin-left:-100px;}
input {text-align:center;}
h1 {text-align:center;table-layout:center }
</style>

<span style="color: red; font-size: 30px" >NETFLIX</span>

<form action="${context}/member.do" method="get">
<br />
<br />

  <div class="container">
    <label><b>로그인</b></label>
    <br />
    <br />
    
    <input type="text" placeholder="Enter Useremail" name="uemail" required>
    <br />
    <br />

    <label><b></b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
    <br />
    
    <span>이메일 또는 비밀번호를 잊으셨나요?</span>
        <br />
        <br />
        <br />
    <input type="checkbox" checked="checked"> 로그인정보저장
    <div class="container" style="background-color:#f1f1f1">
  </div>
        <br />
  		<input type="hidden" name = "action" value="login"/>
		 <input type="submit" value="로그인"/><br/>
    <br />
    <br />
  </div>

 
</form>

	</head>
	<body>
		
	</body>
	</html>
	