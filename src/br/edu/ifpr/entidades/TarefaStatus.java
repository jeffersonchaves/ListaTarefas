package br.edu.ifpr.entidades;

public enum TarefaStatus {

	CRIADO("criado"),
	EM_ANDAMENTO("em andamento"),
	CANCELADO("cancelado"),
	CONCLUIDO("concluido");
	
	private final String status;

	TarefaStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
