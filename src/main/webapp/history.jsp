<%@page import="db.WIFIHistory"%>
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
input[type=button]{
  padding: 3px 20px;
  margin: 4px 2px;
  cursor: pointer;
}
#delete{
        margin:auto;
        display:block;
}
</style>
</head>
<body>
	<% 
	
	Service service = new Service();
	List<WIFIHistory> historyList = service.historyList();

	
	%>
	<h1>위치 히스토리 목록</h1>
	<p>
	<a href="home.jsp">홈</a>
	|
	<a href="history.jsp">위치 히스토리 목록</a>
	|
	<a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
	</p>
	
	<table id="customers">
		 <thead>
		  <tr>
		    <th>ID</th>
		    <th>X좌표</th>
		    <th>Y좌표</th>
		    <th>조회일자</th>
		    <th>비고</th>
		  </tr>
		  </thead>
		  <tbody>
			<tr>
	   			<%
	   			for(WIFIHistory wifihistory : historyList){
	   			%>
	   				<tr>	
		   				<td> <%=wifihistory.getId()%> </td>
		   				<td> <%=wifihistory.getLat_log()%> </td> 
		   				<td> <%=wifihistory.getLnt_log()%> </td> 
		   				<td> <%=wifihistory.getSearch_dttm()%> </td> 
		   				<td> 
		   					<form method='get'> 
		   						<input type="hidden" name="id" value="<%=wifihistory.getId()%>">
		   						<input type="submit" id= delete formaction = "history2.jsp" value="삭제" >
		   				 	</form>
		   				</td>
	   				</tr>
	   				<%
	   			}
	   			%>
	  		</tr>
		  
		  </tbody>
		
	</table>

</body>
</html>
