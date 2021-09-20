package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio1 {
	
	/* Faça um algoritmo que peça para o usuário inserir uma quantidade em horas, 
	 * outra em minutos e mais uma em segundos e mostre quantos segundos esse horário contém.
	 */

	public static void main(String[] args) {
		
		int quantidadeHoras;
		int quantidadeMinutos;
		int quantidadeSegundos;
		int horasEmSegundos; 
		int minutosEmSegundos;
		int somaTotal;
		
		JOptionPane.showMessageDialog(null, "Olá, vamos calcular a quantidade de segundos!");
		quantidadeHoras = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira aqui a quantidade de horas: "));
		quantidadeMinutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Agora insira a quantidade de minutos: "));
		quantidadeSegundos = Integer.parseInt(JOptionPane.showInputDialog(null, "E por fim insira a quantidade de segundos: "));
		
		horasEmSegundos = quantidadeHoras * 3600;
		minutosEmSegundos = quantidadeMinutos * 60;
		somaTotal = horasEmSegundos + minutosEmSegundos + quantidadeSegundos;
		
		JOptionPane.showMessageDialog(null, "Ao total temos," + somaTotal + " segundos!");

	}

}
