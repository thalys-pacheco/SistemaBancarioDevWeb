<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="components/buttonUser/style.css" media="screen" />
<div id='containerButtonUser'>
    <a href="../${param.href}">
        <div id='titleContainerButtonUser'>
            <h1>${param.titulo}</h1>
        </div>
        <div id='textContainerButtonUser'>
            <h2>${param.subtitulo}</h2>
            <p>${param.texto}</p>
        </div>
    </a>
</div>
