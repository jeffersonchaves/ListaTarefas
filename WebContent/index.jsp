<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
<%@ page import="br.edu.ifpr.entidades.Tarefa"%>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />

</head>
<body>

	<%  
		List<Tarefa> listaTarefasJSP = new ArrayList<Tarefa>();
	
		if(request.getAttribute("listaTarefas") != null){
			listaTarefasJSP = (List<Tarefa>) request.getAttribute("listaTarefas");
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		
	%>


	<div class="container">
	
		<h2>Lista de Tarefas</h2>
		
		
		<form action="/app/tarefas/cadastrar" method="post" class="form-inline mt-3 mb-3">
		
			<input class="form-control mb-2 mr-sm-2" type="text" name="inputNomeTarefa" />
		
			<button type="submit" class="btn btn-primary mb-2">cadastrar</button>
		
		</form>
		
	
		<table class="table">
			<thead>
				<tr>
				<th>#id</th>
				<th>nome</th>
				<th>data</th>
				<th>status</th>
				</tr>
			</thead>
			
			<% for(Tarefa tarefa: listaTarefasJSP) { %>
			<tr>
				<td><% out.print(tarefa.getId()); %></td>
				<td><%= tarefa.getNome() %></td>
				<td><%= dateFormat.format(tarefa.getDataCriacao()) %> </td>
				<td><%= tarefa.getStatus().getStatus() %></td>
			</tr>
			<%} %>
		
			
		</table>
	
	
	</div>


</body>
</html>