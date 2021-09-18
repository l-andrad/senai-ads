package modelo;

import java.util.Date;
import java.util.ArrayList;

public class Movimentacao {

	protected int tipo;
	protected double valor;
	protected Date data;
	protected double saldo;
	protected ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	
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
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public ArrayList<Movimentacao> getListaDeMovimentacao(){
		return this.listaDeMovimentacao;
	}
	
	public void setListaDeMovimentacao(ArrayList<Movimentacao> 
	listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}
}
