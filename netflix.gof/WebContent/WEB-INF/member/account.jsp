<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
<div class="box">
		<h2>계정 <input type="submit" onclick=" location='${context}/member.do?page=member_update&action=member_update'" value="회원정보변경" /></h2>
		<table id="member_detail">
		<tr>
			<td rowspan="6" style="width:30%">
				멤버십&결제정보</br>
				<input type="submit" value="멤버십해제" />
			</td>
			<td >아이디</td>
			<td style="width:35%">${user.email}</td>
		</tr>
		<tr>
			<td >비밀번호</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td >휴대폰 번호</td>
			<td>${user.phone}</td>
		</tr>
		<tr>
			<td>결제정보</td>
			<td>${user.cardNum}</td>
		</tr>
		<tr>
			<td>결제상세</td>
			<td><input type="submit" onclick=" location='${context}/member.do?action=payDetail&page=payment_list'" value="결제상세정보" /></td>
		</tr>
		<tr>
			<td >서비스상세정보</td>
			<td >${grade}</td>
			
		</tr>
		</table></br>
	</div>
<jsp:include page="../global/account_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 