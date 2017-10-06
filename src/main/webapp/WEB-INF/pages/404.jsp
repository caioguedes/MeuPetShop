<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="page_title" scope="request" value="Ops, página não encontrada!" />
<c:import url="_comum/not_logged_header.jsp"/>

<p class="alert alert-danger">Página não encontrada.</p>

<c:import url="_comum/footer.jsp"/>