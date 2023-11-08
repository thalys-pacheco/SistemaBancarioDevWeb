<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario</title>
        <link rel="stylesheet" type="text/css" href="reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <form id="form">
            <input class="input" type="text" placeholder="Login" />
            <input class="input" type="password" placeholder="Senha" />
            <input id="button" type="submit" value="ENTRAR"/>
        </form>
    </body>
</html>
