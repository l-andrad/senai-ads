package modelo;

import java.util.Date;

public class Venda {
	
	String descricao;
	double valorTotal;
	Date data;
	int quantidade;
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValorTotal() {
		return this.valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
