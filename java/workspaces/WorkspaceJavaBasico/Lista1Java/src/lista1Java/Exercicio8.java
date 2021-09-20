package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio8 {

	public static void main(String[] args) {
		
		/* Faça um programa que carregue os valores das vendas de uma loja no primeiro semestre do ano. 
		 * Considere para tal uma matriz [6,4], sendo que são 06 meses e 04 semanas por mês. 
		 * Ao final, mostre na tela: 
		● Total de vendas do semestre
		● Total vendido em cada mês
		*/

		
		float[][] matrizVendas = new float[6][4];
		float vendasSemestre = 0;
		float[] vendasMes = new float[6];
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				matrizVendas[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ganho da " + (j + 1) + "ª semana do " + (i + 1) + "º mês: "));
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				vendasSemestre += matrizVendas[i][j];
			}
		}
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<4; j++) {
				vendasMes[i] += matrizVendas[i][j];
			}
		}
		
		JOptionPane.showMessageDialog(null, "No semestre vendemos ao total: R$" + vendasSemestre);
		JOptionPane.showMessageDialog(null, "Total de vendas por mês." + "\n");
		for(int i=0; i<6; i++) {
			JOptionPane.showMessageDialog(null, + (i + 1) + "º mês: R$" + vendasMes[i]);
		}
		
	}

}
