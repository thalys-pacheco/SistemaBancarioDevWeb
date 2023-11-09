<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="components/header/style.css" media="screen" />
<div id='header'>
    <div>
        <p class="textHeader">BootstrapJavaBank</p>
        ${param.logout ? '<a></a>' : '<a href=forward?href=/pages/login/index.jsp class="textHeader" >Logout</a>'}  
    </div>
    <h1>${param.title}</h1>
</div>
