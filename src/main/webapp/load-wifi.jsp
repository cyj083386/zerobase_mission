<%@page import="db.APIExp"%>
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


#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

h1 {
  text-align: center;
}
p {
  text-align: center;
}
</style>
</head>
<body>
	<% 
	
	APIExp apiexp = new APIExp();
	Service service = new Service();
	service.dbTruncate();
	service.dbInsert(apiexp);
	apiexp.APIToDB();
	String countResult = service.dbCount();
	
	%>
	<h1><%=countResult%>개 WIFI 정보를 정상적으로 저장하였습니다.</h1> 
	
	<p><a href="home.jsp">홈 으로 가기</a></p>
</body>
</html>