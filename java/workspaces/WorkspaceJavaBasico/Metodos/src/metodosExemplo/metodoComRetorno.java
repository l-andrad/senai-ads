package metodosExemplo;

public class metodoComRetorno {

	public static void main(String[] args) {
		
		int a = 2;
		int quadrado;
		quadrado = calculaQuadrado(a);
		System.out.println(quadrado);
		
	}
	
	static int calculaQuadrado(int a) {
		return a*a;
	}

}
