package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Date;

import javax.swing.JOptionPane;

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

		if (listaVazia == true) {
			listaDeProdutosCadastrados = "";
		} else {
			listaDeProdutosCadastrados = "Lista de produtos:\n";

			for (Produto lista : listaDeProdutos) {
				codigo = lista.getCodigo();
				descricao = lista.getDescricao();
				preco = lista.getPreco();

				listaDeProdutosCadastrados += "Código: " + codigo + "\nDescrição: " 
							+ descricao + "\nPreço: R$"+ df.format(preco);
				listaDeProdutosCadastrados += "\n---------------------------\n";
			}
		}
		return listaDeProdutosCadastrados;
	}

	public boolean verificaExistenciaProduto(int codigoInformado) {
		int codigoProduto;
		boolean verificaProduto = false;

		for (Produto verifica : listaDeProdutos) {
			codigoProduto = verifica.getCodigo();
			if (codigoProduto == codigoInformado) {
				verificaProduto = true;
			}
		}

		return verificaProduto;
	}

	public void adicionarEstoque(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;

		for (Produto estoque : listaDeProdutos) {
			codigoProduto = estoque.getCodigo();
			if (codigoProduto == codigoInformado) {
				qtdeProduto = estoque.getQuantidade();
				qtdeProduto += qtdeInformada;
				estoque.setQuantidade(qtdeProduto);
			}
		}
		JOptionPane.showMessageDialog(null, "Estoque adicionado! =)");
	}

	public boolean verificaListaVaziaProdutos() {
		boolean listaVazia = false;

		listaVazia = listaDeProdutos.isEmpty();

		return listaVazia;
	}

	public boolean verificaEstoque(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;
		boolean verificaEstoque = false;

		for (Produto estoque : listaDeProdutos) {
			codigoProduto = estoque.getCodigo();
			qtdeProduto = estoque.getQuantidade();

			if ((codigoProduto == codigoInformado) && (qtdeProduto >= qtdeInformada)) {
				verificaEstoque = true;
			}
		}
		return verificaEstoque;
	}
	
	public boolean verificaAbastecimentoEstoque(int codigoInformado) {
		int codigoProduto, qtdeProduto;
		boolean verificaAbastecimento = false;
		
		for(Produto abastecimento : listaDeProdutos) {
			codigoProduto = abastecimento.getCodigo();
			qtdeProduto = abastecimento.getQuantidade();
			
			if(codigoProduto == codigoInformado) {
				if(qtdeProduto == 0) {
					verificaAbastecimento = true;
				}
			}
		}
		return verificaAbastecimento;
	}

	public void venderProduto(int codigoInformado, int qtdeInformada) {
		int codigoProduto, qtdeProduto;
		String descricaoProduto;
		double precoProduto, valorTotalVenda;
		Date dataVenda;

		for (Produto venda : listaDeProdutos) {
			codigoProduto = venda.getCodigo();
			qtdeProduto = venda.getQuantidade();

			if (codigoProduto == codigoInformado) {
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
		JOptionPane.showMessageDialog(null, "Produto vendido! =)");
	}

	public String gerarListaEstoque() {
		String listaEstoque = "";
		int codigoProduto, qtdeProduto;
		String descricaoProduto;

		for (Produto lista : listaDeProdutos) {
			qtdeProduto = lista.getQuantidade();

			if ((qtdeProduto > 0) && (listaEstoque == "")) {
				listaEstoque = "Estoque:\n";

				codigoProduto = lista.getCodigo();
				descricaoProduto = lista.getDescricao();

				listaEstoque += "Código: " + codigoProduto + "\nDescrição: " + descricaoProduto + "\nQuantidade: "
						+ qtdeProduto;
				listaEstoque += "\n----------------------\n";
			}else if(qtdeProduto > 0){
				codigoProduto = lista.getCodigo();
				descricaoProduto = lista.getDescricao();

				listaEstoque += "Código: " + codigoProduto + "\nDescrição: " + descricaoProduto + "\nQuantidade: "
						+ qtdeProduto;
				listaEstoque += "\n----------------------\n";
			}
		}
		return listaEstoque;
	}
	
	public boolean verificaListaVaziaCupons() {
		boolean listaVazia = false;
		
		listaVazia = listaDeCupons.isEmpty();
		
		return listaVazia;
	}
	
	public String gerarListaCupons() {
		String listaCupons = "Lista de cupons:\n";
		Date data;
		String descricaoProduto;
		int qtdeVendida;
		double valorTotalVenda;
		
		for(Venda lista : listaDeCupons) {
			data = lista.getData();
			descricaoProduto = lista.getDescricao();
			qtdeVendida = lista.getQuantidade();
			valorTotalVenda = lista.getValorTotal();
			
			listaCupons += "Data da venda: "+data+"\nDescrição: "+descricaoProduto
							+"\nQuantidade vendida: "+qtdeVendida+"\nValor total: R$"
							+df.format(valorTotalVenda);
			listaCupons += "\n---------------------\n";
		}
		return listaCupons;
	}
	
	public String calcularValorVendas() {
		double valorTotalVendas = 0, valorTotalDaVenda;
		String valorTotal;
		
		for(Venda total : listaDeCupons) {
			valorTotalDaVenda = total.getValorTotal();
			
			valorTotalVendas += valorTotalDaVenda;
		}
		valorTotal = "O valor total de todas as vendas é de: RS"+df.format(valorTotalVendas);
		return valorTotal;
	}

}
