<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="login_table.css" />
<jsp:include page="login_top.jsp" />
<jsp:include page="login_header.jsp" /> 
<div class="box">
	<h2>결제상세정보</h2>
	<table id="member_list">
  <tr>
    <th>카드회사</th>
    <th>결제일자</th>
    <th>결제금액</th>
  </tr>
  <c:forEach var="card" items="${list}">
  <tr>
    <td>국민카드</td>
    <td>2016-06-01</td>
    <td>12,500</td>
  </tr>
  <tr>
    <td>국민카드</td>
    <td>2016-07-30</td>
    <td>9,500</td>
  </tr>
  </c:forEach>
</table>
<input type="submit" onclick=" location='account.jsp'" value="확인" />
</div>		
<jsp:include page="login_footer.jsp" />
<jsp:include page="login_end.jsp" /> 