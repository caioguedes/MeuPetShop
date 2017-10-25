<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty paginator}">

    <p class='text-info'>Página ${paginator.currentPage}/${paginator.pages}</p>

    <ul class='pagination'>
        <li class="${paginator.isFirstPage() ? 'disabled' : ''}">
            <a href="<c:url value="${paginator.getFirstPage()}"/>"><<</a>
        </li>
        <li class="${paginator.isPreviousPage() ? 'disabled' : ''}">
            <a href="<c:url value="${paginator.getPreviousPage()}"/>"><</a>
        </li>
        <c:forEach var="page" begin="${paginator.firstListedPage()}"
                   end="${paginator.getLastListedPage()}">
            <li class="${paginator.isPage(page) ? 'active' : ''}">
                <a href="<c:url value="${paginator.getPage(page)}"/>">${page}</a>
            </li>
        </c:forEach>
        <li class="${paginator.isNextPage() ? 'disabled' : ''}">
            <a href="<c:url value="${paginator.getNextPage()}"/>">></a>
        </li>
        <li class="${paginator.isLastPage() ? 'disabled' : ''}">
            <a href="<c:url value="${paginator.getLastPage()}"/>">>></a>
        </li>
    </ul>
    <br>(${paginator.total} resultados)<br><br>
</c:if>
<a class="btn btn-primary" href="<c:url value="${paginationUrl}"/>">Voltar a lista completa</a>