<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="browse.css" />
<link rel="stylesheet" href="browse_table.css" />
<jsp:include page="browse_top.jsp" />
<jsp:include page="browse_header.jsp" /> 
<div class="box">
		<h2>회원정보수정 </h2>
		<table id="member_detail">
		<tr>
			<td style="width:40%">Email</td>
			<td style="width:40%"><input type="text" name="email" 
					value="${user.email}"/></td>
		</tr>
		<tr>
			<td >비밀번호</td>
			<td><input type="text" name="pw" 
					value="${user.pw}"/></td>
		</tr>
		<tr>
			<td >휴대폰 번호</td>
			<td><input type="text" name="phone" 
					value="${user.phone}"/></td>
		</tr>
		<tr>
			<td>결제정보</td>
			<td><input type="text" name="cardno" 
					value="${user.cardno}"/></td>
		</tr>
		</table></br>
		<input type="submit" onclick=" location='account.jsp'" value="수정완료" />
	</div>
<jsp:include page="account_footer.jsp" />
<jsp:include page="browse_end.jsp" /> 