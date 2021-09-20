package lista2Java;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		
		/* Escreva um programa que leia um número inteiro e apresente um menu para o usuário escolher:
		 * 1 - Verificar se o número é múltiplo de algum outro número (pedir ao usuário esse número);
		 * 2 - Verificar se o número é par;
		 * 3 - Verificar se o número está entre 0 e 1000;
		 * 4 - Sair
		 * Após as entradas de dados, deve ser mostrado ao usuário o resultado da respectiva opção escolhida, e novamente o menu. 
		 * Para a opção “4- Sair”, utilize System.exit(0); */
		
		int numero, multiplo, opcao;
		
		
		
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe um número: "));
		
		do {
		
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de uma das opções" 
											+ "\n 1 - Verificar se o número é múltiplo de algum outro número"
											+ "\n 2 - Verificar se o número é par"
											+ "\n 3 - Verificar se o número está entre 0 e 1000"
											+ "\n 4 - Sair"));
		
		
		while((opcao < 1) || (opcao > 4)) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Número inválido!" 
					+ "\nDigite o número de uma das opções" 
					+ "\n 1 - Verificar se o número é múltiplo de algum outro número"
					+ "\n 2 - Verificar se o número é par"
					+ "\n 3 - Verificar se o número está entre 0 e 1000"
					+ "\n 4 - Sair"));
		}
		
		
		switch(opcao) {
		case 1: 
			multiplo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe com qual número deseja saber se " + numero + " é múltiplo: "));
			if(numero % multiplo == 0) {
				JOptionPane.showMessageDialog(null, "O número " + numero + " é múltiplo de " + multiplo + "!");
			}else {
				JOptionPane.showMessageDialog(null, "O número " + numero + " não é múltiplo de " + multiplo + "!");
			}
		break;
		case 2:
			if(numero % 2 == 0) {
				JOptionPane.showMessageDialog(null, "Este número é par!");
			}else {
				JOptionPane.showMessageDialog(null, "Este número não é par!");
			}
		break;
		case 3:
			if((numero >= 0) && (numero <= 1000)) {
				JOptionPane.showMessageDialog(null, "Este número está entre 0 e 1000!");
			}else {
				JOptionPane.showMessageDialog(null, "Este número não está entre 0 e 1000!");
			}
		break;
		case 4:
			System.exit(0);
		break;
		
			}
		}while(opcao != 4);
		
	}

}
