<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="components/cardExtrato/style.css" media="screen" />

<%
    String tipo;
    int idEmissor =  Integer.parseInt(request.getParameter("idEmissor"));
    int idDestinatario = Integer.parseInt(request.getParameter("idDestinatario"));
    
    if(idEmissor==-1){
        tipo =  "Deposito";
    } else if(idDestinatario==-1){
        tipo = "Saque";
    } else{
        tipo = "Transferencia";
    }
%>

<div class='containerCardExtrato'>
    <h1><%=tipo%></h1>
    <h1>${param.valor}</h1>
    <% if(tipo.equals("Transferencia")){%>
    <p>Enviado para a conta Nº ${param.idDestinatario}</p>
    <%}%>
    <p>${param.data}</p>
</div>
