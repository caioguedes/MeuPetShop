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
            <p class="alert alert-success">
                    ${message}
            </p>
        </c:if>
        <!-- Fim Cabeçalho -->

        <div style="text-align: left; padding-bottom: 10px;" xmlns="http://www.w3.org/1999/html">
            <a class="btn btn-default" href="<c:url value="/pets"/>">Voltar</a>
            <a class="btn btn-primary" href="<c:url value="/pet/edit?=${pet.id}"/>">Editar</a>
            <a class="btn btn-danger" href="<c:url value="/pet/remove?=${pet.id}"/>">Excluir</a>
        </div>
        <div class="col-lg-5">
            <table class="table">
                <thead>
                <tr>
                    <th colspan="2">Informações do Pet</th>
                </tr>
                </thead>
                <tr>
                    <td>Código:</td>
                    <td>${pet.id}</td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>${pet.name}</td>
                </tr>
                <tr>
                    <td>Espécie:</td>
                    <td>${pet.species}</td>
                </tr>
                <tr>
                    <td>Raça:</td>
                    <td>${pet.breed}</td>
                </tr>
                <tr>
                    <td>Pelo:</td>
                    <td>${pet.fur}</td>
                </tr>
                <tr>
                    <td>Pelagem:</td>
                    <td>${pet.pelage}</td>
                </tr>
                <tr>
                    <td>Porte:</td>
                    <td>${pet.mien}</td>
                </tr>
                <tr>
                    <td>Peso:</td>
                    <td>${pet.weight}</td>
                </tr>
                <tr>
                    <td>Nascimento:</td>
                    <td>${pet.birth}</td>
                </tr>
                <tr>
                    <td>Cadastro:</td>
                    <td>${pet.register}</td>
                </tr>
                <tr>
                    <td>Observações:</td>
                    <td>${pet.comments}</td>
                </tr>
                <tr>
                    <td>Castrado:</td>
                    <td>${pet.castrated}</td>
                </tr>
                <tr>
                    <td>Cliente com pacote:</td>
                    <td>${pet.clientPacket}</td>
                </tr>
                <tr>
                    <td>Sexo:</td>
                    <td>${pet.gender}</td>
                </tr>
            </table>
        </div>
        <div class="col-lg-5">
            <table class="table">
                <thead>
                <tr>
                    <th>Informações do Cliente</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty p.owner}">
                <tr>
                    <td>
                        <span class="text-danger">Sem cliente cadastrado</span><br>
                        <a href="/cliente/cadastro?animal=${pet.id}" class="btn btn-primary">Cadastrar
                            Novo</a><br>
                        <a href="/cliente/selecionar/animal/${pet.id}"
                           class="btn btn-default">Selecionar </a>
                    </td>
                </tr>
                </c:if>
                <c:if test="${not empty p.owner}">
                <tr>
                    <td>Nome:</td>
                    <td>${pet.owner.name}</td>
                </tr>
                <tr>
                    <td>Endereço:</td>
                    <%--<td>${pet.}</td>--%>
                </tr>
                <tr>
                    <td>Telefone Principal:</td>
                    <%--<td>${pet.}</td>--%>
                </tr>
                <tr>
                    <td>Saldo Devedor:</td>
                    <%--<td>${pet.}</td>--%>
                </tr>
                <tr>
                    <td colspan="2">
                        <a class="btn btn-primary" href="/cliente/ver/${pet.owner.id}">Ver
                            Cliente</a>
                        <a href="/cliente/selecionar/animal/${pet.id}" class="btn btn-default">Alterar
                            Cliente </a>
                    </td>
                </tr>
                </c:if>
                </tbody>
            </table>
        </div>

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