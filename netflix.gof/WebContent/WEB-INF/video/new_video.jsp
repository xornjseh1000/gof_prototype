<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
<div class="box">
		<h3>신규 동영상 </h3>
		<table id="new_video">
		<tr>
		<c:forEach var="video" items="${newlist}">
			<td ><a href="${context}/video.do?action=detail&page=video_detail&serialNo=${video.serialNo}"><img src="${img}/${video.poster}" alt="${video.title}" style="width:240px;height:150px;"></a></td>
		</c:forEach>
		</tr>
		</table>
	</div>	
<jsp:include page="../global/browse_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 