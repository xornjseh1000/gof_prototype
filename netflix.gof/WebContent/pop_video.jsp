<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="login_table.css" />
<jsp:include page="login_top.jsp" />
<jsp:include page="login_header.jsp" /> 
<div class="box">
		<h3>GoF 인기동영상 </h3>
		<table id="popvideo">
		<tr>
			<td ><a href="video_play.jsp"><img src="brakingbad.jpg" alt="브레킹베드" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="dexter.jpg" alt="덱스터" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="hungu.jpg" alt="헝거게임" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="houseof.jpg" alt="하우스오브카드" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="kimyhan.jpg" alt="기묘한이야기" style="width:240px;height:150px;"></a></td>
		</tr>
		</table>
	</div>	
<jsp:include page="browse_footer.jsp" />
<jsp:include page="login_end.jsp" /> 