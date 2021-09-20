package lista2Java;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Exercicio4 {

	public static void main(String[] args) {
		
		/* Sabe-se que o latão é constituído de 70% de cobre e 30% de zinco. 
		 * Faça um programa que permita ao usuário informar 
		 * uma quantidade de latão em quilos e forneça o total 
		 * de cobre e zinco necessários para fabricar essa quantidade.
		 */
		
		double quantidadeQuilos, quantidadeZinco, quantidadeCobre;
		DecimalFormat df = new DecimalFormat("0.00");
		
		quantidadeQuilos = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe quantos quilos de latão deseja fabricar: "));
		
		quantidadeZinco = (quantidadeQuilos * 0.3);
		quantidadeCobre = (quantidadeQuilos * 0.7);
		
		JOptionPane.showMessageDialog(null, "Para fabricar " + df.format(quantidadeQuilos) + "kg de latão, você irá precisar de " + df.format(quantidadeCobre) + "kg de cobre e "
											+ df.format(quantidadeZinco) + "kg de zinco.");
		
	}

}
