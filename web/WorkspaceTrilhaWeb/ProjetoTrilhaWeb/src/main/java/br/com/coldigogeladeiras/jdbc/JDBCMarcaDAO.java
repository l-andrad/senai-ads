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
import br.com.coldigogeladeiras.modelo.Produto;

public class JDBCMarcaDAO implements MarcaDAO {

	private Connection conexao;

	public JDBCMarcaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Marca> buscar() {

		// Criação da instrução SQL para busca de todas as marcas
		String comando = "SELECT * FROM marcas";

		// Criação de uma lista para armazenar cada marca encontrada
		List<Marca> listMarcas = null;

		// Criação do objeto marca com valor null (ou seja, sem instanciá-lo)
		Marca marca = null;

		// Abertura do try-catch
		try {

			// Uso da conexão do banco para prepará-lo para uma instrução SQL
			Statement stmt = conexao.createStatement();

			// Execução da instrução criada previamente
			// e armazenamento do resultado no objeto rs
			ResultSet rs = stmt.executeQuery(comando);
			
			
			listMarcas = new ArrayList<Marca>();

			// Enquanto houver uma próxima linha no resultado
			while (rs.next()) {
				
				// Criação de instância da classe Marca
				marca = new Marca();
				
				// Recebimento dos 2 dados retornados do BD para cada linha encontrada
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int status = rs.getInt("status");

				// Setando no objeto marca os valores encontrados
				marca.setId(id);
				marca.setNome(nome);
				marca.setStatus(status);

				// Adição da instância contida no objeto Marca na lista de marcas
				listMarcas.add(marca);
			}

			// Caso alguma Exception seja gerada no try, recebe-a no objeto "ex"
		} catch (SQLException ex) {
			// Exibe a exceção na console
			ex.printStackTrace();
		}

		// Retorna para quem chamou o método a lista criada
		return listMarcas;

	}

	public int inserir(Marca marca) {

		String comandoInsert = "INSERT INTO marcas " + "(nome) VALUES (?)";
		String comandoSelect = "SELECT * FROM marcas";
		PreparedStatement p;
		ResultSet rs;
		int count = 0;
		int resposta = 3;
		int marcaStatus = 2;

		try {

			p = this.conexao.prepareStatement(comandoSelect);
			
			rs = p.executeQuery();
			
			while(rs.next()) {
				if(marca.getNome().equals(rs.getString("nome"))) {
					count++;
				}
				
			}
			
			System.out.println(marcaStatus);
			
			if(count == 0) {
				p = this.conexao.prepareStatement(comandoInsert);
				
				p.setString(1, marca.getNome());

				p.execute();
			} else {
				resposta = 1;
			}

			

		} catch (SQLException e) {
			e.printStackTrace();
			resposta = 2;
		}
		return resposta;
	}

	public List<Marca> buscarPorMarca(String nome) {

		// Criação da instrução SQL para busca de todas as marcas
		String comando = "SELECT * FROM marcas";

		if (!nome.equals("")) {
			comando += " WHERE marcas.nome LIKE '%" + nome + "%'";
		}

		comando += " ORDER BY marcas.nome ASC";

		// Criação de uma lista para armazenar cada marca encontrada
		List<Marca> listaMarcas = null;

		// Criação do objeto marca com valor null (ou seja, sem instanciá-lo)
		Marca marca = null;

		// Abertura do try-catch
		try {

			// Uso da conexÃ£o do banco para preparÃ¡-lo para uma instrução SQL
			Statement stmt = conexao.createStatement();

			// Execução da instrução criada previamente
			// e armazenamento do resultado no objeto rs
			ResultSet rs = stmt.executeQuery(comando);
			
			listaMarcas = new ArrayList<Marca>();

			// Enquanto houver uma próxima linha no resultado
			while (rs.next()) {

				// Criação de instância da classe Marca
				marca = new Marca();
				

				// Recebimento dos 2 dados retornados do BD para cada linha encontrada
				int id = rs.getInt("id");
				String nomeMarca = rs.getString("nome");
				int status = rs.getInt("status");

				// Setando no objeto marca os valores encontrados
				marca.setId(id);
				marca.setNome(nomeMarca);
				marca.setStatus(status);

				// Adição da instância contida no objeto Marca na lista de marcas
				listaMarcas.add(marca);
			}

			// Caso alguma Exception seja gerada no try, recebe-a no objeto "ex"
		} catch (SQLException e) {
			// Exibe a exceção na console
			e.printStackTrace();
		}

		// Retorna para quem chamou o método a lista criada
		return listaMarcas;

	}

