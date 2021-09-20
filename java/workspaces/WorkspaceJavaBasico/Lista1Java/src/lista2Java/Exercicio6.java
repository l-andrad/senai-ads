package lista2Java;

import javax.swing.JOptionPane;

import java.text.DecimalFormat;

public class Exercicio6 {

	public static void main(String[] args) {
		
		/* Faça um programa que solicite alguns dados dos usuários que frequentam um clube. 
		   O programa deve solicitar a idade, se a pessoa é fumante ou não (1- SIM, 2- NÃO), 
		   seu salário líquido e há quanto tempo frequenta o clube (em meses). 
		   O usuário deverá digitar “encerrar” quando não tiver mais pessoas para registrar.  
		   Como dados de saída, o programa deve exibir:
		  
		   * A média das idades das pessoas;
		   * A média salarial das pessoas;
		   * Quantos são fumantes e quantos não são fumantes;
		   * A porcentagem de pessoas que frequentam o clube há mais de 03 meses. 
		 */

		int idade, perguntaFumante, fumante = 0, naoFumante = 0, quantidadeMeses, counter = 0, somaIdade = 0, quantidade3Meses = 0;
		double salario, mediaIdade, mediaSalario, porcentagemFrequentantes, somaSalario = 0;
		String opcao;
		DecimalFormat df = new DecimalFormat("0.00");
		
		do {
		idade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a sua idade: "));
		
		perguntaFumante = Integer.parseInt(JOptionPane.showInputDialog(null, "Você é fumante? (1 - SIM, 2 - NÃO)"));
		
		while((perguntaFumante != 1) && (perguntaFumante != 2)) {
			
			perguntaFumante = Integer.parseInt(JOptionPane.showInputDialog(null, "Resposta inválida!" 
																				+ "\nVocê é fumante? (1 - SIM, 2 - NÃO)"));
		}
		
		if(perguntaFumante == 1) {
			fumante += 1;
		}else if(perguntaFumante == 2) {
			naoFumante += 1;
		}
		
		salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o seu salário líquido: "));
		
		quantidadeMeses = Integer.parseInt(JOptionPane.showInputDialog(null, "Há quantos meses você frequenta o clube? "));
		
		if(quantidadeMeses >= 3) {
			quantidade3Meses += 1;
		}
		
		counter += 1;
		
		somaIdade += idade;
		
		somaSalario += salario;
		
		opcao = JOptionPane.showInputDialog(null, "Digite sim para registrar outra pessoa, ou encerrar para finalizar: ");
		
		
		}while(opcao.equals("encerrar") == false);
		
		mediaIdade = somaIdade / counter;
		
		mediaSalario = somaSalario / counter;
		
		porcentagemFrequentantes = (quantidade3Meses * 100) / counter;
		
		JOptionPane.showMessageDialog(null, "A média das idades é: " + df.format(mediaIdade));
		
		JOptionPane.showMessageDialog(null, "A média salarial é: R$" + df.format(mediaSalario));
		
		JOptionPane.showMessageDialog(null, "Temos no total " + counter + " de pessoas sendo que " + fumante + " são fumantes e " + naoFumante + " não são fumantes!");
		
		JOptionPane.showMessageDialog(null, porcentagemFrequentantes + "% das pessoas frequentam o clube a mais de 03 meses!");
		
		
	}

}
