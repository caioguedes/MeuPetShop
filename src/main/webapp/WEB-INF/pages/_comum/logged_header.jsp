<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
                    <li><a href="<c:url value="/pets/register"/>" tabindex="0">Cadastrar</a></li>
                    <li><a href="<c:url value="/pets"/>" tabindex="0">Listar</a></li>
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
<c:if test="${not empty message}">
    <p class="alert alert-info">
            ${message}
    </p>
</c:if>
<c:if test="${not empty message_danger}">
    <p class="alert alert-danger">
            ${message_danger}
    </p>
</c:if>
<c:if test="${not empty message_success}">
    <p class="alert alert-success">
            ${message_success}
    </p>
</c:if>