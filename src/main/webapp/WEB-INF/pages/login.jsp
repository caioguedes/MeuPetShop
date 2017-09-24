<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="_comum/not_logged_header.jsp"/>

        <fieldset>
            <legend>Login</legend>
            <form action="<c:url value="/login"/>" method="post" onsubmit="return validarLogin();">

                <div class="form-group row">
                    <label for="usuario" class="col-sm-2 form-control-label">Usuário:</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="usuario" name="usuario" placeholder="usuário">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="senha" class="col-sm-2 form-control-label">Senha:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="senha">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Logar</button>
            </form>
        </fieldset>

<c:import url="_comum/footer.jsp" />