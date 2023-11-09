<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="../../components/cardAdmin/style.css" media="screen" />
<div id='containerCardAdmin'>
    <a href="../${param.href}">
        <div id='titleContainerCardAdmin'>
            <h1>${param.titulo}</h1>
        </div>
        <div id='textContainerCardAdmin'>
            <h2>${param.subtitulo}</h2>
            <p>${param.texto}</p>
        </div>
    </a>
</div>
