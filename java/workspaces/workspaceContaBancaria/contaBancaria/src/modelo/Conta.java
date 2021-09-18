package modelo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Conta {
	
	protected String titularDaConta;
	protected int tipo; // tipo de conta (1 - poupança, 2 - corrente)
	protected double saldo;
	protected ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	protected Movimentacao movimentacao = new Movimentacao();
	
	public Conta () {
		
	}
	

	public Conta(String nome, int tipo) {
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
		movimentacao.setListaDeMovimentacao(listaDeMovimentacao);
		
		this.saldo += valor;
		
		movimentacao.setSaldo(this.saldo);
		
		JOptionPane.showMessageDialog(null ,"Valor depositado! =)");
	}
	
	public void sacar(int tipo, double valor, Date data) {
		Movimentacao saque = new Movimentacao();
		
		saque.setTipo(tipo);
		saque.setValor(valor);
		saque.setData(data);
		listaDeMovimentacao.add(saque);
		saque.setListaDeMovimentacao(listaDeMovimentacao);
		
		this.saldo -= valor;
		
		movimentacao.setSaldo(this.saldo);
		
		JOptionPane.showMessageDialog(null ,"Valor sacado! =)");
	}
	
	public double consultarSaldo() {
		
		double saldoAtual = movimentacao.getSaldo();

		return saldoAtual;
	}
	
	public String getTitularDaConta() {
		return this.titularDaConta;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public String gerarDadosDaConta() {
		int tipoNum = this.tipo;
		String tipoDaConta, dadosDaConta;
		
		if(tipoNum == 1) {
			tipoDaConta = "Conta poupança";
		}else {
			tipoDaConta = "Conta corrente";
		}
		
		dadosDaConta = "Titular: "+this.titularDaConta+ "\nTipo da conta: " + tipoDaConta +
						"\nSaldo: R$" +this.saldo ;
		
		return dadosDaConta;
	}
	
	public String gerarExtrato() {
		String extratoCompleto = "EXTRATO: \n";
		
		for(Movimentacao extrato : this.listaDeMovimentacao) {
			
			double valor = extrato.getValor();
			Date data = extrato.getData();
			
			int tipo = extrato.getTipo();
			String tipoDaConta;
			if(tipo == 1) {
				tipoDaConta = "Saque";
			}else {
				tipoDaConta = "Depósito";
			}
			
			extratoCompleto += "Operação: "+tipoDaConta+"\nValor: R$"+valor+
								"\nData: "+data;
			extratoCompleto += "\n----------------------------\n";
		}
		
		return extratoCompleto;
		}
	
	public String gerarExtratoDepositos() {
		String extratoDepositos = "EXTRATO DEPÓSITOS: \n";
		
		for(Movimentacao extratoDeposito : this.listaDeMovimentacao) {
			double valor;
			Date data;
			
			int tipo = extratoDeposito.getTipo();
			
			if(tipo == 2) {
				valor = extratoDeposito.getValor();
				data = extratoDeposito.getData();
				extratoDepositos += "Operação: Depósito\nValor: R$"+valor+
									"\nData: "+data;
				extratoDepositos += "\n----------------------------\n";
			}
		}
		return extratoDepositos;
	}
}


