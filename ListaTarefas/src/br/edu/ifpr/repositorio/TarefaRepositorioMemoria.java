package br.edu.ifpr.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.entidades.Tarefa;
import br.edu.ifpr.entidades.TarefaStatus;

public class TarefaRepositorioMemoria implements ITarefaRepositorio {
	
	private static List<Tarefa> tarefas = new ArrayList<Tarefa>();

	@Override
	public List<Tarefa> buscarTodas() {
		return tarefas;
	}

	@Override
	public Tarefa buscarPorId(String id) throws IllegalArgumentException {
		
		for (Tarefa tarefa : tarefas) {
			if(id.equals(tarefa.getId())) {
				return tarefa;
			}
		}
		
		throw new IllegalArgumentException("id inexistente");
	}

	@Override
	public Tarefa cadastrar(Tarefa tarefa) throws IllegalArgumentException {
		
		if(tarefa.getNome() == null || tarefa.getNome().isEmpty()) {
			
			throw new IllegalArgumentException("O nome da tarefa nao pode ser vazio");
			
		} else if(tarefa.getNome().length()  < 3) {
			
			throw new IllegalArgumentException("O nome da tarefa nao pode ter menos que 3 caracteres");
		
		}
		
		tarefas.add(tarefa);
		
		return tarefa;
	}
	
	public void alterarStatus(String id, String status) throws IllegalArgumentException {
		
		Tarefa tarefa = this.buscarPorId(id);
		
		switch(status) {
			case "cancelar":
				tarefa.setStatus(TarefaStatus.CANCELADO);
				break;
			
			case "concluir":
				tarefa.setStatus(TarefaStatus.CONCLUIDO);
				break;
				
			default:
				throw new IllegalArgumentException("Status inválido");
		}
	}

	public void excluir(String id) {
		
		for (int index = 0; index < tarefas.size(); index++) {
			
			Tarefa tarefa = tarefas.get(index);
			
			if(tarefa.getId().equals(id)) {
				tarefas.remove(index);
			}
			
		}
		
		//Validacao
		//throw Exception(...)
		
	}
}
