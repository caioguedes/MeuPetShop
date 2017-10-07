<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR"/>

<c:set var="page_title" scope="request" value="Cadastrar Pet" />
<c:import url="../_comum/logged_header.jsp"/>


<form method="post" action="<c:url value="/pets/register"/>" onsubmit="return validarCadastroAnimal();">

    <fieldset class="text-center">
        <legend>Cadastro de Pet</legend>
    </fieldset>

    <c:import url="_fields.jsp" />

    <div class="text-center">
        <a href="<c:url value="/pets" />" class="btn btn-default">Voltar</a>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </div>
</form>

<script src="<c:url value="/js/pets/register.js"/>" type="text/javascript"></script>

<c:import url="../_comum/footer.jsp"/>