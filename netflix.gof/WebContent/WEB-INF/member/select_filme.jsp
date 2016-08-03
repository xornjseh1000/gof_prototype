<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="UTF-8" />
	<title>선호영화선택</title>
</head>
<body>
	<span style="color: red; float:left; font-size: 40px" >NETFLIX</span>
	<span  style="color:black;float:right;  font-size:20px;text-align: =right" >로그아웃</span>
	<br />
	<br />
	<br />
	
	<span>선호하시는 영화나TV프로그램을 3개선택하세요</span>
		<br /><br />
		<form action="${context}/member.do" method="get">
				<input type="hidden" name = "action" value="regist_complete"/>
		  		<input type="submit" value="등록"/><br/>
	<table>
		<tr>
			<td ><img src="${img}/seven_room.jpg" alt="seven_room" width="200" height="100"></td>
			<td><img src="${img}/jasonbon.jpg" alt="jasonbon" width="200" height="100"></td>
			<td><img src="${img}/doduk.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/pusan.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/spider.jpg" alt="" width="200" height="100"></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="fav_chk" value="1011"/></td>
			<td><input type="checkbox" name="fav_chk" value="1012"/></td>
			<td><input type="checkbox" name="fav_chk" value="1010"/></td>
			<td><input type="checkbox" name="fav_chk" value="1021"/></td>
			<td><input type="checkbox" name="fav_chk" value="1022"/></td>
		</tr>
		<tr>
			<td><img src="${img}/dory.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/demolition.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/mypet.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/under_water.jpg" alt="" width="200" height="100"></td>
			<td><img src="${img}/big.jpg" alt="" width="200" height="100"></td>
		</tr>
		<tr>
			<td><input type="checkbox" name="fav_chk" value="1011"/></td>
			<td><input type="checkbox" name="fav_chk" value="1012"/></td>
			<td><input type="checkbox" name="fav_chk" value="1010"/></td>
			<td><input type="checkbox" name="fav_chk" value="1021"/></td>
			<td><input type="checkbox" name="fav_chk" value="1022"/></td>
		</tr>
	</table>
	
	</form>

</body>
</html>
	