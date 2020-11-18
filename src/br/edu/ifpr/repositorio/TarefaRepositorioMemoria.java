package br.edu.ifpr.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.entidades.Tarefa;

public class TarefaRepositorioMemoria implements ITarefaRepositorio {
	
	private static List<Tarefa> tarefas = new ArrayList<Tarefa>();

	@Override
	public List<Tarefa> buscarTodas() {
		return tarefas;
	}

	@Override
	public Tarefa buscarPorId(String id) {
		
		for (Tarefa tarefa : tarefas) {
			if(id == tarefa.getId()) {
				return tarefa;
			}
		}
		
		throw new IllegalArgumentException("id inexistente");
	}

	@Override
	public Tarefa cadastrar(Tarefa tarefa) {
		tarefas.add(tarefa);
		
		return tarefa;
	}

}
