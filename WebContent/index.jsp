<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%  
	
		List<String> listaTarefasJSP = new ArrayList<String>();
	
		if(request.getAttribute("listaTarefas") != null){
			listaTarefasJSP = (List<String>) request.getAttribute("listaTarefas");
		}
	%>


	<div class="container">
	
		<table>
			<thead>
				<td>id</td>
				<td>nome</td>
				<td>data</td>
			</thead>
			
			<% for(String tarefa: listaTarefasJSP) { %>
			<tr>
				<td>0</td>
				<td><%= tarefa %></td>
				<td>11/11/2020</td>
			</tr>
			<%} %>
		
			
		</table>
	
	
	</div>


</body>
</html>