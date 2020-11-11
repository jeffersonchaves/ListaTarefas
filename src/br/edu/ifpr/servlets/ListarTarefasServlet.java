package br.edu.ifpr.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tarefas/listar")
public class ListarTarefasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> listaTarefas = new ArrayList<String>();
		
		listaTarefas.add("Estudar JSP");
		listaTarefas.add("Ir ao parque das aves");
		listaTarefas.add("Pagar conta de energia");
		listaTarefas.add("Pagar conta de energia");
		listaTarefas.add("Pagar conta de energia");
		listaTarefas.add("Pagar conta de energia");
		listaTarefas.add("Pagar conta de energia");
		
		req.setAttribute("listaTarefas", listaTarefas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}

}
