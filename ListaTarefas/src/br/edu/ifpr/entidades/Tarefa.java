package br.edu.ifpr.entidades;

import java.util.Date;
import java.util.UUID;

public class Tarefa {
	
	private String id;
	private String nome;
	private Date dataCriacao;
	private TarefaStatus status;
	
	public Tarefa() {
		this.id = UUID.randomUUID().toString();
		this.dataCriacao = new Date();
		this.status = TarefaStatus.CRIADO;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public TarefaStatus getStatus() {
		return status;
	}
	public void setStatus(TarefaStatus status) {
		this.status = status;
	}
	
	

}
