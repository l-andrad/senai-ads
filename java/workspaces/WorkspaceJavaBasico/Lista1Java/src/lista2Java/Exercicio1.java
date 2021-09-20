package lista2Java;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Exercicio1 {

	public static void main(String[] args) {
		
		/* Faça um programa que receba um vetor de valores e mostre a quantidade de  
		 * valores negativos. Os valores e o tamanho do vetor devem ser informados pelo usuário.
		 */
		
		int n, quantidadeNumerosNegativos = 0;
		
		n = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade de números: "));
		
		double[] valores = new double[n];
		
		for(int i=0; i<n; i++) {
			valores[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o " + (i + 1) + "º número: "));
			if(valores[i] < 0) {
				quantidadeNumerosNegativos += 1;
			}
		}
		
		if(quantidadeNumerosNegativos > 0) {
			JOptionPane.showMessageDialog(null, "Ao todo temos " + quantidadeNumerosNegativos + " números negativos!");
		}else {
			JOptionPane.showMessageDialog(null, "Não há nenhum número negativo!");
		}
		
		
	}

}
