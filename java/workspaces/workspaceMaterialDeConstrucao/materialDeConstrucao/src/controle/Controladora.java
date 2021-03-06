package controle;

import modelo.Loja;
import visualizacao.EntradaSaida;

public class Controladora {

	public void exibirMenu() {
		int opcao;
		Loja loja = new Loja();
		
		do {
			opcao = EntradaSaida.solicitaOpcao();
			
			switch(opcao) {
			case 0:
				EntradaSaida.solicitaInformacoesCadastro(loja);
			break;
			
			case 1:
				EntradaSaida.exibirListaDeProdutos(loja);
			break;
			
			case 2:
				EntradaSaida.solicitarInformacoesEstoque(loja);
			break;
			
			case 3:
				EntradaSaida.solicitaInformacoesVenda(loja);
			break;
			
			case 4:
				EntradaSaida.exibirListaEstoque(loja);
			break;
			
			case 5:
				EntradaSaida.exibirListaCupomFiscal(loja);
			break;
			
			case 6:
				EntradaSaida.exibirValorTotalDasVendas(loja);
			break;
			}
		}while(opcao != 7);
		
		EntradaSaida.exibirMsgEncerraPrograma();
		
		System.exit(0);
	}
	
}
