<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="browse.css" />
<link rel="stylesheet" href="browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<div id="header">
	<a href="index.jsp" style="color:red; float: left;font-size: 25px">Netflix </a>
		<input type="submit" onclick=" location='${context}/member.do?page=login'" value="로그인"
		style="float: right;" />
</div>	 
	<div style="background-color:#ffffff;
    color:#000000;
    height: 100%;
    width : 100%;
    text-align:center; 
    padding-top:10px;">
		<h2>로그아웃 되었습니다.</h2>	
		<h4>공공 컴퓨터나 다른 사람의 컴퓨터를 사용 중이신</br>
		    경우 GoF에서 로그아웃해 주시기 바랍니다.</br></br>
		</h4></br></br></br>
		<input type="submit" onclick=" location='${context}/member.do?page=main_before'" value="메인" />
	</div>
<jsp:include page="../global/browse_end.jsp" /> 