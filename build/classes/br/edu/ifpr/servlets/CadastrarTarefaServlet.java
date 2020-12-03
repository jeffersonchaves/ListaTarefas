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

@WebServlet("/tarefas/cadastrar")
public class CadastrarTarefaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ITarefaRepositorio repositorio = new TarefaRepositorioMemoria();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nomeTarefa = req.getParameter("inputNomeTarefa");
		
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(nomeTarefa);
		
		try {
			repositorio.cadastrar(tarefa);	
			resp.sendRedirect("/app");
		
		} catch(IllegalArgumentException e) {
						
			req.setAttribute("erros", e.getMessage());
			RequestDispatcher disp = req.getRequestDispatcher("/app");
			disp.forward(req, resp);
		}
	}
}
