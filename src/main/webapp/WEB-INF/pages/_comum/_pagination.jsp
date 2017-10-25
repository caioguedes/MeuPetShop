<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty paginatorView}">

    <p class='text-info'>Página ${paginatorView.paginator.currentPage}/${paginatorView.paginator.pages}</p>

    <ul class='pagination'>
        <li class="${(paginatorView.paginator.currentPage == paginatorView.paginator.firstPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginator.firstPage)}"/>"><<</a>
        </li>
        <li class="${(paginatorView.paginator.currentPage == paginatorView.paginator.previousPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginator.previousPage)}"/>"><</a>
        </li>
        <c:forEach var="page" begin="${paginatorView.paginator.firstListedPage}"
                   end="${paginatorView.paginator.lastListedPage}">
            <li class="${page == paginatorView.paginator.currentPage ? 'active' : ''}">
                <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(page)}"/>">${page}</a>
            </li>
        </c:forEach>
        <li class="${(paginatorView.paginator.currentPage == paginatorView.paginator.nextPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginator.nextPage)}"/>">></a>
        </li>
        <li class="${(paginatorView.paginator.currentPage == paginatorView.paginator.lastPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginator.lastPage)}"/>">>></a>
        </li>
    </ul>
    <br>(${paginatorView.paginator.totalRegister} resultados)<br><br>
</c:if>
<a class="btn btn-primary" href="<c:url value="${paginationUrl}"/>">Voltar a lista completa</a>