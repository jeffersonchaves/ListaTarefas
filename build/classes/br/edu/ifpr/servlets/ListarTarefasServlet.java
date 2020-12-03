package br.edu.ifpr.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpr.entidades.Tarefa;
import br.edu.ifpr.repositorio.ITarefaRepositorio;
import br.edu.ifpr.repositorio.TarefaRepositorioMemoria;

@WebServlet({"/tarefas","/tarefas/listar"})
public class ListarTarefasServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ITarefaRepositorio repositorio = new TarefaRepositorioMemoria();
	
	
	@Override
	public void init() throws ServletException {
		
		Tarefa tarefa1 = new Tarefa();
		tarefa1.setNome("Estudar JSP");
		repositorio.cadastrar(tarefa1);
		
		Tarefa tarefa2 = new Tarefa();
		tarefa2.setNome("Calibrar pneu do carro");
		repositorio.cadastrar(tarefa2);
		
		Tarefa tarefa3 = new Tarefa();
		tarefa3.setNome("Levar o lixo pra fora");
		repositorio.cadastrar(tarefa3);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("listaTarefas", repositorio.buscarTodas());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}

}
