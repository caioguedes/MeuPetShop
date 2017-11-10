<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR"/>

<c:set var="page_title" scope="request" value="#${pet.id} ${pet.name}"/>
<c:import url="../_comum/logged_header.jsp"/>

<div style="text-align: left; padding-bottom: 10px;" xmlns="http://www.w3.org/1999/html">
    <a class="btn btn-default" href="<c:url value="/pets"/>">Voltar</a>
    <a class="btn btn-primary" href="<c:url value="/pets/edit?id=${pet.id}"/>">Editar</a>
    <a class="btn btn-danger" href="<c:url value="/pet/remove?id=${pet.id}"/>">Excluir</a>
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
            <td>${pet.size}</td>
        </tr>
        <tr>
            <td>Peso:</td>
            <td><fmt:formatNumber value="${pet.weight}" minFractionDigits="2" type="number"/></td>
        </tr>
        <tr>
            <td>Nascimento:</td>
            <td>${pet.birth.format(dateFormatter)}</td>
        </tr>
        <tr>
            <td>Cadastro:</td>
            <td>${pet.register.format(dateFormatter)}</td>
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
                    <a href="<c:url value="/owner/register?petId=${pet.id}"/>" class="btn btn-default">Cadastrar
                        Novo</a>
                    <a href="<c:url value="/owner/list?petId=${pet.id}"/>" class="btn btn-default">Selecionar</a>
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

                    <a href="<c:url value="/owner?id=${pet.owner.id}"/>" class="btn btn-default">Ver Cliente </a>

                    <a href="<c:url value="/owner/list?petId=${pet.id}"/>" class="btn btn-default">Alterar Cliente </a>
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<c:import url="../_comum/footer.jsp"/>