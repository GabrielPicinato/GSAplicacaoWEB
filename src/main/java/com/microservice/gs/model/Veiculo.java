package com.microservice.gs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="veiculos")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String marca;
	private String modelo;
	private String placa;
	private int quilometragem;
	
	public Veiculo( String marca, String modelo, String placa, int quilometragem) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}




	public String getMarca() {
		return marca;
	}




	public void setMarca(String marca) {
		this.marca = marca;
	}




	public String getModelo() {
		return modelo;
	}




	public void setModelo(String modelo) {
		this.modelo = modelo;
	}




	public String getPlaca() {
		return placa;
	}




	public void setPlaca(String placa) {
		this.placa = placa;
	}




	public int getQuilometragem() {
		return quilometragem;
	}




	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}




	public Veiculo() {
	}

	
}
