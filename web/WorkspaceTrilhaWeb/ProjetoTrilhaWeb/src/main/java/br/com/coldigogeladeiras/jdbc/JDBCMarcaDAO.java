package br.com.coldigogeladeiras.jdbc;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import br.com.coldigogeladeiras.jdbcinterface.MarcaDAO;
import br.com.coldigogeladeiras.modelo.Marca;

public class JDBCMarcaDAO implements MarcaDAO {

    private Connection conexao;

    public JDBCMarcaDAO(Connection conexao) {
            this.conexao = conexao;
    }
    
    public List<Marca> buscar() {
        
        //Criação da instrução SQL para busca de todas as marcas 
        String comando = "SELECT * FROM marcas";
        
        //Criação de uma lista para armazenar cada marca encontrada
        List<Marca> listMarcas = new ArrayList<Marca>();
        
        //Criação do objeto marca com valor null (ou seja, sem instanciá-lo)
        Marca marca = null;
        
        //Abertura do try-catch
        try {
                
                //Uso da conexÃ£o do banco para preparÃ¡-lo para uma instruÃ§Ã£o SQL
                Statement stmt = conexao.createStatement(); 
                
                //ExecuÃ§Ã£o da instruÃ§Ã£o criada previamente 
                //e armazenamento do resultado no objeto rs 
                ResultSet rs = stmt.executeQuery(comando);
                
                //Enquanto houver uma prÃ³xima linha no resultado
                while (rs.next()) {
                        
                        //CriaÃ§Ã£o de instÃ¢ncia da classe Marca   
                        marca = new Marca();
                        
                        //Recebimento dos 2 dados retornados do BD para cada linha encontrada
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        
                        //Setando no objeto marca os valores encontrados
                marca.setId(id);
                marca.setNome(nome);
                                                
                //AdiÃ§Ã£o da instÃ¢ncia contida no objeto Marca na lista de marcas
                        listMarcas.add(marca);
                }
                
        //Caso alguma Exception seja gerada no try, recebe-a no objeto "ex"        
        } catch (Exception ex) {
                //Exibe a exceÃ§Ã£o na console
                ex.printStackTrace();
        }                
        
        //Retorna para quem chamou o mÃ©todo a lista criada
        return listMarcas;
        
} 
    
    public boolean inserir(Marca marca) {
    	
    	String comando = "INSERT INTO marcas "
    			+ "(nome) VALUES (?)";
    	PreparedStatement p;
    	
    	try {
    		
    		p = this.conexao.prepareStatement(comando);
    		
    		p.setString(1, marca.getNome());
    		
    		p.execute();
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }

   public List<Marca> buscarPorMarca(String nome) {
            
    		
    		//Criação da instrução SQL para busca de todas as marcas 
            String comando = "SELECT * FROM marcas";
            
            if(!nome.equals("")) {
            	comando += " WHERE marcas.nome LIKE '%" + nome + "%'";
            }
            
            comando += " ORDER BY marcas.nome ASC";
            
            //Criação de uma lista para armazenar cada marca encontrada
            List<Marca> listaMarcas = new ArrayList<Marca>();
            
            //Criação do objeto marca com valor null (ou seja, sem instanciá-lo)
            Marca marca = null;
            
            //Abertura do try-catch
            try {
                    
                    //Uso da conexÃ£o do banco para preparÃ¡-lo para uma instruÃ§Ã£o SQL
                    Statement stmt = conexao.createStatement(); 
                    
                    //ExecuÃ§Ã£o da instruÃ§Ã£o criada previamente 
                    //e armazenamento do resultado no objeto rs 
                    ResultSet rs = stmt.executeQuery(comando);
                    
                    //Enquanto houver uma prÃ³xima linha no resultado
                    while (rs.next()) {
                            
                            //CriaÃ§Ã£o de instÃ¢ncia da classe Marca   
                            marca = new Marca();
                            
                            //Recebimento dos 2 dados retornados do BD para cada linha encontrada
                            int id = rs.getInt("id");
                            String nomeMarca = rs.getString("nome");
                            
                            //Setando no objeto marca os valores encontrados
                    marca.setId(id);
                    marca.setNome(nomeMarca);
                                                    
                    //AdiÃ§Ã£o da instÃ¢ncia contida no objeto Marca na lista de marcas
                            listaMarcas.add(marca);
                    }
                    
            //Caso alguma Exception seja gerada no try, recebe-a no objeto "ex"        
            } catch (Exception e) {
                    //Exibe a exceÃ§Ã£o na console
                    e.printStackTrace();
            }                
            
            //Retorna para quem chamou o mÃ©todo a lista criada
            return listaMarcas;
            
    }
   
   public Marca buscarPorId(int id) {
	   
	   String comando = "SELECT * FROM marcas WHERE marcas.id = ?";
	   Marca marca = new Marca();
	   
	   try {
		   PreparedStatement p = this.conexao.prepareStatement(comando);
		   p.setInt(1, id);
		   ResultSet rs = p.executeQuery();
		   while(rs.next()) {
			   
			   String nome = rs.getString("nome");
			   
			   marca.setId(id);
			   marca.setNome(nome);
			   
		   }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return marca;
   }
   
   public boolean alterar(Marca marca) {
	   
	   String comando = "UPDATE marcas "
			   + "SET nome=? WHERE id=?";
	   PreparedStatement p;
	   try {
		   p = this.conexao.prepareStatement(comando);
		   p.setString(1, marca.getNome());
		   p.setInt(2, marca.getId());
		   p.executeUpdate();
	   }catch (SQLException e) {
		   e.printStackTrace();
		   return false;
	   }
	   return true;
   }
   
   public boolean deletar(int id) {
	   String comando = "DELETE FROM marcas WHERE id = ?";
	  
	   PreparedStatement p;
	   
	   try {
		   p = this.conexao.prepareStatement(comando);
		   p.setInt(1, id);
		   p.execute();
	   }catch(SQLException e) {
		   e.printStackTrace();	  
		   return false;
	   }
	   
	   return true;
   }
    
}
