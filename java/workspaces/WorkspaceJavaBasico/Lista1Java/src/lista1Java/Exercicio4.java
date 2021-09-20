package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio4 {

	public static void main(String[] args) {
		
		/* Faça um algoritmo que mostre a soma de todos os 
		 * valores pares entre o intervalo de dois números digitados pelo usuário.
		 */
		
		int num1, num2, somaPares = 0;
		
		num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira um número inteiro: "));
		num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira outro número inteiro: "));
		
		
		if (num1 < num2) {
			for(int i=num1; i<=num2; i++) {
				if(i % 2 == 0) {
					somaPares += i;
				}
			}
		}else {
			if(num1 > num2) {
				for(int i=num2; i<=num1; i++) {
					if(i % 2 == 0) {
						somaPares += i;
					}
				}
			}
		}
		
		if(somaPares == 0) {
			
			JOptionPane.showMessageDialog(null, "Não existe números pares neste intervalo!");
			
		}else {
			JOptionPane.showMessageDialog(null, "Neste intervalo a soma dos números pares é: " + somaPares);
		}
		
	}

}
