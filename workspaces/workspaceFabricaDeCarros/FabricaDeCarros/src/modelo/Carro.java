package modelo;

import java.util.ArrayList;

public  class Carro {

	protected String modelo;
	protected String cor;
	protected int ano;
	protected ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}
	
	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}
	
	
	
	
}
