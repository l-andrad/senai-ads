package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Conta {
	
	protected String titularDaConta;
	protected int tipo; // tipo de conta (1 - poupança, 2 - corrente)
	protected double saldo;
	protected ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	

	public Conta(String nome, int tipo) {
		titularDaConta = nome;
		this.tipo = tipo;
		this.saldo = 0;
	}
	
	public void depositar(int tipo, double valor, Date data) {
		Movimentacao deposito = new Movimentacao();
		
		
		
		this.saldo += saldo;
	}
	
}
