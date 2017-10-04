<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR" />

<c:import url="../_comum/logged_header.jsp"/>


<form method="post" action="<c:url value="/pets/edit"/>">

    <fieldset class="text-center">
        <legend>Alterar Pet</legend>
    </fieldset>

    <c:import url="_fields.jsp" />

    <div class="text-center">
        <a href="<c:url value="/pets" />" class="btn btn-default">Voltar</a>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </div>
</form>

<c:import url="../_comum/footer.jsp"/>