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
			int retorno = jdbcMarca.inserir(marca);
			String msg = "";
			Response resposta;

			if (retorno == 1) {
				msg = "Essa marca já existe!";
				resposta = this.buildErrorResponse(msg);
			} else if (retorno == 2) {
				msg = "Erro ao cadastrar marca.";
				resposta = this.buildErrorResponse(msg);
			} else if(retorno == 3) {
				msg = "A marca selecionada está inativada!";
				resposta = this.buildErrorResponse(msg);
			}else {
				msg = "Marca cadastrada com sucesso!";
				resposta = this.buildResponse(msg);
			}

			conec.fecharConexao();

			return resposta;

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
		try {
			List<Marca> listaMarcas = new ArrayList<Marca>();
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
			listaMarcas = jdbcMarca.buscarPorMarca(nome);
			Response resposta;
			
			if(listaMarcas == null) {
				resposta = this.buildErrorResponse("Houve algum erro na consulta!");
			} else {
				resposta = this.buildResponse(listaMarcas);
			}

			conec.fecharConexao();

			return resposta;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("teste");
			return this.buildErrorResponse("Erro ao consultar marcas!");
		}

	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar() {
		try {
			List<Marca> listaMarcas = new ArrayList<Marca>();

			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
			Response resposta;
			
			listaMarcas = jdbcMarca.buscar();
			
			if(listaMarcas == null) {
				resposta = this.buildErrorResponse("Houve algum erro ao buscar as marcas!");
			}else {
				resposta = this.buildResponse(listaMarcas);
			}
			
			conec.fecharConexao();
			
			return resposta;
			
		} catch (Exception e) {
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
			Response resposta;

			marca = jdbcMarca.buscarPorId(id);
			
			if(marca == null) {
				resposta = this.buildErrorResponse("Houve um erro ao buscar a marca!");
			} else {
				resposta = this.buildResponse(marca);
			}

			conec.fecharConexao();

			return resposta;
			
		} catch (Exception e) {
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
			Response resposta;

			boolean retorno = jdbcMarca.alterar(marca);

			String msg = "";
			if (retorno) {
				msg = "Produto alterado com sucesso!";
				resposta = this.buildResponse(msg);
				} else {
				msg = "Erro ao alterar produto.";
				resposta = this.buildErrorResponse(msg);
			}

			conec.fecharConexao();
			
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
			JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
			Response resposta;

			int retorno = jdbcMarca.deletarCompleto(id);

			String msg = "";
			if (retorno == 1) {
				msg = "Marca excluída com sucesso!";
				resposta = this.buildResponse(msg);
			} else if (retorno == 2) {
				msg = "Há algum produto cadastrado com esta marca, " + "não é possível excluí-la";
				resposta = this.buildErrorResponse(msg);
			} else if (retorno == 3){
				msg = "Houve algum erro no banco de dados!";
				resposta = this.buildErrorResponse(msg);
			} else {
				msg = "Erro ao excluir marca!";
				resposta = this.buildErrorResponse(msg);
			}

			conec.fecharConexao();

			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

	@PUT
	@Path("/status/{id}")
	@Consumes("application/*")
	public Response statusChange(@PathParam("id") int id) {

		try {
			Conexao conec = new Conexao();
			Connection conexao = conec.abrirConexao();
			JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
			Response resposta;

			int retorno = jdbcMarca.statusChange(id);
			
			if(retorno == 1) {
				resposta = this.buildResponse("Marca inativada com sucesso!");	
			} else if (retorno == 2) {
				resposta = this.buildResponse("Marca ativada com sucesso!");
			} else {
				resposta = this.buildErrorResponse("Erro ao alterar o status: esta marca foi apagada");
			}

			conec.fecharConexao();

			return resposta;

		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

}