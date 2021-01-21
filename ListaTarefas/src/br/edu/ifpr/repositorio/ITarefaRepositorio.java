package br.edu.ifpr.repositorio;

import java.util.List;

import br.edu.ifpr.entidades.Tarefa;

public interface ITarefaRepositorio {
	
	public List<Tarefa> buscarTodas();
	
	public Tarefa buscarPorId(String id);
	
	public Tarefa cadastrar(Tarefa tarefa);
	
	public void alterarStatus(String id, String status) throws IllegalArgumentException;

	public void excluir(String id);
}
