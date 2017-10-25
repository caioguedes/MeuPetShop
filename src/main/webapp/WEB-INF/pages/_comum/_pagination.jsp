<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty paginatorView}">

    <p class='text-info'>Página ${paginatorView.paginatorCalculator.currentPage}/${paginatorView.paginatorCalculator.pages}</p>

    <ul class='pagination'>
        <li class="${(paginatorView.paginatorCalculator.currentPage == paginatorView.paginatorCalculator.firstPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginatorCalculator.firstPage)}"/>"><<</a>
        </li>
        <li class="${(paginatorView.paginatorCalculator.currentPage == paginatorView.paginatorCalculator.previousPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginatorCalculator.previousPage)}"/>"><</a>
        </li>
        <c:forEach var="page" begin="${paginatorView.paginatorCalculator.firstListedPage}"
                   end="${paginatorView.paginatorCalculator.lastListedPage}">
            <li class="${page == paginatorView.paginatorCalculator.currentPage ? 'active' : ''}">
                <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(page)}"/>">${page}</a>
            </li>
        </c:forEach>
        <li class="${(paginatorView.paginatorCalculator.currentPage == paginatorView.paginatorCalculator.nextPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginatorCalculator.nextPage)}"/>">></a>
        </li>
        <li class="${(paginatorView.paginatorCalculator.currentPage == paginatorView.paginatorCalculator.lastPage) ? 'disabled' : ''}">
            <a href="<c:url value="${paginationUrl}${paginatorView.getParameters(paginatorView.paginatorCalculator.lastPage)}"/>">>></a>
        </li>
    </ul>
    <br>(${paginatorView.paginatorCalculator.totalRegister} resultados)<br><br>
</c:if>
<a class="btn btn-primary" href="<c:url value="${paginationUrl}"/>">Voltar a lista completa</a>