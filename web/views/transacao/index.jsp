<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Transacao</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="views/transacao/style.css" media="screen" />
    </head>
    <body>
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value="${param.tipo}" />
         </jsp:include>
        <form id="form" action="transacao" method="Post">
            <input required name="valor" class="input" type="number" step="any" min="0.00" placeholder="Valor" />
            <% if("Transferencia".equals(request.getParameter("tipo"))){%>
                <input required name="idDestinatario" class="input" type="text" placeholder="Nº conta do destinatario" />
            <%}%>
            
            <input required name="tipo" value="${param.tipo}" type="hidden" />
            <input required name="idConta" value="${param.idConta}" type="hidden" />
            <input required name="idUsuario" value="${param.idUsuario}" type="hidden" />
            <input id="button" type="submit" value="ENVIAR"/>
        </form>
    </body>
</html>
