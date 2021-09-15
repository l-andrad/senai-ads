package modelo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import visualizacao.EntradaSaida;

public class Fabrica {
	
	protected ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
	
	
	public void venderCarro() {
		
		String modelo, modeloVender, cor, corVender;
		int ano, anoVender, qtdeCarros, posicaoRemover = -1;
		boolean venda = false;
		Carro atualizar = new Carro();
		
		
		
		qtdeCarros = listaDeCarros.size();
		
		if(qtdeCarros == 0) {
			JOptionPane.showMessageDialog(null, "Não há nenhum carro para vender!");
		}else {
			modeloVender = JOptionPane.showInputDialog(null, "Insira o modelo do carro que quer vender: ");
			corVender = JOptionPane.showInputDialog(null, "Insira a cor do carro que quer vender: ");
			anoVender = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do carro que quer vender: "));
			
			
			for(int i=0; i<qtdeCarros; i++) {
				modelo = listaDeCarros.get(i).getModelo();
				cor = listaDeCarros.get(i).getCor();
				ano = listaDeCarros.get(i).getAno();
				
				if(modeloVender.equals(modelo) && corVender.equals(cor) && anoVender == ano) {
					posicaoRemover = i;
					venda = true;
				}
				
				}
				if(posicaoRemover != -1) {
				listaDeCarros.remove(posicaoRemover);
				}
				
				if(venda == true) {
					JOptionPane.showMessageDialog(null, "Seu carro foi vendido");
				}else {
					JOptionPane.showMessageDialog(null, "Nenhum carro encontrado!");
				}
		}
		
			atualizar.setListaDeCarros(listaDeCarros);
		
	}
	
	public void fabricarCarro() {
		
		int qtdeCarros = EntradaSaida.solicitaQtdCarros();
		Carro atualizar = new Carro();
		
		for(int i=0; i<qtdeCarros; i++) {
				Carro carro = new Carro();
				carro.setModelo(EntradaSaida.solicitaModelo(i+1));
				carro.setCor(EntradaSaida.solicitaCor(i+1));
				carro.setAno(EntradaSaida.solicitaAno(i+1));
				listaDeCarros.add(carro);
		}
		atualizar.setListaDeCarros(listaDeCarros);
			
	}
	
	public ArrayList<Carro> getListaDeCarros(){
		return listaDeCarros;
	}
	
	public String geraInfoCarros() {
			
			String informacoes = null;
			
			informacoes = "Lista de carros: \n";
			
				for(Carro lista : listaDeCarros) {
					String modelo = lista.getModelo();
					String cor = lista.getCor();
					int ano = lista.getAno();
					informacoes += "Modelo: "+modelo+"\nCor: "+cor+"\nAno: "+ano+"\n";
					informacoes += "---------------------------------------------------\n";
			}
			
			return informacoes;	
	}

}
