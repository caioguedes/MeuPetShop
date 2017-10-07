<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="page_title" scope="request" value="Excluir #${pet.id} ${pet.name}?" />
<c:import url="../_comum/logged_header.jsp"/>

<form action="<c:url value="/pet/remove" />" method="post">
    <input type="hidden" name="id" value="${pet.id}">

    <p class="alert">Tem certeza que quer excluir este pet?<br>
        ${pet.id}-${pet.name}
    </p>

    <c:if test="${not empty previouslyPage}">
        <a href="<c:url value="${previouslyPage}"/>" class="btn btn-default">Cancelar</a>
    </c:if>
    <c:if test="${empty previouslyPage}">
        <a href="<c:url value="pets"/>" class="btn btn-default">Cancelar</a>
    </c:if>

    <button class="btn btn-danger">Sim</button>
</form>

<script src="<c:url value="/js/pets/register.js"/>" type="text/javascript"></script>

<c:import url="../_comum/footer.jsp"/>