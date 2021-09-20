package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio5 {

	public static void main(String[] args) {
		
		/* Faça um algoritmo que peça ao usuário 10 números e mostre posteriormente 
		 * quantos são pares e a soma deles, bem como quantos são ímpares e a soma deles.
		 */
		
		int numero, numerosPares = 0, numerosImpares = 0, somaPares = 0, somaImpares = 0;
		
		for(int i=0; i<10; i++) {
			
			numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o " + (i+1) + "º número: "));
			
			if(numero % 2 == 0) {
				numerosPares += 1;
				somaPares += numero;
			}else {
				numerosImpares += 1;
				somaImpares += numero;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Temos " + numerosPares + " números pares e " + numerosImpares + " números impares!");
		JOptionPane.showMessageDialog(null, "A soma dos pares é: " + somaPares);
		JOptionPane.showMessageDialog(null, "A soma dos impares é: " + somaImpares);
		
	}

}
