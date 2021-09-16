package visualizacao;

import modelo.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.ArrayList;

public class EntradaSaida {
	
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	public void solicitaDadosConta(){
		String nome;
		int tipoSelecionado, tipo;
		String opcoesConta[] = {"Conta corrente", "Conta poupança"};
		
		nome = JOptionPane.showInputDialog("Informe o nome do titular da conta: ");
		JComboBox<String> menuConta = new JComboBox<String> (opcoesConta);
		
		JOptionPane.showConfirmDialog(null, menuConta, 
				"Selecione o tipo da conta: ", JOptionPane.OK_CANCEL_OPTION);
		
		tipoSelecionado = menuConta.getSelectedIndex();
		
		if(tipoSelecionado == 0) {
			tipo = 2;
		}else {
			tipo = 1;
		}
		
		Conta dadosDaConta = new Conta(nome, tipo);
		
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
	
	public void solicitaInformacoesDeposito() {
		Conta deposito = new Conta();
		
		int tipo = 2;
		double valor;
		Date data;
		
		valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o "
				+ "valor a ser depositado"));
		
		data = new Date();
		
		deposito.depositar(tipo, valor, data);
		
	}
	
}
