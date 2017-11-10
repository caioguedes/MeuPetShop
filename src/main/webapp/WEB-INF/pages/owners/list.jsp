<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="page_title" scope="request" value="Lista de Proprietários"/>
<c:if test="${not empty petId}">
    <c:set var="page_title" scope="request" value="Seleção de Proprietário"/>
</c:if>

<c:import url="../_comum/logged_header.jsp"/>

<div class="col-lg-4">
    <form method="get" action="<c:url value="/owner/list"/>">
        <fieldset>
            <legend>Buscar Proprietários</legend>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label" for="searchName">Nome:</label>
                <div class="col-sm-10">
                    <input type="text" name="searchName" id="searchName" class="form-control form-group"
                           value="${searchName}">

                    <c:if test="${not empty petId}">
                        <input type="hidden" name="petId" value="${petId}">
                    </c:if>

                </div>
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </fieldset>
    </form>
</div>

<div class="col-sm-12">

    <c:if test="${owners.size() > 0}">


        <c:if test="${empty petId}">
            <h1>Lista de Proprietários</h1>
        </c:if>
        <c:if test="${not empty petId}">
            <h1>Seleção de Proprietário</h1>
        </c:if>


        <table class="table table-bordered table-striped table-hover">
            <tr>
                <td>Nome</td>
                <td>Telefone Principal</td>
                <td>Saldo Devedor</td>
                <td>Ações</td>
            </tr>

            <c:forEach items="${owners}" var="owner">
                <tr>
                    <td>
                            ${owner.name}
                    </td>
                    <td>
                            ${owner.phone}
                    </td>
                    <td>
                        <c:if test="${owner.debtor > 0}">${owner.debtor}</c:if>
                        <c:if test="${owner.debtor == 0.0}">Não</c:if>
                    </td>
                    <td>
                        <c:if test="${empty petId}">
                            <a class="btn btn-success" href="<c:url value="/owner?id=${owner.id}"/>">Ver</a>
                            <a class="btn btn-primary" href="<c:url value="/owner/edit?id=${owner.id}"/>">Editar</a>
                            <a class="btn btn-danger" href="<c:url value="/owner/remove?id=${owner.id}"/>">Excluir</a>
                        </c:if>

                        <c:if test="${not empty petId}">
                            <a class="btn btn-default"
                               href="<c:url value="/owner/select?id=${owner.id}&petId=${petId}"/>">Selecionar</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${owners.size() < 1}">
        <p class="text-info">Nenhum proprietário encontrado!</p>
    </c:if>

    <c:import url="../_comum/_pagination.jsp"/>
</div>

<c:import url="../_comum/footer.jsp"/>
