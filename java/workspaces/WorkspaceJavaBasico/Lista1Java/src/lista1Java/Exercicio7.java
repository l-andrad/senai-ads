package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio7 {

	public static void main(String[] args) {
		
		/* Faça uma solução que alimente um vetor com 10 valores inteiros e também 
		 * que solicite ao usuário a entrada de dados de um valor inteiro qualquer. 
		 * A solução deverá fazer uma busca do valor, informado pelo usuário, no vetor 
		 * e imprima a posição em que este foi encontrado ou se não foi encontrado.
		 */
		
		int[] numeros = new int[10];
		int numeroBusca;
		boolean verificador = false;
		
		for (int i=0; i<10; i++) {
			
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o " + (i + 1) + "º número inteiro: "));
					
		}
		
		numeroBusca = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o número que deseja busca: "));
		
		for (int i=0; i<10; i++) {
			if (numeros[i] == numeroBusca) {
				
				JOptionPane.showMessageDialog(null, "Este número está na " + (i+1) + "ª posição do vetor!");
				verificador = true;
				
			}
			
		}
		
		if(verificador == false) {
			JOptionPane.showMessageDialog(null, "Este número não está no vetor!");
		}
	}

}
