<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
<div class="box">
	<c:choose>
		<c:when test="${actorlist==null }">
			<h5> ${keyword} 와 관련된 동영상 : </h5>
		</c:when>
		<c:otherwise>
			<h5>사람 : <c:forEach items="${actorlist }" var="actor">
				<a style="color:grey;" href="${context}/video.do?page=find_video&action=search&keyword=${actor.korName}">${actor.korName }</a> &nbsp;&nbsp;
				</c:forEach>
			</h5>
		</c:otherwise>
	</c:choose>
		<table id="find_video">
			<c:forEach var="video" items="${searchlist}">
				<td ><a href="${context}/video.do?action=detail&page=video_detail&serialNo=${video.serialNo}"><img src="${img}/${video.poster}" alt="${video.title}" style="width:240px;height:150px;"></a></td>
			</c:forEach>
		</table>
	</div>	
<jsp:include page="../global/browse_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 