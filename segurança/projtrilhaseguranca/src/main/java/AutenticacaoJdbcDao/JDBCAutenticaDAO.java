package AutenticacaoJdbcDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ArmzanaDadosUsuario.ArmaDadosUsuario;

public class JDBCAutenticaDAO {

    private Connection conexao;

    public JDBCAutenticaDAO(Connection conexao) {

        this.conexao = conexao;
    }

    public boolean consultar(ArmaDadosUsuario dadosautentica) {

        try {

            String comando = "SELECT * FROM dadosusuario WHERE usuario = '" + dadosautentica.getUsuario()
                    + "' and senha = '" + dadosautentica.getSenha() + "'";
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String consultarSalt(String usuario) {

        String salt = "";

        try {
            
            String comandoSalt = "SELECT * FROM dadosusuario WHERE usuario = '" + usuario + "'";

            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comandoSalt);

            while(rs.next()) {
                salt = rs.getString("salt");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salt;
    }

}
