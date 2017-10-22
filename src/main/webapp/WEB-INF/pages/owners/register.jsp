<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR"/>

<c:set var="page_title" scope="request" value="Cadastrar Proprietário" />
<c:import url="../_comum/logged_header.jsp"/>

<form method="post" action="<c:url value="/owner/register"/>" >

    <fieldset class="text-center">
        <legend>Cadastro de Proprietário</legend>
    </fieldset>

    <c:import url="_fields.jsp" />

    <div class="text-center">
        <a href="<c:url value="/owner/list" />" class="btn btn-default">Voltar</a>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </div>
</form>

<c:import url="../_comum/footer.jsp"/>