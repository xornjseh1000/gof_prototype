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
		<h3>신규 동영상 </h3>
		<table id="new_video">
		<tr>
			<td ><a href="video_detail.jsp"><img src="agassy.jpg" alt="아가씨" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="goksung.jpg" alt="곡성" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="independenceday.jpg" alt="인디펜더스데이" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="nosecuret.jpg" alt="비밀은없다" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="tric.jpg" alt="트릭" style="width:240px;height:150px;"></a></td>
		</tr>
		</table>
		<h3>내 동영상목록 </h3>
		<table id="my_video">
		<tr>
			<td ><a href="video_detail.jsp"><img src="matrix.jpg" alt="매트릭스" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="matrix2.jpg" alt="매트릭스2" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="matrix3.jpg" alt="매트릭스3" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="jukyuk.jpg" alt="추격자" style="width:240px;height:150px;"></a></td>
			<td ><a href="video_detail.jsp"><img src="davilsee.jpg" alt="악마를보았다" style="width:240px;height:150px;"></a></td>
		</tr>
		</table>
	</div>	
<jsp:include page="browse_footer.jsp" />
<jsp:include page="browse_end.jsp" /> 