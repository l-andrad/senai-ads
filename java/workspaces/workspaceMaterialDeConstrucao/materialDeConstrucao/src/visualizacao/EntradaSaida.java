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
		boolean listaVazia = false;
		
		listaVazia = listaCadastrados.verificaListaVaziaProdutos();
		
		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há nenhum produto cadastrado.");
		}else {
			listaProdutosCadastrados = listaCadastrados.gerarListaDeProdutosCadastrados();

			JOptionPane.showMessageDialog(null, listaProdutosCadastrados);
		}

		

	}

	public static void adicionarEstoque(Loja estoque) {
		int codigoInformado, qtdeInformado;
		boolean verificadorProduto = false;
		boolean listaVazia = false;
		
		listaVazia = estoque.verificaListaVaziaProdutos();
		
		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há nenhum produto cadastrado.");
		}else {
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

	public static void solicitaInformacoesVenda(Loja venda) {
		int codigo, quantidade;
		boolean verificaProduto = false;
		boolean verificaEstoque = false;
		boolean listaVazia = false;
		boolean verificaAbastecimentoEstoque = false;

		listaVazia = venda.verificaListaVaziaProdutos();

		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
		}else {
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Insira o código "
					+ "do produto que quer comprar:"));

			verificaProduto = venda.verificaExistenciaProduto(codigo);
			verificaAbastecimentoEstoque = venda.verificaAbastecimentoEstoque(codigo);

			if(verificaProduto == false) {
				JOptionPane.showMessageDialog(null, "O produto não está cadastrado!");
			}else if(verificaAbastecimentoEstoque == true){
				JOptionPane.showMessageDialog(null, "Produto sem estoque.");
			}else {
				quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira a "
						+ "quantidade que deseja comprar:"));

				while(quantidade <= 0) {
					JOptionPane.showMessageDialog(null, "Informa uma quantidade maior que zero!");

					quantidade = Integer.parseInt(JOptionPane.showInputDialog("Insira a "
							+ "quantidade que deseja comprar:"));
				}

				verificaEstoque = venda.verificaEstoque(codigo, quantidade);

				if(verificaEstoque == true) {
					venda.venderProduto(codigo, quantidade);
				}else {
					JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
				}
			}
		}
	}

	public static void exibirListaEstoque(Loja estoque) {
		String listaEstoque;

		listaEstoque = estoque.gerarListaEstoque();

		if(listaEstoque == "") {
			JOptionPane.showMessageDialog(null, "Não há produtos em estoque.");
		}else {
			JOptionPane.showMessageDialog(null, listaEstoque);
		}
	}
	
	public static void exibirListaCupomFiscal(Loja cupom) {
		String listaCupons;
		boolean listaVazia = false;
		
		listaVazia = cupom.verificaListaVaziaCupons();
		
		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há nenhuma venda.");
		}else {
			listaCupons = cupom.gerarListaCupons();
			
			JOptionPane.showMessageDialog(null, listaCupons);
		}
		
	}
	
	public static void exibirValorTotalDasVendas(Loja totalVendas) {
		boolean listaVazia = false;
		String textoFinal;
		
		listaVazia = totalVendas.verificaListaVaziaCupons();
		
		if(listaVazia == true) {
			JOptionPane.showMessageDialog(null, "Não há nenhuma venda.");
		}else {
			textoFinal = totalVendas.calcularValorVendas();
			
			JOptionPane.showMessageDialog(null, textoFinal);
		}
	}
	
	public static void exibirMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}

}
