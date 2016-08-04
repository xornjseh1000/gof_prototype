<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
		<meta charset="UTF-8" />
		<title>고객센터</title>
		<style>
		h1 {text-align: left; }

		h2 {text-align: right;}
		
		</style>
</head>
<body>
	<span style="color: red; float:left; font-size: 40px" >NETFLIX</span>
<%-- 	<c:if test="${state==2}">
	<span  style="color:black;float:right;  font-size:20px;float: right;" >
	<a href="${context}/member.do?page=main_before">메인</a></span>
	<span  style="color:black;float:right;  font-size:20px;float: right;" >
	<a href="${context}/member.do?page=login">로그인</a></span>
	</c:if>
 --%>	
 	<span  style="color:black;float:right;  font-size:20px;float: right;margin-right: 10px" >
	<a href="${context}/member.do?action=browse_main">메인</a></span>
	<span  style="color:black;float:right;  font-size:20px;float: right;margin-right: 20px" >
	<a href="${context}/member.do?page=logout">로그아웃</a></span>
	<br>
	<br></br>

	<span style="color:black;font-size:30px;text-align: =right">고객센터</span>
	<br />
	<br />
	<br />
	<br />
	
	<span >문제해결</span>  

	<p><a href="${context}/customer.do?page=customer_detail"> 대한민국 회원은 나이를 <br />어떻게 인증할수있나요?</a></p>
	<p><a href="${context}/customer.do?page=customer_detail"> Netflix 결제관련자주묻는 질문</a></p>
	<p><a href="${context}/customer.do?page=customer_detaill"> Netflix에 "동영싱을 재생할수없음"<br />또는 "이 동영상을 재생하는 동안 <br />문제발생"이라고 표시됩니다.</a></p>
	<br />
	
	<span>자주묻는질문</span>

    <p><a href="${context}/customer.do?page=customer_detail">Netflix는 어떻게 이용하나요?</a></p>
	<p><a href="${context}/customer.do?page=customer_detail">Netflix 무료이용 및 결제</a></p>
	<p><a href="${context}/customer.do?page=customer_detail">Netflix시청</a></p>
	<p><a href="${context}/customer.do?page=customer_detail">시스템사양</a></p>



	<br />
	<br />
	<br />
	
	
</body>
</html>
	