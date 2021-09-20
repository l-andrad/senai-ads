package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		
		/* Desenvolva um programa que pergunte qual é a maioridade civil do seu “estado/país” 
		 * e que posteriormente o usuário informe sua idade. 
		 * Como resultado, o programa deve informar se ele é ou não maior de idade.
		 */
		
		int idadeUsuario, maioridadePais;
		
		JOptionPane.showMessageDialog(null, "Olá, vamos ver se você é maior de idade!");
		maioridadePais = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira a maioridade do seu estado/país: "));
		idadeUsuario = Integer.parseInt(JOptionPane.showInputDialog("Agora insira a sua idade: "));
		
		if (idadeUsuario >= maioridadePais) {
			JOptionPane.showMessageDialog(null, "Você é maior de idade de acordo com a lei do seu estado/país! =)");
		
		} else {
			JOptionPane.showMessageDialog(null, "Você é menor de idade ainda! :/");
		}
		
	}

}
