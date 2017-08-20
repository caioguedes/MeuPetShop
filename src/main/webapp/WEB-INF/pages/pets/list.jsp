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
        <!-- Fim Cabeçalho -->

        <div class="col-lg-4">
            <form method="get" action="<c:url value="/pets"/>">
                <fieldset>
                    <legend>Buscar Animais</legend>
                    <div class="form-group row">
                        <label class="col-sm-2 form-control-label" for="nomeBusca">Nome:</label>
                        <div class="col-sm-10">
                            <input type="text" name="nomeBusca" id="nomeBusca" class="form-control form-group"
                                   value="${nameSearched}">
                        </div>
                    </div>
                    <input type="hidden" name="busca" value="1"/>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </fieldset>
            </form>
        </div>

        <div class="col-sm-12">

            <c:if test="${pets.size() > 0}">
                <h1>Lista de Pets</h1>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <td>Pet</td>
                        <td>Proprietário</td>
                        <td>Espécie</td>
                        <td>Raça</td>
                        <td>Ações</td>
                    </tr>

                    <c:forEach items="${pets}" var="pet">
                        <tr>
                            <td>
                                    ${pet.name}
                            </td>
                            <td>
                                <c:if test="${pet.owner != null}">${pet.owner.name}</c:if>
                            </td>
                            <td>
                                    ${pet.species}
                            </td>
                            <td>
                                    ${pet.breed}
                            </td>
                            <td>
                                <a class="btn btn-success" href="<c:url value="/pets/${pet.id}"/>">Ver</a>
                                <a class="btn btn-primary" href="<c:url value="/pets/edit/${pet.id}"/>">Editar</a>
                                <a class="btn btn-danger" href="<c:url value="/pets/delete/${pet.id}"/>">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${pets.size() < 1}">
                <p class="text-info">Nenhum animal encontrado!</p>
            </c:if>
            <a class="btn btn-primary" href="<c:url value="/pets"/>">Voltar a lista completa</a>
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