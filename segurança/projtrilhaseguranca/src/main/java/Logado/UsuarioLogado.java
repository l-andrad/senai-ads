package Logado;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioLogado extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {

            HttpSession sessao = request.getSession();
            String usuario = (String) sessao.getAttribute("login");
            
            PrintWriter out = response.getWriter();

            out.println(usuario);
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
