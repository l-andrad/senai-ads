package lista2Java;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Exercicio7 {

	public static void main(String[] args) {
		
		/* Uma empresa deseja saber alguns dados sobre suas vendas no passado. 
		   Faça um programa que armazene em um vetor o valor total das vendas de 
		   cada um dos 12 meses do ano (que deverá ser informado pelo usuário) e mostre:
		 
		   * O mês com a maior venda;
		   * O mês com a menor venda;
		   * A média das vendas do ano todo;
		   * A média das vendas dos meses pares;
		   * A média das vendas do 2º semestre.
		 */
		
		double[] vendasTotalMeses = new double[12];
		int counterPars = 0, counterSegundoSemestre = 0, maiorMesVendas, menorMesVendas;
		double mediaVendas = 0, mediaMesesPares, mediaSegundoSemestre, somaVendas = 0, somaVendasPares = 0, somaVendasSegundoSemestre = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(int i=0; i<12; i++) {
			vendasTotalMeses[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor total de vendas do " + (i + 1) + "º mês: "));
			
			while(vendasTotalMeses[i] < 0) {
				vendasTotalMeses[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor inválido!" 
																							+ "\n Insira o valor total de vendas do " + (i + 1) + "º mês: "));
			}
			somaVendas += vendasTotalMeses[i];
			
			if((i+1) % 2 == 0) {
				somaVendasPares += vendasTotalMeses[i];
				counterPars += 1;
			}
			
			if((i+1) >= 7) {
				somaVendasSegundoSemestre += vendasTotalMeses[i];
				counterSegundoSemestre += 1;
			}
		}
		
		maiorMesVendas = 11;
		menorMesVendas = 11;
		
		for(int i=0; i<12; i++) {
			if(vendasTotalMeses[i] >= vendasTotalMeses[maiorMesVendas]) {
				maiorMesVendas = i;
			}
		}
		
		for(int i=0; i<12; i++) {
			if(vendasTotalMeses[i] <= vendasTotalMeses[menorMesVendas]) {
				menorMesVendas = i;
			}
		}
		
		mediaVendas = somaVendas / 12;
		
		mediaMesesPares = somaVendasPares / counterPars;
		
		mediaSegundoSemestre = somaVendasSegundoSemestre / counterSegundoSemestre;
		
		JOptionPane.showMessageDialog(null, "Com R$" + df.format(vendasTotalMeses[maiorMesVendas]) + " o " + (maiorMesVendas + 1) + "º mês foi o maior em vendas!");
		
		JOptionPane.showMessageDialog(null, "Com R$" + df.format(vendasTotalMeses[menorMesVendas]) + " o " + (menorMesVendas + 1) + "º mês foi o menor em vendas!");
		
		JOptionPane.showMessageDialog(null, "A média de vendas do ano foi de R$" + df.format(mediaVendas));
		
		JOptionPane.showMessageDialog(null, "A média de vendas dos meses pares foi de R$" + df.format(mediaMesesPares));
		
		JOptionPane.showMessageDialog(null, "A média de vendas do 2º semestre foi de R$" + df.format(mediaSegundoSemestre));
		
	}

}
