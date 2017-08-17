<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Inicio Cabeçalho Login/Logout -->
<html>
<head>
    <title>Login - MeuPetShop</title>
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
</div>

<div class="container">
    <div class="principal">
        <!-- Fim Cabeçalho Login/Logout -->

        <fieldset>
            <legend>Login</legend>
            <form action="<c:url value="/login"/>" method="post" onsubmit="return validarLogin();">

                <div class="form-group row">
                    <label for="usuario" class="col-sm-2 form-control-label">Usuário:</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="usuario" name="usuario" placeholder="usuário">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="senha" class="col-sm-2 form-control-label">Senha:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="senha">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Logar</button>
            </form>
        </fieldset>

        <!-- Inicio Rodapé -->
    </div>
</div>

</body>
<script src="<c:url value="/js/jquery.min.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/bootstrap.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/bootstrap-submenu.js"/>" type="text/javascript"></script>
<script type="text/javascript">
    $("#click-logout").click(function (event) {
        $('#form-logout').submit();
    });
</script>
</html>
<!-- Fim Rodapé-->