<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%@page import="entidade.UsuarioEntidade"%>
<%@page import="entidade.ContaEntidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Bancario - Admin</title>
        <link rel="stylesheet" type="text/css" href="theme/reset.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="pages/home/style.css" media="screen" />
    </head>
    <body>
        <%
            
            UsuarioEntidade usuario = (UsuarioEntidade) session.getAttribute("usuario");
            Map<String, Object> usuarioDados = usuario.getDadosUsuario();
            
            List<ContaEntidade> contas = (List<ContaEntidade>) session.getAttribute("contas");
            Map<String, Object> contaDados = contas.get(0).getDadosConta();
            
            String idConta = String.valueOf(contaDados.get("id"));
            String nome = String.valueOf(usuarioDados.get("nome"));
        %>
        
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value='<%=String.format("Ola, %s", nome)%>' />
        </jsp:include>
        <div id="containerPage">
            <p id="saldo">Saldo: R$<%= contaDados.get("saldo") %></p>
            <div id="containerButtons">
                <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                    <jsp:param name="titulo" value="Extrato" />
                    <jsp:param name="subtitulo" value="Movimentacoes da Conta" />
                    <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                    <jsp:param name="href" value='<%=String.format("/transacao?idConta=%s",idConta)%>'/>
                 </jsp:include>

                <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                    <jsp:param name="titulo" value="Deposito" />
                    <jsp:param name="subtitulo" value="Special title treatment" />
                    <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                    <jsp:param name="href" value='<%=String.format("/pages/transacao/index.jsp?tipo=Deposito&idConta=%s",idConta)%>' />
                 </jsp:include>

                <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                    <jsp:param name="titulo" value="Transferencia" />
                    <jsp:param name="subtitulo" value="Special title treatment" />
                    <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                    <jsp:param name="href" value='<%=String.format("/pages/transacao/index.jsp?tipo=Transferencia&idConta=%s",idConta)%>' />
                 </jsp:include>

                <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                    <jsp:param name="titulo" value="Saque" />
                    <jsp:param name="subtitulo" value="Special title treatment" />
                    <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                    <jsp:param name="href" value='<%=String.format("/pages/transacao/index.jsp?tipo=Saque&idConta=%s",idConta)%>' />
                 </jsp:include>

                <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                    <jsp:param name="titulo" value="Investimento" />
                    <jsp:param name="subtitulo" value="Simular Investimento" />
                    <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                    <jsp:param name="href" value='<%=String.format("/pages/transacao/index.jsp?tipo=Investimento&idConta=%s",idConta)%>' />
                 </jsp:include>
            </div>
        </div>
    </body>
</html>
