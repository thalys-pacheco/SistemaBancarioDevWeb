<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario</title>
        <link rel="stylesheet" type="text/css" href="../../theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value="Painel" />
         </jsp:include>
        <form id="form" action="../../login" method="Post">
            <input maxlength="11" name="cpf" class="input" type="text" placeholder="Cpf" />
            <input name="password" class="input" type="password" placeholder="Senha" />
            <input id="button" type="submit" value="ENTRAR"/>
        </form>
    </body>
</html>