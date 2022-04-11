package br.com.coldigogeladeiras.rest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;

import br.com.coldigogeladeiras.bd.Conexao;
import br.com.coldigogeladeiras.modelo.Marca;
import br.com.coldigogeladeiras.jdbc.JDBCMarcaDAO;


@Path("marca")
public class MarcaRest extends UtilRest {
	
		@POST
		@Path("/inserir")
		@Consumes("application/*")
		public Response inserir(String marcaParam) {
			
			try {
				Marca marca = new Gson().fromJson(marcaParam, Marca.class);
				Conexao conec = new Conexao();
				Connection conexao = conec.abrirConexao();
				
				JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
				boolean retorno = jdbcMarca.inserir(marca);
				String msg = "";
				
				if(retorno) {
					msg = "Marca cadastrada com sucesso!";
				} else {
					msg = "Erro ao cadastrar marca.";
				}
				
				conec.fecharConexao();
				
				return this.buildResponse(msg);
				
			} catch (Exception e) {
				e.printStackTrace();
				return this.buildErrorResponse(e.getMessage());
			}
		}
        
        @GET
        @Path("/buscarMarca")
        @Consumes("application/*")
        @Produces(MediaType.APPLICATION_JSON)
        public Response buscarPorMarca(@QueryParam("valorBuscaMarca") String nome) {
        	try{        
                        List<Marca> listaMarcas = new ArrayList<Marca>();
                        Conexao conec = new Conexao();
                        Connection conexao = conec.abrirConexao();
                        JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
                        listaMarcas = jdbcMarca.buscarPorMarca(nome);
                        
                        conec.fecharConexao();  
                        
                        return this.buildResponse(listaMarcas);
                }catch(Exception e){
                        e.printStackTrace();
                        return this.buildErrorResponse(e.getMessage());
                }
                
        }
        
        @GET
        @Path("/buscar")
        @Produces(MediaType.APPLICATION_JSON)
        public Response buscar(){
                try{        
                        List<Marca> listaMarcas = new ArrayList<Marca>();
                        
                        Conexao conec = new Conexao();
                        Connection conexao = conec.abrirConexao();
                        JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
                        listaMarcas = jdbcMarca.buscar();
                        conec.fecharConexao();        
                        return this.buildResponse(listaMarcas);
                }catch(Exception e){
                        e.printStackTrace();
                        return this.buildErrorResponse(e.getMessage());
                }
                
        }
        
        @GET
        @Path("/buscarPorId")
        @Consumes("application/*")
        @Produces(MediaType.APPLICATION_JSON)
        public Response buscarPorId(@QueryParam("id") int id) {
        	
        	try {
        		Marca marca = new Marca();
        		Conexao conec = new Conexao();
        		Connection conexao = conec.abrirConexao();
        		JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
        		
        		marca = jdbcMarca.buscarPorId(id);
        		
        		conec.fecharConexao();
        		
        		return this.buildResponse(marca);
        	}catch(Exception e) {
        		e.printStackTrace();
        		return this.buildErrorResponse(e.getMessage());
        	}
        }
        
        @PUT
        @Path("/alterar")
        @Consumes("application/*")
        public Response alterar(String marcaParam) {
        	try {
        		
        		Marca marca = new Gson().fromJson(marcaParam, Marca.class);
        		Conexao conec = new Conexao();
        		Connection conexao = conec.abrirConexao();
        		JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
        		
        		
        		boolean retorno = jdbcMarca.alterar(marca);
        		
        		String msg = "";
        		if(retorno) {
        			msg = "Produto alterado com sucesso!";
        		}else {
        			msg = "Erro ao alterar produto.";
        		}
        		
        		conec.fecharConexao();
        		return this.buildResponse(msg);
        	}catch(Exception e) {
        		e.printStackTrace();
        		return this.buildErrorResponse(e.getMessage());
        	}
        }
        
        @DELETE
        @Path("/excluir/{id}")
        @Consumes("application/*")
        public Response excluir(@PathParam("id") int id) {
        	try {
        		Conexao conec = new Conexao();
        		Connection conexao = conec.abrirConexao();
        		JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
        		
        		boolean retorno = jdbcMarca.deletar(id);
        		
        		String msg = "";
        		if(retorno) {
        			msg = "Marca excluída com sucesso!";
        		}else {
        			msg = "Erro ao excluir marca ou há algum produto cadastrado com esta marca.";
        		}
        		
        		conec.fecharConexao();
        		
        		return this.buildResponse(msg);
        		
        	}catch(Exception e) {
        		e.printStackTrace();
        		return this.buildErrorResponse(e.getMessage());
        	}
        }

}