<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="../_comum/logged_header.jsp"/>

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
                        <a class="btn btn-success" href="<c:url value="/pet?id=${pet.id}"/>">Ver</a>
                        <a class="btn btn-primary" href="<c:url value="/pet/edit?id=${pet.id}"/>">Editar</a>
                        <a class="btn btn-danger" href="<c:url value="/pet/remove?id=${pet.id}"/>">Excluir</a>
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

<c:import url="../_comum/footer.jsp"/>
