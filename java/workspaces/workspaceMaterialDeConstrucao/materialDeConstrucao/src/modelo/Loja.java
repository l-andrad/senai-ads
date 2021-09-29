package modelo;

import java.util.ArrayList;

import java.text.DecimalFormat;
import java.util.Date;

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
			if(codigoProduto == codigoInformado) {
					qtdeProduto = estoque.getQuantidade();
					qtdeProduto += qtdeInformada;
					estoque.setQuantidade(qtdeProduto);
			}		
		}
	}
	
	public boolean verificaEstoque(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;
		boolean verificaEstoque = false;
		
		for (Produto estoque : listaDeProdutos) {
			codigoProduto = estoque.getCodigo();
			qtdeProduto = estoque.getQuantidade();
			
			if((codigoProduto == codigoInformado) && (qtdeProduto == qtdeInformada)) {
				verificaEstoque = true;
			}
		}
		return verificaEstoque;
	}
	
	public void venderProduto(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;
		String descricaoProduto;
		double precoProduto, valorTotalVenda;
		Date dataVenda;
		
		for(Produto venda : listaDeProdutos) {
			codigoProduto = venda.getCodigo();
			qtdeProduto = venda.getQuantidade();
			
			if(codigoProduto == codigoInformado) {
				Venda vender = new Venda();
				descricaoProduto = venda.getDescricao();
				dataVenda = new Date();
				precoProduto = venda.getPreco();
				
				qtdeProduto -= qtdeInformada;
				valorTotalVenda = precoProduto * qtdeInformada;
				
				vender.setDescricao(descricaoProduto);
				vender.setData(dataVenda);
				vender.setQuantidade(qtdeInformada);
				vender.setValorTotal(valorTotalVenda);
				listaDeCupons.add(vender);
				
				venda.setQuantidade(qtdeProduto);
			}
		}
		
		
		
	}

}
