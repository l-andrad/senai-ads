package br.com.coldigogeladeiras.jdbcinterface;

import java.util.List;

import br.com.coldigogeladeiras.modelo.Marca;

public interface MarcaDAO {
    
	public int inserir(Marca marca);
	public List<Marca> buscar();
    public List<Marca> buscarPorMarca(String nome);
    public Marca buscarPorId(int id);
    public boolean alterar(Marca marca);
    //public boolean deletar(int id);
    public int deletarCompleto(int id);
    public int statusChange(int id);

}
