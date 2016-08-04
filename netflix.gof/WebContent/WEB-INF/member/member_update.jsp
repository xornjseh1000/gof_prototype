<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
<form action="${context}/member.do?page=account&action=acc_modify" method="post">
<div class="box">
		<h2>회원정보수정 </h2>
		<table id="member_detail">
		<tr>
			<td style="width:40%">Email</td>
			<td style="width:40%">${user.email}</td>
		</tr>
		<tr>
			<td >비밀번호</td>
			<td><input type="text" name="pw" 
					value="${user.password}"/></td>
		</tr>
		<tr>
			<td >휴대폰 번호</td>
			<td><input type="text" name="phone" 
					value="${user.phone}"/></td>
		</tr>
		<tr>
			<td>결제정보</td>
			<td><input type="text" name="cardno" 
					value="${user.cardNum}"/></td>
		</tr>
		<tr>
			<td >서비스상세정보</td>
			<td >
			현재 등급 : ${grade} <br/>
			<input type="radio" name="grade" value="none" checked="checked" style="display: none;"> 
			<input type="radio" name="grade" value="Basic"> 
			<span>일반회원</span>
			<input type="radio" name="grade"  value="Special" > 
			<span>특별회원</span></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;"><input type="submit" value="수정"/></td>
		</tr>
		</table>
<%-- 		<tr>
		    <td>결제상세정보</td>
			<td><input type="submit" onclick=" location='${context}/member.do?page=payment'" value="결제상세정보" /></td>
		</tr>
 --%>
	</div>
	</form>
<jsp:include page="../global/account_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 