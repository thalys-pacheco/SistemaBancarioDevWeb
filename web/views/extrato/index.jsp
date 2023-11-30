<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="entidade.UsuarioEntidade"%>
<%@page import="entidade.TransacaoEntidade"%>
<%@page import="entidade.ContaEntidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Extrato</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="views/extrato/style.css" media="screen" />
    </head>
    <body>
        <%
            List<TransacaoEntidade> transacoes = (List<TransacaoEntidade>) request.getAttribute("transacoes");
            SimpleDateFormat  formatoDeData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        %>
        
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value='Extrato' />
        </jsp:include>
        <div id="containerPage">
             <% for(TransacaoEntidade transacao : transacoes){%>
                 <jsp:include page="../../components/cardExtrato/cardExtrato.jsp">
                    <jsp:param name="valor" value='<%=String.format("%.2f",transacao.getValor())%>' />
                    <jsp:param name="data" value='<%=String.format("%s",formatoDeData.format(transacao.getDataTransacao()))%>' />
                    <jsp:param name="idEmissor" value='<%=String.format("%d",transacao.getIdEmissor())%>'/>
                    <jsp:param name="idDestinatario" value='<%=String.format("%d",transacao.getIdDestinatario())%>'/>
                 </jsp:include>
             <%}%>
        </div>
    </body>
</html>
