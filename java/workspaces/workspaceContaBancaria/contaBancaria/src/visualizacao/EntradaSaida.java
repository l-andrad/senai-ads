package visualizacao;

import modelo.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Date;
import java.text.DecimalFormat;

public class EntradaSaida {
	
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public String solicitaTitularDaConta() {
		String nome;
		
		nome = JOptionPane.showInputDialog("Informe o nome do titular da conta: ");
		
		return nome;
	}
	
	public int solicitaTipoDaConta() {
		int tipoSelecionado, tipo;
		String opcoesConta[] = {"Conta corrente", "Conta poupança"};
		
		JComboBox<String> menuConta = new JComboBox<String> (opcoesConta);
		
		JOptionPane.showConfirmDialog(null, menuConta, 
				"Selecione o tipo da conta: ", JOptionPane.OK_CANCEL_OPTION);
		
		tipoSelecionado = menuConta.getSelectedIndex();
		
		if(tipoSelecionado == 0) {
			tipo = 2;
		}else {
			tipo = 1;
		}
		
		return tipo;
		
	}
	
	public static int solicitaOpcao() {
		
		String[] opcoes = {"Depositar", "Sacar", "Saldo atual", "Dados da conta",
							"Extrato completo", "Extrato depósitos", "Extrato saques", 
							"Encerrar programa"};
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada:", 
				JOptionPane.OK_CANCEL_OPTION);
		
		int escolha = menu.getSelectedIndex();
		
		return escolha;
	}
	
	public void solicitaInformacoesDeposito(Conta deposito) {
		
		int tipo = 2;
		double valor;
		Date data;
		
		valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o "
				+ "valor a ser depositado:"));
		
		data = new Date();
		
		deposito.depositar(tipo, valor, data);
		
	}
	
	public void solicitaInformacoesSaque(Conta saque) {
		
		int tipo = 1;
		double valor;
		Date data;
		
		valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o "
				+ "valor a ser sacado:"));
		
		data = new Date();
		
		saque.sacar(tipo, valor, data);
	}
	
	public void exibirSaldo(Conta saldo) {
		
		
		double saldoAtual = saldo.consultarSaldo();
		
		JOptionPane.showMessageDialog(null, "Seu saldo atual é de: R$" + df.format(saldoAtual));
	}
	
	public void exibirDadosDaConta(Conta dados) {
		
		String dadosAtuais;
		
		dadosAtuais = dados.gerarDadosDaConta();
		
		JOptionPane.showMessageDialog(null, dadosAtuais);
	}
	
	public void exibirExtratoCompleto(Conta extrato) {
		
		String extratoGerado = extrato.gerarExtrato();
		
		if(extratoGerado == "") {
			JOptionPane.showMessageDialog(null, "Nenhuma movimentação encontrada!");
		}else {
			JOptionPane.showMessageDialog(null, extratoGerado);
		}
	}
	
	public void exibirExtratoDeDepositos(Conta extratoDepositos) {
		
		String extratoDepositosGerado = extratoDepositos.gerarExtratoDepositos();
		
		if(extratoDepositosGerado == "") {
			JOptionPane.showMessageDialog(null, "Nenhum depósito encontrado!");
		}else {
			JOptionPane.showMessageDialog(null, extratoDepositosGerado);
		}
	}
	
	public void exibirExtratoDeSaques(Conta extratoSaques) {
		String extratoSaquesGerado = extratoSaques.gerarExtratoSaques();
		
		if(extratoSaquesGerado == "") {
			JOptionPane.showMessageDialog(null, "Nenhum saque encontrado!");
		}else {
			JOptionPane.showMessageDialog(null, extratoSaquesGerado);
		}	
	}
	
	public void exibirMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}
	
}
