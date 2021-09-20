package lista2Java;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Exercicio8 {

	public static void main(String[] args) {
		
	/*   Um estudante do ensino médio gostaria de controlar melhor suas notas nas disciplinas exatas. 
		 Ele gostaria de poder enxergar suas notas dos 4 bimestres com exatamente duas casas decimais 
		 e em formato de matriz, como no exemplo a seguir:
		  
		 Além disso, o estudante gostaria de poder escolher algumas opções de visualização de acordo com o menu abaixo:
		 * Todas as notas de todas as disciplinas;
		 * A maior nota e em qual disciplina;
		 * A menor nota e em qual disciplina;
		 * A média das notas de alguma disciplina (solicitar qual);
		 * As notas de um dos bimestres (solicitar qual);
		 * Encerrar.
		 Faça um programa que permita cadastrar as notas de acordo com o exemplo 
		 (considerando a ordem das disciplinas) e forneça os dados supracitados. 
		 O menu deve ser exibido repetitivamente, até que o usuário deseje encerrar o programa.
		 */
		
		double[][] notas = new double[4][3];
		int opcaoDisciplina, opcaoBimestre, maiorNotaLinha, maiorNotaColuna, menorNotaLinha, menorNotaColuna, opcao;
		double mediaNotasDisciplina = 0, somaNotasDisciplina = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		String notasTabela = "";
		
		for(int i=0; i<4; i++) {
			
				notas[i][0] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a nota do " + (i + 1) + "º bimestre em matemática: "));
				
				while((notas[i][0] < 0) || (notas[i][0] > 10)) {
					notas[i][0] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota inválida!"
																					   + "\nInforme a nota do " + (i + 1) + "º bimestre em matemática: "));
				}
				
		}
		
		for(int i=0; i<4; i++) {
			
			notas[i][1] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a nota do " + (i + 1) + "º bimestre em física: "));
			
			while((notas[i][1] < 0) || (notas[i][1] > 10)) {
				notas[i][1] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota inválida!"
																				   + "\nInforme a nota do " + (i + 1) + "º bimestre em física: "));
			}
	
		}
		
		for(int i=0; i<4; i++) {
			
			notas[i][2] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a nota do " + (i + 1) + "º bimestre em química: "));
			
			while((notas[i][2] < 0) || (notas[i][2] > 10)) {
				notas[i][2] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota inválida!"
																				   + "\nInforme a nota do " + (i + 1) + "º bimestre em química: "));
			}
			
		}
		
		do {
			notasTabela = " ";
			somaNotasDisciplina = 0;
			mediaNotasDisciplina = 0;
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Opções de visualização." 
																		+ "\n1 - Todas as notas de todas as disciplinas;" 
																		+ "\n2 - A maior nota e em qual disciplina;" 
																		+ "\n3 - A menor nota e em qual disciplina;"
																		+ "\n4 - A média das notas de alguma disciplina;"
																		+ "\n5 - As notas de um dos bimestres;"
																		+ "\n6 - Encerrar;"
																		+ "\nEscolha uma das opção que deseja e informe o código numérico: "));
			while((opcao < 1) || (opcao > 6)) {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Opção inválida!" 
																			+ "\n1 - Todas as notas de todas as disciplinas;" 
																			+ "\n2 - A maior nota e em qual disciplina;" 
																			+ "\n3 - A menor nota e em qual disciplina;"
																			+ "\n4 - A média das notas de alguma disciplina;"
																			+ "\n5 - As notas de um dos bimestres;"
																			+ "\n6 - Encerrar;"
																			+ "\nEscolha uma das opção que deseja e informe o código numérico: "));
			}
			
			switch(opcao) {
			case 1:
				for(int i=0; i<4; i++) {
					for(int j=0; j<3; j++) {
						notasTabela += notas[i][j] + " ";
					}
					notasTabela += "\n";
				}
				
				JOptionPane.showMessageDialog(null, notasTabela);
			break;
			
			case 2:
				maiorNotaLinha = 3;
				maiorNotaColuna = 2;
				
				for(int i=0; i<4; i++) {
					for(int j=0; j<3; j++) {
						if(notas[i][j] >= notas[maiorNotaLinha][maiorNotaColuna]) {
							maiorNotaLinha = i;
							maiorNotaColuna = j;
						}
					}
				}
				if(maiorNotaColuna == 0) {
					JOptionPane.showMessageDialog(null, "A sua maior nota foi " + df.format(notas[maiorNotaLinha][maiorNotaColuna]) + " em matemática no " + (maiorNotaLinha + 1) + "º bimestre!");
				}else if(maiorNotaColuna == 1) {
					JOptionPane.showMessageDialog(null, "A sua maior nota foi " + df.format(notas[maiorNotaLinha][maiorNotaColuna]) + " em física no " + (maiorNotaLinha + 1) + "º bimestre!");
				}else if(maiorNotaColuna == 2) {
					JOptionPane.showMessageDialog(null, "A sua maior nota foi " + df.format(notas[maiorNotaLinha][maiorNotaColuna]) + " em química no " + (maiorNotaLinha + 1) + "º bimestre!");
				}
			break;
			
			case 3:
				menorNotaLinha = 3;
				menorNotaColuna = 2;
				
				for(int i=0; i<4; i++) {
					for(int j=0; j<3; j++) {
						if(notas[i][j] <= notas[menorNotaLinha][menorNotaColuna]) {
							menorNotaLinha = i;
							menorNotaColuna = j;
						}
					}
				}
				if(menorNotaColuna == 0) {
					JOptionPane.showMessageDialog(null, "A sua menor nota foi " + df.format(notas[menorNotaLinha][menorNotaColuna]) + " em matemática no " + (menorNotaLinha + 1) + "º bimestre!");
				}else if(menorNotaColuna == 1) {
					JOptionPane.showMessageDialog(null, "A sua menor nota foi " + df.format(notas[menorNotaLinha][menorNotaColuna]) + " em física no " + (menorNotaLinha + 1) + "º bimestre!");
				}else if(menorNotaColuna == 2) {
					JOptionPane.showMessageDialog(null, "A sua menor nota foi " + df.format(notas[menorNotaLinha][menorNotaColuna]) + " em química no " + (menorNotaLinha + 1) + "º bimestre!");
				}
			break;
			
			case 4:
				opcaoDisciplina = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual disciplina deseja saber a média?" 
																					 + "\n1 - Matemática;"
																					 + "\n2 - Física;"
																					 + "\n3 - Química;"
																					 + "\nInforme o código da disciplina: "));
				while((opcaoDisciplina < 1) || (opcaoDisciplina > 3)) {
					opcaoDisciplina = Integer.parseInt(JOptionPane.showInputDialog(null, "Código inválido!" 
							 															 + "\n1 - Matemática;"
							 															 + "\n2 - Física;"
							 															 + "\n3 - Química;"
							 															 + "\nInforme o código da disciplina: "));
				}
				
				if((opcaoDisciplina - 1) == 0) {
					for(int i=0; i<4; i++) {
						somaNotasDisciplina += notas[i][0];
					}
					mediaNotasDisciplina = somaNotasDisciplina / 4;
					JOptionPane.showMessageDialog(null, "Sua média em matemática foi: " + df.format(mediaNotasDisciplina));
				}else if((opcaoDisciplina - 1) == 1) {
					for(int i=0; i<4; i++) {
						somaNotasDisciplina += notas[i][1];
					}
					mediaNotasDisciplina = somaNotasDisciplina / 4;
					JOptionPane.showMessageDialog(null, "Sua média em física foi: " + df.format(mediaNotasDisciplina));
				}else if((opcaoDisciplina - 1) == 2) {
					for(int i=0; i<4; i++) {
						somaNotasDisciplina += notas[i][2];
					}
					mediaNotasDisciplina = somaNotasDisciplina / 4;
					JOptionPane.showMessageDialog(null, "Sua média em química foi: " + df.format(mediaNotasDisciplina));
				}
			break;
			
			case 5:
				opcaoBimestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja ver as notas de qual bimestre?" 
						 														   + "\n1º Bimestre;"
						 														   + "\n2º Bimestre;"
						 														   + "\n3º Bimestre;"
						 														   + "\n4º Bimestre;"
						 														   + "\nInforme o número do bimestre correspondente: "));
				while((opcaoBimestre < 1) || (opcaoBimestre > 4)) {
					opcaoBimestre = Integer.parseInt(JOptionPane.showInputDialog(null, "Número inválido!" 
							   														   + "\n1º Bimestre;"
							   														   + "\n2º Bimestre;"
							   														   + "\n3º Bimestre;"
							   														   + "\n4º Bimestre;"
							   														   + "\nInforme o número do bimestre correspondente: "));
				}
				switch(opcaoBimestre) {
				case 1:
					
					for(int j=0; j<3; j++) {
					notasTabela += notas[0][j] + "\n";
					}
					JOptionPane.showMessageDialog(null, "As notas do 1º bimestre são: " 
														+ "\n" + notasTabela);
				break;
				
				case 2:
					
					for(int j=0; j<3; j++) {
					notasTabela += notas[1][j] + "\n";
					}
					JOptionPane.showMessageDialog(null, "As notas do 2º bimestre são: " 
														+ "\n" + notasTabela);
				break;
				
				case 3:
					
					for(int j=0; j<3; j++) {
					notasTabela += notas[2][j] + "\n";
					}
					JOptionPane.showMessageDialog(null, "As notas do 3º bimestre são: " 
													  + "\n" + notasTabela);
				break;
				
				case 4:
					
					for(int j=0; j<3; j++) {
					notasTabela += notas[3][j] + "\n";
					}
					JOptionPane.showMessageDialog(null, "As notas do 4º bimestre são: " 
														+ "\n" + notasTabela);
				break;
				
			}
			break;
				
			
				
			}
		}while(opcao != 6);
		
		
	}

}
