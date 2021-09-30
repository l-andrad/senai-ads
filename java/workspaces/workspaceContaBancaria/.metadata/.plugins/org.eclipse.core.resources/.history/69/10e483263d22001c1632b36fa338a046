package controle;

import visualizacao.EntradaSaida;
import modelo.Conta;

public class Controladora {

	public void exibirMenu() {
		
		EntradaSaida criarConta = new EntradaSaida();
		String nome = criarConta.solicitaTitularDaConta();
		int tipo = criarConta.solicitaTipoDaConta();
		Conta conta = new Conta(nome, tipo);
		
		EntradaSaida operacoes = new EntradaSaida();
		
		int opcao;
		
		
		
		
		do {
			opcao = EntradaSaida.solicitaOpcao();
			
			switch(opcao) {
			case 0:
				operacoes.solicitaInformacoesDeposito(conta);
			break;
		
			case 1:
				operacoes.solicitaInformacoesSaque(conta);
			break;
			
			case 2:
				operacoes.exibirSaldo(conta);
			break;
			
			case 3:
				operacoes.exibirDadosDaConta(conta);
			break;
			
			case 4:
				operacoes.exibirExtratoCompleto(conta);
			break;
			
			case 5:
				operacoes.exibirExtratoDeDepositos(conta);
			break;
			
			case 6:
				operacoes.exibirExtratoDeSaques(conta);
			break;
			}
			
		}while(opcao != 7);
		
		operacoes.exibirMsgEncerraPrograma();
		
		System.exit(0);
		
	}
	
}