	public Marca buscarPorId(int id) {

		String comando = "SELECT * FROM marcas WHERE marcas.id = ?";
		Marca marca = null;

		try {
			PreparedStatement p = this.conexao.prepareStatement(comando);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			marca = new Marca();
			while (rs.next()) {

				String nome = rs.getString("nome");

				marca.setId(id);
				marca.setNome(nome);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marca;
	}

	public boolean alterar(Marca marca) {

		String comando = "UPDATE marcas " + "SET nome=? WHERE id=?";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, marca.getNome());
			p.setInt(2, marca.getId());
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* Método antigo de deleção
	 * 
	 * public boolean deletar(int id) {
		String comando = "DELETE FROM marcas WHERE id = ?";

		PreparedStatement p;

		try {
			p = this.conexao.prepareStatement(comando);
			p.setInt(1, id);
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}*/

	public int deletarCompleto(int id) {
		String comandoDelete = "DELETE FROM marcas WHERE id = ?";
		String comandoSelect = "SELECT * FROM produtos WHERE produtos.marcas_id = ?";
		Produto produto = new Produto();
		List<Produto> listaProdutos = new ArrayList<Produto>();
		int resposta = 0;

		try {
			PreparedStatement select = this.conexao.prepareStatement(comandoSelect);
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {

				String categoria = rs.getString("categoria");
				int capacidade = rs.getInt("capacidade");
				float valor = rs.getFloat("valor");
				int marcaId = rs.getInt("marcas_Id");
				String modelo = rs.getString("modelo");
				int idProduto = rs.getInt("id");

				produto.setId(idProduto);
				produto.setCategoria(categoria);
				produto.setCapacidade(capacidade);
				produto.setValor(valor);
				produto.setMarcaId(marcaId);
				produto.setModelo(modelo);
				listaProdutos.add(produto);
			}

			if (listaProdutos.size() == 0) {
				resposta = 1;
				PreparedStatement delete = this.conexao.prepareStatement(comandoDelete);
				delete.setInt(1, id);
				delete.execute();
			} else if (listaProdutos.size() > 0) {
				resposta = 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			resposta = 3;
		}

		return resposta;
	};

	public int statusChange(int id) {
		String comandoAtivacao = "UPDATE marcas SET status = 1 WHERE id = ?";
		String comandoInativacao = "UPDATE marcas SET status = 0 WHERE id = ?";
		String comandoSelect = "SELECT * FROM marcas WHERE id = ?";
		int retorno = 4;
		int statusMarca = 4;

		PreparedStatement select, ativacao, inativacao;

		try {
			select = this.conexao.prepareStatement(comandoSelect);
			select.setInt(1, id);
			ResultSet rs = select.executeQuery();

			while (rs.next()) {
				statusMarca = rs.getInt("status");
			}

			if (statusMarca == 1) {
				inativacao = this.conexao.prepareStatement(comandoInativacao);
				inativacao.setInt(1, id);
				inativacao.execute();
				retorno = 1;

			} else if (statusMarca == 0) {
				ativacao = this.conexao.prepareStatement(comandoAtivacao);
				ativacao.setInt(1, id);
				ativacao.execute();
				retorno = 2;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			retorno = 3;
			
		}

		return retorno;

	}

}
