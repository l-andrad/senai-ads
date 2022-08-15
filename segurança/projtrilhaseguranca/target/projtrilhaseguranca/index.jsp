<%@ page language="java" charset=ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página principal</title>
    <script src="./desafio.js"></script>
</head>
<body>
    <center><h1>BEM-VINDO A PÁGINA PRINCIPAL........</h1></center>
    <%
        String usuario = (String) session.getParameter("usuario");

        out.println(usuario);
    %>
</body>
</html>