<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="browse.css" />
<link rel="stylesheet" href="browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
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
		<tr>
		    <td></td>
			<td><input type="submit" onclick=" location='payment_list.jsp'" value="결제상세정보" /></td>
		</tr>
		</table></br>
		<table id="member_detail">
		<tr>
			<td >서비스상세정보</td>
			<td >1동시접속 <input type="submit" value="멤버십 변경" /> </td>
			
		</tr>
		<tr>
		</table>
	</div>
<jsp:include page="../global/account_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 