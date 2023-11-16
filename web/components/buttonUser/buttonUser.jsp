<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="components/buttonUser/style.css" media="screen" />
<div class='containerButtonUser'>
    <a href="forward?href=${param.href}">
        <div class='titleContainerButtonUser'>
            <h1>${param.titulo}</h1>
        </div>
        <div class='textContainerButtonUser'>
            <h2>${param.subtitulo}</h2>
            <p>${param.texto}</p>
        </div>
    </a>
</div>
