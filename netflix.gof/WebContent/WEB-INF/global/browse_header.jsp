<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="header">
	<h3><a href="${context}/member.do?page=browse_main" style="color:red;">Netfilx </a>&nbsp; &nbsp;
	<select name="menu" onchange="location = this.value;">
	 <option value="">메뉴</option>
     <option value="${context}/member.do?page=browse_main">홈</option>
     <option value="${context}/video.do?page=my_video">내 동영상 목록</option>
     <option value="${context}/video.do?page=new_video">신규 동영상</option>
     <option value="${context}/video.do?page=pop_video">인기 동영상</option>
	</select>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		<input type="text" name="keyword" placeholder="제목,사람,장르"/>
		
		<input type="submit" onclick=" location='${context}/video.do?page=find_video'" value="찾기" />
	<select name="profile" onchange="location = this.value;">
		<option value="">${user.name}</option>
     	<option value="${context}/member.do?page=account">계 정</option>
     	<option value="${context}/customer.do?page=customer">고객센터</option>
     	<option value="${context}/member.do?page=logout">GoF에서 로그아웃</option>
    </select>	
	</h3> 
		
</div>