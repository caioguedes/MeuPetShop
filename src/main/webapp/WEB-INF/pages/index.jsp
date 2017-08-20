<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Inicio Cabeçalho -->
<html>
<head>
    <title>MeuPetShop</title>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/bootstrap-submenu.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/bootstrap-theme.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/meupetshop.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/login.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">

    <div class="navbar-header">

        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a href="<c:url value="/"/>" class="navbar-brand">Pet Shop</a>
    </div>

    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">

            <li class="dropdown">
                <a tabindex="0" data-toggle="dropdown" data-submenu="">
                    Animais<span class="caret"></span>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/pets"/>" tabindex="0">Cadastrar</a></li>
                    <li><a href="<c:url value="/pets/list"/>" tabindex="0">Listar</a></li>
                </ul>
            </li>

            <li class="dropdown">
                <a tabindex="0" data-toggle="dropdown" data-submenu="">
                    Proprietários<span class="caret"></span>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/owner"/>" tabindex="0">Cadastrar</a></li>
                    <li><a href="<c:url value="/owner/list"/>" tabindex="0">Listar</a></li>
                </ul>
            </li>
        </ul>

        <!-- TODO colocar configurações   -->
        <ul class="nav navbar-nav navbar-right">

            <li class="dropdown">
                <a tabindex="0" data-toggle="dropdown" aria-expanded="false">
                    Opções<span class="caret"></span>
                </a>

                <ul class="dropdown-menu">
                    <li>
                        <a href="#" id="click-logout" tabindex="0">Deslogar</a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <div class="principal">
        <!-- Fim Cabeçalho -->

        <h1>Bem-vindo ao MeuPetShop.</h1>

        <!-- Inicio Rodapé -->
    </div>
</div>

<form style="display: none;" id="form-logout" action="<c:url value="/logout"/>" method="post"></form>
</body>
<script src="<c:url value="/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/bootstrap.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/bootstrap-submenu.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/meupetshop.js"/>" type="text/javascript"></script>
</html>
<!-- Fim Rodapé-->