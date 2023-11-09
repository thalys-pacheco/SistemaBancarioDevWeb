<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="models.UsuarioModel"%>
<%@page import="models.ContaModel"%>
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
            UsuarioModel usuario = (UsuarioModel) request.getAttribute("usuario");
            Map<String, Object> usuarioDados = usuario.getDadosUsuario();
            List<ContaModel> contas = (List<ContaModel>) request.getAttribute("contas");
            Map<String, Object> contaDados = contas.get(0).getDadosConta();
        %>
        
        <jsp:include page="../../components/header/header.jsp">
            <jsp:param name="title" value='Ola,' />
        </jsp:include>
        <div id="containerPage">
            <h1>Seja bem-vindo <%=usuarioDados.get("nome")%></h1>
            <p id="saldo">Saldo: R$<%= contaDados.get("saldo") %></p>
            <div id="containerButtons">
                <div id="sessionButtons">
                    <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                        <jsp:param name="titulo" value="Extrato" />
                        <jsp:param name="subtitulo" value="Movimentacoes da Conta" />
                        <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                        <jsp:param name="href" value="cadUsuario" />
                     </jsp:include>
                    <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                        <jsp:param name="titulo" value="Deposito" />
                        <jsp:param name="subtitulo" value="Special title treatment" />
                        <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                        <jsp:param name="href" value="cadConta" />
                     </jsp:include>
                    <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                        <jsp:param name="titulo" value="Transferencia" />
                        <jsp:param name="subtitulo" value="Special title treatment" />
                        <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                        <jsp:param name="href" value="cadConta" />
                     </jsp:include>
                </div>
                <div id="sessionButtons">
                    <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                        <jsp:param name="titulo" value="Saque" />
                        <jsp:param name="subtitulo" value="Special title treatment" />
                        <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                        <jsp:param name="href" value="cadConta" />
                     </jsp:include>
                    <jsp:include page="../../components/buttonUser/buttonUser.jsp">
                        <jsp:param name="titulo" value="Investimento" />
                        <jsp:param name="subtitulo" value="Simular Investimento" />
                        <jsp:param name="texto" value="With supporting text below as a natural lead-in to additional content." />
                        <jsp:param name="href" value="cadConta" />
                     </jsp:include>
                </div>
            </div>
        </div>
    </body>
</html>
