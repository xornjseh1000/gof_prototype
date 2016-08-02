<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="browse.css" />
<link rel="stylesheet" href="browse_table.css" />
<jsp:include page="browse_top.jsp" />
<jsp:include page="browse_header.jsp" /> 
<div id="box">
		<h2>계정 <input type="submit" onclick=" location='member_update.jsp'" value="회원정보변경" /></h2>
		<table id="member_detail">
		<tr>
			<td rowspan="5" style="width:40%">
				멤버십&결제정보</br>
				<input type="submit" value="멤버십해제" />
			</td>
			<td style="width:40%">Email</td>
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
<jsp:include page="account_footer.jsp" />
<jsp:include page="browse_end.jsp" /> 