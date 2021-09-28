package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Loja;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = {"Cadastrar produto", "Produtos cadastrados",
					"Abastecer estoque", "Vender produto", "Produtos em estoque",
					"Lista de cupons", "Valor total vendas", "Sair do programa"};
		
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada:", 
				JOptionPane.OK_CANCEL_OPTION);
		
		int escolha = menu.getSelectedIndex();
		
		return escolha;
	}
	
	public static void solicitaInformacoesCadastro(Loja cadastro) {
		int codigo;
		String descricao;
		double preco;
		
		codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código "
				+ "do produto:"));
		descricao = JOptionPane.showInputDialog("Insira a descrição do produto:");
		preco = Double.parseDouble(JOptionPane.showInputDialog("Insira o preço "
				+ "do produto:"));
		
		cadastro.cadastrarProduto(codigo, descricao, preco);
		
		JOptionPane.showMessageDialog(null, "Produto cadastrado! =)");
	}
	
	public static void exibirListaDeProdutos(Loja listaCadastrados) {
		String listaProdutosCadastrados;
		
		listaProdutosCadastrados = listaCadastrados.gerarListaDeProdutosCadastrados();
		
		JOptionPane.showMessageDialog(null, listaProdutosCadastrados);
		
	}
	
	public static void adicionarEstoque(Loja estoque) {
		int codigoInformado, qtdeInformado;
		boolean verificadorProduto;
		
		codigoInformado = Integer.parseInt(JOptionPane.showInputDialog("Insira "
				+ "o código do produto cadastrado:"));
		
		verificadorProduto = estoque.verificaExistenciaProduto(codigoInformado);
		
		if(verificadorProduto == true) {
			qtdeInformado = Integer.parseInt(JOptionPane.showInputDialog("Insira "
					+ "a quantidade a ser adicionada:"));
			
			while(qtdeInformado <= 0) {
				JOptionPane.showMessageDialog(null, "Quantidade inválida!");
				qtdeInformado = Integer.parseInt(JOptionPane.showInputDialog("Insira "
						+ "novamente a quantidade a ser adicionada:"));
			}
			
			estoque.adicionarEstoque(codigoInformado, qtdeInformado);
		}else {
			JOptionPane.showMessageDialog(null, "Produto não cadastrado!");
		}
	}
	
}
