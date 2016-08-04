<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/browse.css" />
<link rel="stylesheet" href="${css}/browse_table.css" />
<jsp:include page="../global/browse_top.jsp" />
<jsp:include page="../global/browse_header.jsp" /> 

<div class="box">
		<table id="video_detail">
		<tr>
			<td rowspan="8" style="width:50%;height:50%;">
				<a href="${context}/video.do?action=play&page=video_play&serialNo=${video.serialNo}"><img src="${img}/${video.poster}" alt="${video.title }" width="600" height="280">
				</a>
			</td>
			<td ><h3>${video.title }</h3></td>
		</tr>
		<tr>
			<td style="color:grey">☆☆☆☆  ${video.createYear } ${video.runningTime }</td>
		</tr>
		<tr>
			<td style="color:grey"> ${story }
			</td>
		</tr>
		<tr>
			<td style="color:grey"> 감독: <a href="#">${directer.korName }</a>
			</td>
		</tr>
		<tr>
		    <td style="color:grey">주연: <c:forEach items="${actlist }" var="act"><a href="#">${act.korName }</a> </c:forEach>   
			</td>
		</tr>
		<tr>
		    <td style="color:grey">장르: ${genre } </td>
		</tr>
		
		<c:choose>
			<c:when test="${flag==0}">
				<tr>
			  	  <td > <a href="${context}/video.do?action=detail&page=video_detail&serialNo=${video.serialNo}&bm=add">즐겨찾기 추가</a></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
		  	  		<td > <a href="${context}/video.do?action=detail&page=video_detail&serialNo=${video.serialNo}&bm=rmv">즐겨찾기 제거</a></td>
				</tr>
			</c:otherwise>
		</c:choose>

		</table>
	</div>	
<jsp:include page="../global/browse_footer.jsp" />
<jsp:include page="../global/browse_end.jsp" /> 