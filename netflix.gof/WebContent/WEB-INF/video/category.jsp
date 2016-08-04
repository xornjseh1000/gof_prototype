<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 
<div class="box">
		<span style="font-size: 30px">영화</span>
		<select name="profile" onchange="location = this.value;" style="float: right;">
		 <option value="">메뉴</option>
	<option value="${context}/video.do?page=category&category=${categoryNum}&action=category&order=GPA">평점순</option>
   <option value="${context}/video.do?page=category&category=${categoryNum}&action=category&order=REGDATE">최신순</option>
   <option value="${context}/video.do?page=category&category=${categoryNum}&action=category&order=SPELL">가나다순</option>
    </select>	
		<table id="pop_video">
		<tr>
		<c:forEach var="video" items="${categorylist}">
			<td ><a href="${context}/video.do?action=detail&page=video_detail&serialNo=${video.serialNo}"><img src="${img}/${video.poster}" alt="${video.title}" style="width:240px;height:150px;"></a></td>
		</c:forEach>
		</tr>
		</table>
	</div>	
<jsp:include page="../global/browse_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 