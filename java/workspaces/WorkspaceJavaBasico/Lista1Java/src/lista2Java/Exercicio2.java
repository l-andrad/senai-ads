package lista2Java;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		
		/* Escreva um programa que receba quatro notas do aluno e as insira em um vetor. 
		 * Depois, calcule a média aritmética entre as quatro notas e mostre o "conceito" do aluno conforme as instruções: 
		 * 9.0 ou maior = Conceito A
		 * entre 8.0 e 8.9 = Conceito B
		 * entre 7.0 e 7.9 = Conceito C
		 * menor que 7.0 = Conceito D */
		
		
		double[] notas = new double[4];
		double media = 0;
		DecimalFormat df = new DecimalFormat("0.0");
		
		for(int i=0; i<4; i++) {
			notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe a " + (i + 1) + "ª nota: "));
			while((notas[i] < 0) || (notas[i] > 10)) {
				notas[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Nota inválida, informe outra: "));
			}
		}
		
		media = (notas[0] + notas[1] + notas[2] + notas[3]) / 4;
		
		if(media >= 9) {
			JOptionPane.showMessageDialog(null, "Sua média foi " + df.format(media) + "\nParabéns, você tirou o conceito A!");
		} else if((media >= 8) && (media <= 8.9)) {
			JOptionPane.showMessageDialog(null, "Sua média foi " + df.format(media) + "\nParabéns, você tirou o conceito B!");
		}else if((media >= 7) && (media <= 7.9)) {
			JOptionPane.showMessageDialog(null, "Sua média foi " + df.format(media) + "\nVocê tirou o conceito C!");
		}else if(media < 7) {
			JOptionPane.showMessageDialog(null, "Sua média foi " + df.format(media) + "\nVocê tirou o conceito D!");
		}
	}

}
