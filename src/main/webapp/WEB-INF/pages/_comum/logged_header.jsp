<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title><c:if test="${not empty page_title}">${page_title} | </c:if>MeuPetShop</title>
    <link type="text/css" href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/bootstrap-submenu.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/bootstrap-theme.css"/>" rel="stylesheet"/>
    <link type="text/css" href="<c:url value="/css/meupetshop.css"/>" rel="stylesheet"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="<c:url value="/" />" class="navbar-brand">Pet Shop</a>
        </div>

        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a data-toggle="dropdown">Animais <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/pets/register" />">Cadastrar</a></li>
                        <li><a href="<c:url value="/pets" />">Listar</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a data-toggle="dropdown">Proprietários <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/owner/register" />">Cadastrar</a></li>
                        <li><a href="<c:url value="/owner/list" />">Listar</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a data-toggle="dropdown" aria-expanded="false">Usuário <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/settings" />" id="click-logout">Configurações</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#" id="#click-logout">Sair</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
<div class="principal">

<c:import url="/WEB-INF/pages/_comum/_flashmessage.jsp" />