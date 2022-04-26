package br.com.coldigogeladeiras.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import br.com.coldigogeladeiras.bd.Conexao;
import br.com.coldigogeladeiras.jdbc.JDBCProdutoDAO;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.coldigogeladeiras.modelo.Produto;

@Path("produto")
public class ProdutoRest extends UtilRest {
	
	@POST
	@Path("/inserir")
	@Consumes("application/*")
	public Response inserir(String produtoParam) {
		
		try {
			Produto produto = new Gson().fromJson(produtoParam, Produto.class);
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			
			JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			int retorno = jdbcProduto.inserir(produto);
			String msg = "";
			Response resposta;
			
			if(retorno == 1) {
				msg = "A marca selecionada foi excluída/inativada, atualize a página para "
						+ "ver as alterações";
				resposta = this.buildErrorResponse(msg);
			} else if (retorno == 2) {
				msg = "Produto cadastrado com sucesso!";
				resposta = this.buildResponse(msg);
			} else if (retorno == 5) {
				msg = "A marca selecionada foi inativada, por favor selecione outra!";
				resposta = this.buildErrorResponse(msg);
			}else if(retorno == 4) {
				msg = "Já existe um produto cadastrado com esse modelo!";
				resposta = this.buildErrorResponse(msg);
			}else {
				msg = "Erro ao cadastrar produto.";
				resposta = this.buildErrorResponse(msg);
			}
			
			conec.fecharConexao();
			
			return resposta;
			
		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Path("/buscar")
	@Consumes("application/*")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNome(@QueryParam("valorBusca") String nome) {
		try {
			
			List<JsonObject> listaProdutos = new ArrayList<JsonObject>();
			
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			listaProdutos = jdbcProduto.buscarPorNome(nome);
			conec.fecharConexao();
			Response resposta;
			
			String json = new Gson().toJson(listaProdutos);
			
			if(listaProdutos == null) {
				resposta = this.buildErrorResponse("Não foi possível consultar os produtos.");
			}else {
				resposta = this.buildResponse(json);
			}
			
			return resposta;
			
		} catch (Exception e) {
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
			JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			Response resposta;
			
			boolean retorno = jdbcProduto.deletar(id);
			
			String msg = "";
			if(retorno) {
				msg = "Produto excluído com sucesso!";
				resposta = this.buildResponse(msg);
				
			} else {
				msg = "Erro ao excluir produto.";
				resposta = this.buildErrorResponse(msg);
				
			}
			
			conec.fecharConexao();
			
			return resposta;
			
		}catch(Exception e) {
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
			Produto produto = new Produto();
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			Response resposta;
			
			produto = jdbcProduto.buscarPorId(id);
			
			if(produto == null) {
				resposta = this.buildErrorResponse("Não foi possível buscar o produto.");
			}else {
				resposta = this.buildResponse(produto);
			}
			
			conec.fecharConexao();
			
			return resposta;
			
		}catch(Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@PUT
	@Path("/alterar")
	@Consumes("application/*")
	public Response alterar(String produtoParam) {
		try {
			Produto produto = new Gson().fromJson(produtoParam, Produto.class);
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			Response resposta;
			
			boolean retorno = jdbcProduto.alterar(produto);
			
			String msg = "";
			if(retorno) {
				msg = "Produto alterado com sucesso!";
				resposta = this.buildResponse(msg);
			}else {
				msg = "Erro ao alterar produto.";
				resposta = this.buildErrorResponse(msg);
			}
			
			conec.fecharConexao();
			
			return resposta;
			
		}catch(Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}
