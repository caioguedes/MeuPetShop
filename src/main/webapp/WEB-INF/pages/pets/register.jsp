<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import url="../_comum/logged_header.jsp"/>

<fieldset class="form-group">
    <legend>Cadastro do Pet</legend>
    <form method="post" action="<c:url value="/pets/register"/>" onsubmit="return validarCadastroAnimal();">

        <input type="hidden" name="owner_id" value=""/>
        <input type="hidden" name="pet_id" value=""/>

        <div class="form-group row">

            <c:if test="${not empty pet_name}">
                <div class="text-danger">
                        ${pet_name}
                </div>
            </c:if>
            <label for="name" class="col-sm-2 form-control-label">Nome:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" placeholder="name" value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_species}">
                <div class="text-danger">
                        ${pet_species}
                </div>
            </c:if>

            <label for="species" class="col-sm-2 form-control-label">Espécie:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="species" name="species" placeholder="espécie"
                       value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_breed}">
                <div class="text-danger">
                        ${pet_breed}
                </div>
            </c:if>
            <label for="breed" class="col-sm-2 form-control-label">Raça:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="breed" name="breed" placeholder="raça" value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_fur}">
                <div class="text-danger">
                        ${pet_fur}
                </div>
            </c:if>
            <label for="fur" class="col-sm-2 form-control-label">Pelo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="fur" name="fur" placeholder="pêlo" value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_pelage}">
                <div class="text-danger">
                        ${pet_pelage}
                </div>
            </c:if>
            <label for="pelage" class="col-sm-2 form-control-label">Pelagem:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="pelage" name="pelage" placeholder="pelagem"
                       value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_mien}">
                <div class="text-danger">
                        ${pet_mien}
                </div>
            </c:if>
            <label for="mien" class="col-sm-2 form-control-label">Porte:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="mien" name="mien" placeholder="porte" value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_weight}">
                <div class="text-danger">
                        ${pet_weight}
                </div>
            </c:if>
            <label for="weight" class="col-sm-2 form-control-label">Peso:</label>
            <div class="col-sm-10">
                <input type="text" step="any" class="form-control" id="weight" name="weight" placeholder="peso"
                       value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_birth}">
                <div class="text-danger">
                        ${pet_birth}
                </div>
            </c:if>
            <label for="birth" class="col-sm-2 form-control-label">Nascimento:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="birth" name="birth" placeholder="nascimento"
                       value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_register}">
                <div class="text-danger">
                        ${pet_register}
                </div>
            </c:if>
            <label for="register" class="col-sm-2 form-control-label">Cadastro:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="register" name="register" placeholder="cadastro"
                       value=""/>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_comments}">
                <div class="text-danger">
                        ${pet_comments}
                </div>
            </c:if>
            <label for="comments" class="col-sm-2 form-control-label">Observações:</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="comments" name="comments"></textarea>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2">Opções</label>
            <div class="col-sm-2">

                <c:if test="${not empty pet_castrated}">
                    <div class="text-danger">
                            ${pet_castrated}
                    </div>
                </c:if>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="castrated"/> Castrado
                    </label>
                </div>
            </div>
            <div class="col-sm-2">

                <c:if test="${not empty pet_cliente_packet}">
                    <div class="text-danger">
                            ${pet_cliente_packet}
                    </div>
                </c:if>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="clientPacket"/> Cliente pacote
                    </label>
                </div>
            </div>
        </div>

        <div class="form-group row">

            <c:if test="${not empty pet_gender}">
                <div class="text-danger">
                        ${pet_gender}
                </div>
            </c:if>
            <label class="col-sm-2">Sexo</label>
            <div class="col-sm-10">
                <div class="radio">
                    <label>
                        <input type="radio" name="gender" id="genderM" value="m"/>Macho
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="gender" id="genderF" value="f"/>Fêmea
                    </label>
                </div>
            </div>
        </div>

        <a href="<c:url value="/pets" />" class="btn btn-default">Voltar</a>
        <button type="submit" class="btn btn-primary">Cadastrar</button>

    </form>
</fieldset>
<script src="<c:url value="/js/pets/register.js"/>" type="text/javascript"></script>

<c:import url="../_comum/footer.jsp"/>