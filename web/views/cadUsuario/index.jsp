<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Cadastrar Usuario</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="views/cadUsuario/style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value="Cadastrar Usuario" />
         </jsp:include>
        <form id="form" action="usuario" method="Post">
            <input required maxlength="11" name="cpf" class="input" type="text" placeholder="Cpf" />
            <input required name="nome" class="input" type="text" placeholder="Nome" />
            <input required name="email" class="input" type="text" placeholder="Email" />
            <select class="input" name="tipo">
                <option value="cliente">Cliente</option>
                <option value="admin" selected>Admin</option>
                <option id="none" value="select" disabled selected >Selecione o tipo de usuario</option>
            </select>
            <input required id="button" type="submit" value="CADASTRAR"/>
        </form>
    </body>
</html>
