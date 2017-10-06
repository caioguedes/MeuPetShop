<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="page_title" scope="request" value="Logout" />
<c:import url="_comum/not_logged_header.jsp"/>

<p class="alert alert-success">Logout realizado com sucesso!</p>

<c:import url="_comum/footer.jsp"/>