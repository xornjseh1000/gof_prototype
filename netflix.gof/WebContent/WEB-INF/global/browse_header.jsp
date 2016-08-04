<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="header">
	<form action="${context}/video.do?page=find_video&action=search" method="post">
	<a href="${context}/member.do?action=browse_main" style="color:red;
	  float: left; font-size: 25px; font-weight: bold;">Netfilx </a></h3>&nbsp; &nbsp;
	<select name="menu" onchange="location = this.value;" style="float: left;
	margin-top: 10px; margin-left: 10px">
	 <option value="">메뉴</option>
     <option value="${context}/video.do?page=my_video&action=myList">내 동영상 목록</option>
     <option value="${context}/video.do?page=new_video&action=newList">신규 동영상</option>
     <option value="${context}/video.do?page=pop_video&action=hotList">인기 동영상</option>
     <option value="${context}/video.do?page=category&category=1&action=category">영화</option>
<!--      ?category=MOVIE
     switch("")
      MOVIE : 
      	Category.MOVIE.ordinal() -->
	</select>
	<select name="profile" onchange="location = this.value;"style="float: right; margin-top: 10px;
	margin-right: 10px">
		<option value="">${user.name}</option>
     	<option value="${context}/member.do?page=account&action=account">계 정</option>
     	<option value="${context}/customer.do?page=customer">고객센터</option>
     	<option value="${context}/member.do?page=logout&action=logout">로그아웃</option>
    </select>	
		<input type="submit"  value="검색" style="float: right; margin-top: 10px; 
		margin-right: 8px; margin-left:5px " />
		<input type="text" name="keyword" placeholder="제목,사람,장르" style="float: right; 
		margin-top: 10px;"/>
	</form>
	
		
</div>