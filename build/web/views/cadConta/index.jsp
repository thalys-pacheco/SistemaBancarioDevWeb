<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Cadastrar Conta</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="views/cadConta/style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value="Cadastrar Conta" />
         </jsp:include>
        <form id="form" action="conta" method="Post">
            <input required maxlength="11" name="cpf" class="input" type="text" placeholder="Cpf do usuario" />
            <select class="input" name="tipo">
                <option value="corrente">Conta Corrente</option>
                <option value="poupanca" selected>Conta poupanca</option>
                <option id="none" value="select" disabled selected >Selecione o tipo de conta</option>
            </select>
            <input id="button" type="submit" value="CADASTRAR"/>
        </form>
    </body>
</html>
