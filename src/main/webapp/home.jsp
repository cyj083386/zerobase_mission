<%@page import="db.WIFITable"%>
<%@page import="java.util.List"%>
<%@page import="db.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}
#customers td {
	padding-top: 20px;
	padding-bottom: 20px;
	text-align: center;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
input[type=text] {
  padding: 3px 20px;
  margin: 8px 0;
}

</style>
<script>

function getLocation() {
	  if (navigator.geolocation) { // GPS를 지원하면
		    navigator.geolocation.getCurrentPosition(function(position) {
		    
			var elemnetLAT = document.getElementById("LAT");
			var elemnetLNT = document.getElementById("LNT");
			elemnetLAT.value = position.coords.latitude;
			elemnetLNT.value = position.coords.longitude;
			
			}, function(error) {
		      console.error(error);
		    }, {
		      enableHighAccuracy: false,
		      maximumAge: 0,
		      timeout: Infinity
		    });
		  } else {
		    alert('GPS를 지원하지 않습니다');
		  }  
		}

</script>
</head>
<body>
	<% 
	String lat = request.getParameter("LAT");
	String lnt = request.getParameter("LNT");
	

	
	Service service = new Service();

		
	%>
	<%String test_value = "자바값 자바스크립트로";%>
	<h1>와이파이 정보 구하기</h1>
	<p>
	<a href="home.jsp">홈</a>
	|
	<a href="history.jsp">위치 히스토리 목록</a>
	|
	<a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
	</p>
	<form method='get'>
		<label for="LAT">LAT:</label>
	  	<input type="text" id="LAT" name="LAT">
	  	<label for="LNT">, LNT:</label>
	  	<input type="text" id="LNT" name="LNT">
	  	<input type="button" value="내 위치 가져오기" onclick="getLocation()">
		<input type="submit" formaction = "home2.jsp" value="근처 WIFI 정보 보기">
	</form>

	<table id="customers">
		 <thead>
		  <tr>
		    <th>거리(Km)</th>
		    <th>관리번호</th>
		    <th>자치구</th>
		    <th>와이파이명</th>
		    <th>도로명주소</th>
		    <th>상세주소</th>
		    <th>설치위치(층)</th>
		    <th>설치유형</th>
		    <th>설치기관</th>
		    <th>서비스구분</th>
		    <th>망종류</th>
		    <th>설치년도</th>
		    <th>실내외구분</th>
		    <th>WIFI접속환경</th>
		    <th>X좌표</th>
		    <th>Y좌표</th>
		    <th>작업일자</th>
		  </tr>
		 </thead>

	</table>
	<table id="customers">
		<tbody>
			<tr>
				<td>
					위치 정보를 입력한 후에 조회해 주세요.
				</td>
			</tr>
		</tbody>

	</table>
 		

</body>
 	
</html>
