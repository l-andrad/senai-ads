package controle;

import visualizacao.EntradaSaida;
import modelo.Conta;

public class Controladora {

	public void exibirMenu() {
		
		EntradaSaida criarConta = new EntradaSaida();
		criarConta.solicitaDadosConta();
		Conta conta = new Conta();
		
		EntradaSaida operacoes = new EntradaSaida();
		
		int opcao;
		
		
		
		
		do {
			opcao = EntradaSaida.solicitaOpcao();
			
			switch(opcao) {
			case 0:
				operacoes.solicitaInformacoesDeposito();
			break;
		
			case 1:
				operacoes.solicitaInformacoesSaque();
			break;
			
			case 2:
				operacoes.exibirSaldo(conta);
			break;
			
			case 3:
				operacoes.exibirDadosDaConta();
			break;
			
			case 4:
				operacoes.exibirExtratoCompleto();
			break;
			}
			
		}while(opcao != 7);
		
		System.exit(0);
		
	}
	
}
