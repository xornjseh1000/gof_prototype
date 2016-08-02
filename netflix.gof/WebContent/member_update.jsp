<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="login_table.css" />
<jsp:include page="login_top.jsp" />
<jsp:include page="login_header.jsp" /> 
<div class="box">
		<h2>회원정보수정 </h2>
		<table id="member_update">
		<tr>
			<td rowspan="4" style="width:40%">Email</td>
			<td style="width:40%">hong@gmail.com</td>
		</tr>
		<tr>
			<td >비밀번호</td>
			<td>*****</td>
		</tr>
		<tr>
			<td >휴대폰 번호</td>
			<td>010-1234-5678</td>
		</tr>
		<tr>
			<td>결제정보</td>
			<td>**** **** **** 1234</td>
		</tr>
		<tr>
			<td><input type="submit" onclick=" location='payment_list.jsp'" value="결제상세정보" /></td>
		</tr>
		</table></br>
		<table id="service_detail">
		<tr>
			<td >서비스상세정보</td>
			<td >1동시접속 <input type="submit" value="멤버십 변경" /> </td>
			
		</tr>
		<tr>
		</table>
	</div>
<jsp:include page="login_footer.jsp" />
<jsp:include page="login_end.jsp" /> 