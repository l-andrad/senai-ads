package lista3Metodos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

/* Faça um programa que a partir do valor de uma compra, 
  faça o cálculo de um desconto para o usuário. 
  O programa deve solicitar o valor total da compra 
  por meio de um método, que deverá retorná-lo. 
  Um método deve ser criado para receber o valor 
  da compra e mostrar o valor final com desconto, considerando:
 
  * Até R$100 - sem desconto, o valor permanece o mesmo
  * De R$100,01 a R$200 - desconto de 20%
  * Acima de R$200 - desconto de 30%
*/

public class Exercicio3 {

	public static void main(String[] args) {
		
		double valorCompra;
		
		valorCompra = solicitaValor();
		
		mostraValorFinal(valorCompra);
		
	}
	
	public static double solicitaValor() {
		
		double valorCompra;
		
		valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor total da compra: "));
		
		while(valorCompra < 0) {
			
			valorCompra = Double.parseDouble(JOptionPane.showInputDialog("Valor inválido! Informe o valor total da compra: "));
			
		}
		
		return valorCompra;
		
	}
	
	public static void mostraValorFinal(double valorCompra) {
		
		double valorFinal = 0;
		DecimalFormat df = new DecimalFormat("0.00");
		
		if(valorCompra <= 100) {
			
			valorFinal = valorCompra;
			
		}else if((valorCompra > 100) && (valorCompra <= 200)) {
			
			valorFinal = valorCompra - (valorCompra * 0.2);
			
		}else if(valorCompra > 200) {
			
			valorFinal = valorCompra - (valorCompra * 0.3);
			
		}
		
		JOptionPane.showMessageDialog(null, "O valor final da compra é: R$" + df.format(valorFinal));
		
	}

}
