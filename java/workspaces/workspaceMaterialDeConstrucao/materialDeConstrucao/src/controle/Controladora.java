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
				EntradaSaida.adicionarEstoque(loja);
			}
		}while(opcao != 7);
	}
	
}
