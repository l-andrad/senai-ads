package modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Conta {
	
	protected String titularDaConta;
	protected int tipo; // tipo de conta (1 - poupança, 2 - corrente)
	protected double saldo;
	protected ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	
	
	

	public void criarConta(String nome, int tipo) {
		titularDaConta = nome;
		this.tipo = tipo;
		this.saldo = 0;
	}
		
	
	public void depositar(int tipo, double valor, Date data) {
		
		Movimentacao deposito = new Movimentacao();
		
		deposito.setTipo(tipo);
		deposito.setValor(valor);
		deposito.setData(data);
		listaDeMovimentacao.add(deposito);
		deposito.setListaDeMovimentacao(listaDeMovimentacao);
		
		this.saldo += valor;
		
		JOptionPane.showMessageDialog(null ,"Valor depositado! =)");
		System.out.println(saldo);
	}
	
	public void sacar(int tipo, double valor, Date data) {
		Movimentacao saque = new Movimentacao();
		
		saque.setTipo(tipo);
		saque.setValor(valor);
		saque.setData(data);
		listaDeMovimentacao.add(saque);
		saque.setListaDeMovimentacao(listaDeMovimentacao);
		
		this.saldo -= valor;
		
		JOptionPane.showMessageDialog(null ,"Valor sacado! =)");
	}
	
	public double consultarSaldo() {
		return this.saldo;
	}
	
	public String getTitularDaConta() {
		return this.titularDaConta;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public String gerarExtrato() {
		String extratoCompleto = "EXTRATO: \n";
		
		for(Movimentacao extrato : listaDeMovimentacao) {
			int tipo = extrato.getTipo();
			String tipoDaConta;
			if(tipo == 1) {
				tipoDaConta = "Saque";
			}else {
				tipoDaConta = "Depósito";
			}
			
			double valor = extrato.getValor();
			Date data = extrato.getData();
			
			extratoCompleto += "Operação: "+tipoDaConta+"\nValor: "+valor+"\nData: "+data;
			extratoCompleto += "---------------------\n";
		}
		
		return extratoCompleto;
		}	
}


