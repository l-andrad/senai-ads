package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		
		/* Faça um programa que peça ao usuário para informar 03 números 
		 * e mostre o menor entre eles. Considere que o usuário não poderá informar números iguais.
		 */
		
		int[] numeros = new int[3];
		
		for (int i=0; i<3; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o " + (i + 1) + "º número: "));
		}
		
		if(((numeros[0] < numeros[1]) && (numeros[0] < numeros[2])) && ((numeros[0] != numeros[1]) && (numeros[0] != numeros[2]) && (numeros[1] != numeros[2]))) {
			
			
			JOptionPane.showMessageDialog(null, "O número " + numeros[0] + " é o menor número dentre os três!");
		
		
		}else if(((numeros[1] < numeros[0]) && (numeros[1] < numeros[2])) && ((numeros[0] != numeros[1]) && (numeros[0] != numeros[2]) && (numeros[1] != numeros[2]))) {
			
			JOptionPane.showMessageDialog(null, "O número " + numeros[1] + " é o menor número dentre os três!");
		
			}else if (((numeros[2] < numeros[0]) && (numeros[2] < numeros[1])) && ((numeros[0] != numeros[1]) && (numeros[0] != numeros[2]) && (numeros[1] != numeros[2]))) {
				
				JOptionPane.showMessageDialog(null, "O número " + numeros[2] + " é o menor número dentre os três!");	
				
			}else {
				
				JOptionPane.showMessageDialog(null, "Desculpe, você informou números iguais!");
				
			}
	}
}
