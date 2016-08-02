<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="browse.css" />
<link rel="stylesheet" href="browse_table.css" />
<jsp:include page="browse_top.jsp" />
<jsp:include page="browse_header.jsp" /> 
<div class="box">
		<h3>GoF 인기동영상 </h3>
		<table id="pop_video">
		<tr>
			<td ><a href="video_detail.jsp"><img src="brakingbad.jpg" alt="브레킹베드" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="dexter.jpg" alt="덱스터" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="hungu.jpg" alt="헝거게임" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="houseof.jpg" alt="하우스오브카드" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="kimyhan.jpg" alt="기묘한이야기" style="width:240px;height:150px;"></a></td>
		</tr>
		</table>
	</div>	
<jsp:include page="browse_footer.jsp" />
<jsp:include page="browse_end.jsp" /> 