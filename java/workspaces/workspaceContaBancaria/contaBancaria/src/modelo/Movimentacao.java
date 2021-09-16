package modelo;

import java.util.Date;
import java.util.ArrayList;

public class Movimentacao {

	private int tipo;
	private double valor;
	private Date data;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	
	public int getTipo() {
		return this.tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public ArrayList<Movimentacao> getListaDeMovimentacao(){
		return this.listaDeMovimentacao;
	}
	
	public void setListaDeMovimentacao(ArrayList<Movimentacao> 
	listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}
}
