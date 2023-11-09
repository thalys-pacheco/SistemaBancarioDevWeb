<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Admin</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="pages/admin/style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value="Painel" />
         </jsp:include>
        <div id="containerPage">
            <jsp:include page="../../components/cardAdmin/cardAdmin.jsp">
                <jsp:param name="titulo" value="Cadastrar Usuario" />
                <jsp:param name="subtitulo" value="Cadastrar novo usuario" />
                <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                <jsp:param name="href" value="/pages/cadUsuario/index.jsp" />
             </jsp:include>
            <jsp:include page="../../components/cardAdmin/cardAdmin.jsp">
                <jsp:param name="titulo" value="Cadastrar Conta" />
                <jsp:param name="subtitulo" value="Cadastrar nova conta" />
                <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                <jsp:param name="href" value="/pages/cadConta/index.jsp" />
             </jsp:include>
        </div>
    </body>
</html>
