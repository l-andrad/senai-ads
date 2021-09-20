package lista3Metodos;

import javax.swing.JOptionPane;

/* Faça um programa que solicite o ano de nascimento 
 * de um usuário e seja mostrada a sua idade em 2020. 
 * Não é necessário considerar se o usuário já fez ou não aniversário. 
 * Um método deve ser criado para solicitar o ano de nascimento 
 * ao usuário e retorná-lo, e outro método deve ser criado para receber 
 * o ano de nascimento, calcular a idade atual e mostrá-la.
 */

public class Exercicio1 {

	public static void main(String[] args) {
		
		int anoNascimento = recebeAnoNascimento();
		
		calculaIdade(anoNascimento);
		
	}
	
	public static  int recebeAnoNascimento() {
		
		int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Informe o seu ano de nascimento:"));
		
		return anoNascimento;
		
	}
	
	public static void calculaIdade(int anoNascimento) {
		
		int idade = 2020 - anoNascimento;
		
		JOptionPane.showMessageDialog(null, "Sua idade em 2020 é " + idade + " anos.");
		
	}

}
