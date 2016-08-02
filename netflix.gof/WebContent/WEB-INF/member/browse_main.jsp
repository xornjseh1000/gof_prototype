<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="login.css" />
<link rel="stylesheet" href="login_table.css" />
<jsp:include page="../../login_top.jsp" />
<jsp:include page="../../login_header.jsp" /> 
<div class="box">
		<h3>GoF 인기동영상 </h3>
		<table id="popvideo">
		<tr>
			<td ><img src="${img}/brakingbad.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/dexter.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/hungu.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/houseof.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/kimyhan.jpg" alt="" style="width:240px;height:150px;"></td>
		</tr>
		</table>
		<h3>신규 동영상 </h3>
		<table id="newvideo">
		<tr>
			<td ><img src="${img}/agassy.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/goksung.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/independenceday.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/nosecuret.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/tric.jpg" alt="" style="width:240px;height:150px;"></td>
		</tr>
		</table>
		<h3>내 동영상목록 </h3>
		<table id="myvideo">
		<tr>
			<td ><img src="${img}/matrix.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/matrix2.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/matrix3.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/jukyuk.jpg" alt="" style="width:240px;height:150px;"></td>
			<td ><img src="${img}/davilsee.jpg" alt="" style="width:240px;height:150px;"></td>
		</tr>
		</table>
	</div>	
<jsp:include page="../../browse_footer.jsp" />
<jsp:include page="../../login_end.jsp" /> 