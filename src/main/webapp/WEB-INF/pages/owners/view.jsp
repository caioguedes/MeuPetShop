<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR"/>

<c:set var="page_title" scope="request" value="#${owner.id} ${owner.name}"/>
<c:import url="../_comum/logged_header.jsp"/>

<div style="text-align: left; padding-bottom: 10px;" xmlns="http://www.w3.org/1999/html">
    <a class="btn btn-default" href="<c:url value="/owner/list"/>">Voltar</a>
    <a class="btn btn-primary" href="<c:url value="/owner/edit?id=${pet.id}"/>">Editar</a>
    <a class="btn btn-danger" href="<c:url value="/owner/remove?id=${pet.id}"/>">Excluir</a>
</div>
<div class="col-lg-4">
    <table class="table">
        <thead>
        <tr>
            <th colspan="2">Informações do Proprietário</th>
        </tr>
        </thead>
        <tr>
            <td>Código:</td>
            <td>${owner.id}</td>
        </tr>
        <tr>
            <td>Nome:</td>
            <td>${owner.name}</td>
        </tr>
        <c:if test="${not empty owner.secondaryName}">
            <tr>
                <td>Nome Secundário:</td>
                <td>${owner.secondaryName}</td>
            </tr>
        </c:if>
        <c:if test="${not empty owner.address}">
            <tr>
                <td>Endereço:</td>
                <td>${owner.address}</td>
            </tr>
        </c:if>
        <tr>
            <td>Bairro:</td>
            <td>${owner.district}</td>
        </tr>
        <tr>
            <td>Telefone Principal:</td>
            <td>${owner.phone}</td>
        </tr>
        <c:if test="${not empty owner.phone2}">
            <tr>
                <td>Telefone 2:</td>
                <td>${owner.phone2}</td>
            </tr>
        </c:if>
        <c:if test="${not empty owner.phone3}">
            <tr>
                <td>Telefone 3:</td>
                <td>${owner.phone3}</td>
            </tr>
        </c:if>
        <c:if test="${not empty owner.phone4}">
            <tr>
                <td>Telefone 4:</td>
                <td>${owner.phone4}</td>
            </tr>
        </c:if>
        <c:if test="${not empty owner.phone5}">
            <tr>
                <td>Telefone 5:</td>
                <td>${owner.phone5}</td>
            </tr>
        </c:if>
        <c:if test="${not empty owner.comments}">
            <tr>
                <td>Observações:</td>
                <td>${owner.comments}</td>
            </tr>
        </c:if>
        <tr>
            <td>Saldo Devedor:</td>
            <c:if test="${owner.debtor > 0}">
                <td><fmt:formatNumber value="${owner.debtor}" minFractionDigits="2" type="number"/></td>
            </c:if>
            <c:if test="${not (owner.debtor > 0)}">
                <td>Não</td>
            </c:if>
        </tr>
    </table>
</div>
<div class="col-lg-8">
    <table class="table table-bordered table-striped table-hover">
        <thead>
        <tr>
            <th colspan="5">Animais</th>
        </tr>
        <c:if test="${not empty owner.pets}">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Espécie</th>
            <th>Raça</th>
            <th>Ações</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pet" items="owner.pets">
        <tr>
            <td>${pet.id}</td>
            <td>${pet.name}</td>
            <td>${pet.species}</td>
            <td>${pet.breed()}</td>
            <td>
                <a class="btn btn-success" href="<c:url value="/pet?id=${owner.id}"/>">Ver</a>
                <a class="btn btn-primary" href="<c:url value="/pets/edit?id=${owner.id}"/>">Editar</a>
                <a class="btn btn-danger" href="<c:url value="/pet/remove?id=${owner.id}"/>">Excluir</a>
            </td>
        </tr>
        </c:forEach>
        </c:if>
        <c:if test="${empty owner.pets}">
        <tr>
            <td>
                <span class="text-danger">Sem pets cadastrados</span>
            </td>
        </tr>
        </thead>
        <tbody>
        </c:if>
        <tr>
            <td colspan="5">
                <a href="<c:url value="/pets/register?owner=${owner.id}"/>" class="btn btn-primary">Cadastrar
                    Novo</a>
                <a href="<c:url value="/pet/select?owner=${owner.id}"/>"
                   class="btn btn-default">Selecionar </a>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<c:import url="../_comum/footer.jsp"/>