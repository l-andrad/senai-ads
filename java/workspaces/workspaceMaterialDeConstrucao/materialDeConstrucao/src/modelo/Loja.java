package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Loja {

	private ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
	private ArrayList<Venda> listaDeCupons = new ArrayList<Venda>();
	private DecimalFormat df = new DecimalFormat("0.00");
	
	public void cadastrarProduto(int codigo, String descricao, double preco) {
	Produto cadastrar = new Produto();	
	
	cadastrar.setCodigo(codigo);
	cadastrar.setDescricao(descricao);
	cadastrar.setPreco(preco);
	listaDeProdutos.add(cadastrar);
	
	}
	
	public String gerarListaDeProdutosCadastrados() {
		String listaDeProdutosCadastrados, descricao;
		int codigo;
		double preco;
		boolean listaVazia = listaDeProdutos.isEmpty();
		
		if(listaVazia == true) {
			listaDeProdutosCadastrados = "";
		}else {
			listaDeProdutosCadastrados = "Lista de produtos:\n";
			
			for(Produto lista : listaDeProdutos) {
				codigo = lista.getCodigo();
				descricao = lista.getDescricao();
				preco = lista.getPreco();
				
				listaDeProdutosCadastrados += "Código: "+codigo+"\nDescrição: "
									+descricao+"\nPreço: "+df.format(preco);
				listaDeProdutosCadastrados += "\n---------------------------\n";
			}
		}
		return listaDeProdutosCadastrados;
	}
	
	public boolean verificaExistenciaProduto(int codigoInformado) {
		int codigoProduto;
		boolean verificaProduto = false;
		
		for(Produto verifica : listaDeProdutos) {
			codigoProduto = verifica.getCodigo();
			if(codigoProduto == codigoInformado) {
				verificaProduto = true;
			}
		}
		
		return verificaProduto;
	}
	
	public void adicionarEstoque(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;
		
		for(Produto estoque : listaDeProdutos) {
				codigoProduto = estoque.getCodigo();
				qtdeProduto = estoque.getQuantidade();
				qtdeProduto += qtdeInformada;
				estoque.setQuantidade(qtdeProduto);
		}
	}

}
