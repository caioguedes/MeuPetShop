<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty paginator}">
    <p class='text-info'>Página ${paginator.currentPage}/${paginator.pages}</p>

    <ul class='pagination'>
        <li><a href="<c:url value="${paginationUrl}?page=${paginator.firstPage}"/>"><<</a></li>
        <li><a href="<c:url value="${paginationUrl}?page=${paginator.previousPage}"/>"><</a></li>
        <c:forEach var="page" begin="${paginator.firstListedPage}" end="${paginator.lastListedPage}">
            <li
                    <c:if test="${page == paginator.currentPage}">
                        class='active'
                    </c:if>

            ><a href="<c:url value="${paginationUrl}?page=${page}"/>">${page}</a></li>
        </c:forEach>
        <li><a href="<c:url value="${paginationUrl}?page=${paginator.nextPage}"/>">></a></li>
        <li><a href="<c:url value="${paginationUrl}?page=${paginator.lastPage}"/>">>></a></li>
    </ul>
    <br>(${paginator.totalRegister} resultados)<br><br>
</c:if>
<a class="btn btn-primary" href="<c:url value="${paginationUrl}"/>">Voltar a lista completa</a>