package LoginServlet;

import java.io.IOException;
import java.math.BigInteger;
import java.rmi.ServerException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

import ArmzanaDadosUsuario.ArmaDadosUsuario;
import AutenticacaoJdbcDao.JDBCAutenticaDAO;
import Conexao.Conexao;

public class AutenticacaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

        Conexao conec = new Conexao();
        Connection conexao = (Connection) conec.abrirConexao();
        JDBCAutenticaDAO getSalt = new JDBCAutenticaDAO(conexao);

        String salt = getSalt.consultarSalt(request.getParameter("usuario"));

        String senhaDigitada = request.getParameter("senha");

        String senhaComSalt = senhaDigitada + salt;

        ArmaDadosUsuario dadosautentica = new ArmaDadosUsuario();

        dadosautentica.setUsuario(request.getParameter("usuario"));
        

        String senmd5 = "";
        MessageDigest md = null;

        try {
            /*
             * Inicializando a conversão para o
             * padrão de criptografia MD5.
             * Caso ocorra tudo certo codifica este
             * padrão em bytes e armazena na
             * variável md.
             */
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            /*
             * Caso dê algum problema na conversão
             * uma mensagem de erro será disparada.
             */
            e.printStackTrace();
        }

        /*
         * Converte o valor do MD5 em Bytes para um
         * hash de inteiros longos para que possa
         * trabalhar com uma representação mais
         * próxima de alto nível.
         */
        BigInteger hash = new BigInteger(1, md.digest(senhaComSalt.getBytes()));
        /*
         * Converte esta representação em String para que possa armazenar a senha neste formato.
         */
        senmd5 = hash.toString(16);
        dadosautentica.setSenha(senmd5);

        JDBCAutenticaDAO jdbAutentica = new JDBCAutenticaDAO(conexao);
        boolean retorno = jdbAutentica.consultar(dadosautentica);

        if (retorno) {

            HttpSession sessao = request.getSession();
            sessao.setAttribute("login", request.getParameter("usuario"));
            response.sendRedirect("Acesso/principal.html");
        } else {
            response.sendRedirect("erro.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServerException, IOException {
        process(request, response);
    }

}
