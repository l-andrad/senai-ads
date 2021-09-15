package visualizacao;

import modelo.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class EntradaSaida {
	
	public static int solicitaOpcao(Fabrica fabrica) {
		String[] opcoes = {"Fabricar carros", "Vender um carro", 
				"Ver informações dos carros", "Sair do programa"};
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada:", 
				JOptionPane.OK_CANCEL_OPTION);
		
		int escolha = menu.getSelectedIndex();
		
		while(fabrica == null && (escolha == 1 || escolha == 2)) {
			JOptionPane.showMessageDialog(null, "Primeiro fabrique alguns carros!");
			
			JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada:", 
					JOptionPane.OK_CANCEL_OPTION);
			
			escolha = menu.getSelectedIndex();
		}
		
		return escolha;
		
	}

	
	public static int solicitaQtdCarros() {
		return Integer.parseInt(JOptionPane.showInputDialog("Informe quantos "
				+ "carros você quer fabricar: "));
	}
	
	public static String solicitaModelo(int ordem) {
		
		return JOptionPane.showInputDialog("Qual o modelo do "+ordem+"º carro?");
		
	}
	
	public static String solicitaCor(int ordem) {
		return JOptionPane.showInputDialog("Qual a cor do "+ordem+"º carro:");
	}
	
	public static int solicitaAno(int ordem) {
		return Integer.parseInt(JOptionPane.showInputDialog("Qual o ano do "
			   +ordem+"º carro:"));
	}
	
	public void exibeListaDeCarros(Fabrica fabrica) {
		
		//Fabrica fabrica = new Fabrica();
		ArrayList<Carro> listaDeCarros = fabrica.getListaDeCarros();
		boolean listaVazia = listaDeCarros.isEmpty();
		String informacoes = null;
		
		
		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há nenhum carro fabricado!");
		}else {
			informacoes = fabrica.geraInfoCarros();
		}
		
		if(listaVazia != true) {
			JOptionPane.showMessageDialog(null, informacoes, "Informações dos carros",
					JOptionPane.INFORMATION_MESSAGE);
			}
		
	}
	
	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}
	
	
	
}
