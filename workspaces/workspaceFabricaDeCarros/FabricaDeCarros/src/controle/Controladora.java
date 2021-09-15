package controle;


import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {
	
	private Fabrica fabrica = null;
	private EntradaSaida exibir = new EntradaSaida();
	
	public void exibirMenu() {
		int opcao;

		do {
			opcao = EntradaSaida.solicitaOpcao(fabrica);
			
			switch(opcao) {
			case 0:
				if(fabrica == null) {
					fabrica = new Fabrica();
				}
				fabrica.fabricarCarro();
				
			break;
				
			case 1:
				fabrica.venderCarro();
			break;
			
			case 2:
				exibir.exibeListaDeCarros(fabrica);
			break;
			}
		}while(opcao != 3);
		
		EntradaSaida.exibeMsgEncerraPrograma();
		
		System.exit(0);
		
	}

}
