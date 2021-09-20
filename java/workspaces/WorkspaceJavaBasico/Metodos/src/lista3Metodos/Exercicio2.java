package lista3Metodos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/* Faça um programa que receba as três notas de um aluno 
   e pergunte ao professor qual média ele deseja calcular: 
   aritmética ou ponderada. 
   Se for a média ponderada, os pesos de cada nota devem ser informados.
   
   * Cada média deverá ser calculada por um método;
   * Os dois métodos devem receber como parâmetros as notas;
   * No caso do método da média ponderada, além das notas, 
   	 o método deverá receber também os pesos, 
   	 que devem ser previamente solicitados ao usuário;
   * Os dois métodos devem retornar a média;
   * Um método deve ser criado para receber a média final 
     e mostrar se o aluno está aprovado ou reprovado, 
     considerando que a média mínima para aprovação é 7.
*/

public class Exercicio2 {

	public static void main(String[] args) {
		
		double[] notas = new double[3];
		double mediaFinal = 0;
		String opcaoMedia;
		
		for(int i=0;i<3;i++) {
			
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a " + (i + 1) + "ª nota: "));
			
			while((notas[i] < 0) || (notas[i] > 10)) {
				
				notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota inválida! Informe a " + (i + 1) + "ª nota: "));
				
			}
			
		}
		
		opcaoMedia = JOptionPane.showInputDialog(null, "Qual média você quer calcular?" 
													   + "\nA - Média Aritmética;"
													   + "\nP - Média Ponderada;"
													   + "\nDigite o código correspondente: ");
		
		while((!opcaoMedia.equals("A")) && (!opcaoMedia.equals("P"))){
			
			opcaoMedia = JOptionPane.showInputDialog(null, "Opção inválida! Qual média você quer calcular?" 
					   									   + "\nA - Média Aritmética;"
					   									   + "\nP - Média Ponderada;"
					   									   + "\nDigite o código correspondente: ");
		}
		
		if(opcaoMedia.equals("A")) {
			mediaFinal = mediaAritmetica(notas);
		}else {
			double pesos[] = solicitaPesos();
			mediaFinal = mediaPonderada(notas, pesos);
		}
		
		mostraResultado(mediaFinal);
		
	}
	
	
	
	public static double mediaAritmetica(double[] notas) {
		
		double media, somaNotas = 0;
		
		for(int i=0;i<3;i++) {
			
			somaNotas += notas[i];
			
		}
		
		media = somaNotas / 3;
		
		return media;
		
	}
	
	public static double mediaPonderada(double[] notas, double[] pesos) {
		
		double media = 0, somaNotas = 0, somaPesos = 0;
		
		for(int i=0;i<3;i++) {
					
			somaPesos += pesos[i];
			
		}
		
		for(int i=0;i<3;i++) {
			
			somaNotas += (notas[i] * pesos[i]); 
			
			media = somaNotas / somaPesos;
			
		}
		
		return media;
		
	}



	public static double[] solicitaPesos() {
		
		double pesos[] = new double[3];
		
		for(int i=0;i<3;i++) {
		
		pesos[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o peso da " + (i + 1) + "ª nota: "));
		
		while(pesos[i] < 0) {
			pesos[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Não pode haver peso negativo! Informe o peso da " + (i + 1) + "ª nota: "));
		}
		
		}
		
		return pesos;
		
		
	}
	
	public static void mostraResultado(double mediaFinal) {
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		if(mediaFinal >= 7) {
			JOptionPane.showMessageDialog(null, "Parabéns, você foi aprovado! Média: " + df.format(mediaFinal));
		}else {
			JOptionPane.showMessageDialog(null, "Você foi reprovado! Média: " + df.format(mediaFinal));
		}
		
	}

}
