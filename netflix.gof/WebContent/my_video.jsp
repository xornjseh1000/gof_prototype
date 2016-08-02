<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="login_table.css" />
<jsp:include page="login_top.jsp" />
<jsp:include page="login_header.jsp" /> 
<div class="box">
		<h3>내 동영상목록 </h3>
		<table id="my_video">
		<tr>
			<td ><a href="video_play.jsp"><img src="matrix.jpg" alt="매트릭스" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="matrix2.jpg" alt="매트릭스2" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="matrix3.jpg" alt="매트릭스3" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="jukyuk.jpg" alt="추격자" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_play.jsp"><img src="davilsee.jpg" alt="악마를보았다" style="width:240px;height:150px;"></a></td>
		</tr>
		</table>
	</div>	
<jsp:include page="browse_footer.jsp" />
<jsp:include page="login_end.jsp" /> 