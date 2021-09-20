package lista1Java;

import javax.swing.JOptionPane;

public class Exercicio6 {

	public static void main(String[] args) {
		
		/* Crie uma calculadora que permita o cálculo de uma equação, sem limite de execuções definido, da seguinte maneira:
		1. Peça o primeiro valor ,
		2. Peça o cálculo que deseja fazer (entre as 4 operações básicas),
		3. Peça um segundo valor 
		4. Efetue o cálculo,
		5. Peça se o usuário quer continuar calculando. Se ele responder que sim, volte para o passo 2 usando o resultado do cálculo da linha 4 como primeiro valor, e se disser que não, mostre o resultado final . 
		Exemplo de uso para o algoritmo: 4 + 3 = 7 x 4 = 28 / 14 = 2. */

		
		String respostaOpcao, respostaOperador;
		char opcao, operador;
		float num1, num2, resultado = 0;
		
		JOptionPane.showMessageDialog(null, "Olá, vamos fazer cálculos!");
		num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o primeiro número: "));
		
		do {
			
			respostaOperador = JOptionPane.showInputDialog(null, "Operações:" 
					+ "\n (+) Soma"
					+ "\n (-) Subtração"
					+ "\n (*) Multiplicação"
					+ "\n (/) Divisão"
					+ "\n\n Insira o operador: ");
			num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira mais um número: "));
			
			operador = respostaOperador.charAt(0);
			
			switch(operador) {
			
			case '+': 
				resultado = num1 + num2;
			break;
			
			case '-': 
				resultado = num1 - num2;
			break;
			
			case '*': 
				resultado = num1 * num2;
			break;
			
			case '/': 
				if((num2 > 0) || (num2 < 0)) {
					resultado = num1 / num2;
				}else {
					
					JOptionPane.showMessageDialog(null, "Não pode ser feito divisão por zero!");
				
				}
			break;
			
			default: 
				JOptionPane.showMessageDialog(null, "Operador inválido!");
			break;
			
			}
			
			num1 = resultado;
			
			respostaOpcao = JOptionPane.showInputDialog(null, "Deseja continuar o cálculo? s - Sim, n - não ");
					
			opcao = respostaOpcao.charAt(0);
			
		}while((opcao == 'S') || (opcao == 's')); 
		
		JOptionPane.showMessageDialog(null, "O resultado final é: " + resultado);
		
	}

}
