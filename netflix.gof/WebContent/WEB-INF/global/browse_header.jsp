<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="header">
	<h3><a href="browse_main.jsp" style="color:red;">GoF </a>&nbsp; &nbsp;
	<select name="menu" onchange="location = this.value;">
	 <option value="">메뉴</option>
     <option value="browse_main.jsp">홈</option>
     <option value="my_video.jsp">내 동영상 목록</option>
     <option value="new_video.jsp">신규 동영상</option>
     <option value="pop_video.jsp">인기 동영상</option>
	</select>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
		<input type="text" name="keyword" placeholder="제목,사람,장르"/>
		<input type="submit" onclick=" location='find_video.jsp'" value="찾기" />
	<select name="profile" onchange="location = this.value;">
		<option value="">홍길동</option>
     	<option value="account.jsp">계 정</option>
     	<option value="customer.jsp">고객센터</option>
     	<option value="logout.jsp">GoF에서 로그아웃</option>
    </select>	
	</h3> 
		
</div>