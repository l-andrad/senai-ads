package controle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Controladora {

	public void exibirMenu() {
		String nome;
		int tipoSelecionado, tipo;
		//double saldo=0;
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
		
		System.out.println(nome);
		System.out.println(tipo);
	}
	
}
