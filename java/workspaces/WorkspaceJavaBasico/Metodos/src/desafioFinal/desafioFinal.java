package desafioFinal;

import javax.swing.JOptionPane;

public class desafioFinal {
	
	public static int tabuleiroPosicao[][] = new int[3][3];
	public static String tabuleiroJogo[][] = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
	public static int posicoesJogadas[] = new int[9];

	public static void main(String[] args) {
		
		int contadora = 1, jogadas = 0, posicao = 0;
		String jogadorDaVez, tabuleiro;
		boolean verificador = false;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				tabuleiroPosicao[i][j] = contadora;
				contadora = contadora + 1;
			}
		}
		
		do {
			
		jogadorDaVez = verificaJogadorDaVez(jogadas);
		posicao = pedirPosicao(jogadorDaVez);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(tabuleiroPosicao[i][j] == posicao) {
					tabuleiroJogo[i][j] = jogadorDaVez;
				}
			}
		}
		
		jogadas += 1;
		
		posicoesJogadas[posicao - 1] = posicao;
		
		verificador = verificaVencedor(verificador, jogadorDaVez);
		
		}while((jogadas != 9) && (verificador == false));
		
		tabuleiro = mostrarTabuleiro();
		
		if(verificador == false) {
			JOptionPane.showMessageDialog(null, "O Jogo deu velha!" 
												+ "\n" + tabuleiro);
		}else {
			JOptionPane.showMessageDialog(null, "Jogador (" + jogadorDaVez + ") ganhou a partida!"
												+ "\n" + tabuleiro);
		}
		
	}
	
	public static int pedirPosicao(String jogadorDaVez) {
		
		String tabuleiro = "";
		int posicao;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				tabuleiro += tabuleiroJogo[i][j] + "   ";
			}
			tabuleiro += "\n";
		}
		
		posicao = Integer.parseInt(JOptionPane.showInputDialog(null, tabuleiro
										  + "\nJogador (" + jogadorDaVez + ") Insira a posição que deseja jogar: "));
		
		
		while((posicao < 1) || (posicao > 9)) {
			posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Posição inválida!"
																		 + "\n" + tabuleiro
																		 + "\nJogador (" + jogadorDaVez + ") Insira uma outra posição que deseja jogar: "));
		}
		while(posicoesJogadas[posicao - 1] != 0) {
			posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Esta posição já foi preenchida!"
																		 + "\n" + tabuleiro
																		 + "\nJogador (" + jogadorDaVez + ") Insira uma outra posição que deseja jogar: "));
			while((posicao < 1) || (posicao > 9)) {
				posicao = Integer.parseInt(JOptionPane.showInputDialog(null, "Posição inválida!"
																			 + "\n" + tabuleiro
																			 + "\nJogador (" + jogadorDaVez + ") Insira uma outra posição que deseja jogar: "));
			}
		
		}
		
		return posicao;
	}
	
	public static String verificaJogadorDaVez(int jogadas) {
		
		String jogadorDaVez;
		
		if(jogadas % 2 == 0) {
			jogadorDaVez = "X";
		}else {
			jogadorDaVez = "O";
		}
		
		return jogadorDaVez;
		
	}
	
	public static boolean verificaVencedor(boolean verificador, String jogadorDaVez) {
		
		if((tabuleiroJogo[0][0].equals(jogadorDaVez)) && (tabuleiroJogo[0][1].equals(jogadorDaVez)) && (tabuleiroJogo[0][2].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[1][0].equals(jogadorDaVez)) && (tabuleiroJogo[1][1].equals(jogadorDaVez)) && (tabuleiroJogo[1][2].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[2][0].equals(jogadorDaVez)) && (tabuleiroJogo[2][1].equals(jogadorDaVez)) && (tabuleiroJogo[2][2].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[0][0].equals(jogadorDaVez)) && (tabuleiroJogo[1][0].equals(jogadorDaVez)) && (tabuleiroJogo[2][0].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[0][1].equals(jogadorDaVez)) && (tabuleiroJogo[1][1].equals(jogadorDaVez)) && (tabuleiroJogo[2][1].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[0][2].equals(jogadorDaVez)) && (tabuleiroJogo[1][2].equals(jogadorDaVez)) && (tabuleiroJogo[2][2].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[0][0].equals(jogadorDaVez)) && (tabuleiroJogo[1][1].equals(jogadorDaVez)) && (tabuleiroJogo[2][2].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		if((tabuleiroJogo[0][2].equals(jogadorDaVez)) && (tabuleiroJogo[1][1].equals(jogadorDaVez)) && (tabuleiroJogo[2][0].equals(jogadorDaVez))) {
			verificador = true;
		}
		
		
		
		return verificador;
		
	}
	
	public static String mostrarTabuleiro() {
		
		String tabuleiro = "";
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				tabuleiro += tabuleiroJogo[i][j] + "   ";
			}
			tabuleiro += "\n";
		}
		
		return tabuleiro;
		
	}

}
