package br.com.padaria.dto;

import java.io.Serializable;

import br.com.padaria.domain.Mesa;

public class MesaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Boolean fechada;
	
	private Double total;

	public MesaDTO(Integer id, Boolean fechada, Double total) {
		super();
		this.id = id;
		this.fechada = fechada;
		this.total = total;
	}
	
	public MesaDTO(Mesa mesa) {
		this.id = mesa.getId();
		this.fechada = mesa.getFechada();
		this.total = mesa.getTotal();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getFechada() {
		return fechada;
	}

	public void setFechada(Boolean fechada) {
		this.fechada = fechada;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
