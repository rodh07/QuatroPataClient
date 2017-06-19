package br.univel.bicho;

import java.io.Serializable;

public class Bicho implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String nome;
	public String especie;
	public String dono;
	public String emailDono;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public String getEmailDono() {
		return emailDono;
	}
	public void setEmailDono(String emailDono) {
		this.emailDono = emailDono;
	}
	@Override
	public String toString() {
		return "Bicho [id=" + id + ", nome=" + nome + ", especie=" + especie + ", dono=" + dono + ", emailDono="
				+ emailDono + "]";
	}
	
	
}
