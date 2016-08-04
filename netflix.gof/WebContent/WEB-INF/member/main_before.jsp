<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>메인페이지</title>
<link rel="stylesheet" href="mystles.css">
<style type="text/css">
body {
	background-color: black;
}

h1 {
	color: red;
}
 a:link { color: white; text-decoration: none;}
 a:visited { color: white; text-decoration: none;}
 a:hover { color: white; text-decoration: none;}
</style>
</head>
<body>
	
	<span style="color: red; font-size: 45px;font-weight: bold;float: left;margin-left: 30px;">NETFLIX</span>
	<span style="color: white; font-size: 20px;float: right;margin-right: 35px;">
		<a href="${context}/member.do?page=login&action=move">로그인</a></span>
	<span style="color: white; font-size: 20px;float: right;margin-right: 30px;">
		<a href="${context}/member.do?page=regist&action=move">회원가입</a></span>


	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<article
		style="color: white; font-size: 20px;margin-left: 30px;">
		<h2>See what's next.</h2>다양한 기기에서 NETFLIX를 시청하세요.<br/> 무광고, 무약정으로
		원하실 때 <br/>언제든지 해지하실 수 있습니다.
	</article><br/>

	<button type="button" color="red" onclick="alert('회원가입 후 이용하세요.')" style="margin-left: 30px;">한달무표이용신청</button>
	<p align="left"></p>

<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
<div id="footer" class="bottom">
	<p>
		<a  href="${context}/customer.do?page=customer">질문이 있으신가요? 고객 센터에 문의하세요
		</a>
	</p>
	<ul>
		<a href="${context}/customer.do?page=customer">자주 묻는 질문</a> 
		<a href="${context}/customer.do?page=customer">고객 센터</a>
	</ul>
</div>

</body>
</html>
