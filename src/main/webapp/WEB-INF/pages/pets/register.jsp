<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="pt-BR"/>

<c:import url="../_comum/logged_header.jsp"/>


<form method="post" action="<c:url value="/pets/register"/>" onsubmit="return validarCadastroAnimal();">

    <fieldset class="text-center">
        <legend>Cadastro de Pet</legend>
    </fieldset>

    <input type="hidden" name="owner_id" value=""/>
    <input type="hidden" name="pet_id" value=""/>

    <!-- Nome -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="name">Nome</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="name" name="name" placeholder="Qual o nome do bichinho?"
                   value='<c:if test="${not empty pet && not empty pet.name}">${pet.name}</c:if>'/>

            <c:if test="${not empty pet_name}">
                <div class="text-danger">
                        ${pet_name}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Espécie -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="species">Espécie</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="species" name="species" placeholder="Qual é a espécie?"
                   value='<c:if test="${not empty pet && not empty pet.species}">${pet.species}</c:if>'/>

            <c:if test="${not empty pet_species}">
                <div class="text-danger">
                        ${pet_species}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Raça -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="breed">Raça</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="breed" name="breed" placeholder="Qual a raça?"
                   value='<c:if test="${not empty pet && not empty pet.breed}">${pet.breed}</c:if>'/>

            <c:if test="${not empty pet_breed}">
                <div class="text-danger">
                        ${pet_breed}
                </div>
            </c:if>
        </div>
    </div>

    <!-- pêlo -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="fur">Pêlo</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="fur" name="fur" placeholder="Qual o pêlo?"
                   value='<c:if test="${not empty pet && not empty pet.fur}">${pet.fur}</c:if>'/>

            <c:if test="${not empty pet_fur}">
                <div class="text-danger">
                        ${pet_fur}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Pelagem -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="pelage">Pelagem</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="pelage" name="pelage" placeholder="Qual a pelagem?"
                   value='<c:if test="${not empty pet && not empty pet.pelage}">${pet.pelage}</c:if>'/>

            <c:if test="${not empty pet_pelage}">
                <div class="text-danger">
                        ${pet_pelage}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Porte -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="size">Porte</label>
        <div class="col-sm-10">
            <select class="form-control" id="size" name="size">
                <option value="0">--selecione--</option>
                <c:forEach items="${sizes}" var="size">
                <option value="${size}"
                        <c:if test="${not empty pet && pet.size == size}">selected="selected"</c:if>
                >${size}</option>
                </c:forEach>
            </select>
            <c:if test="${not empty pet_size}">
                <div class="text-danger">
                        ${pet_size}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Peso -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="weight">Peso</label>
        <div class="col-sm-10">
            <input type="number" step="0.5" class="form-control" id="weight" name="weight"
                   placeholder="Quanto o bichinho pesa?"
                   value='<c:if test="${not empty pet && not empty pet.weight}">${pet.weight}</c:if>'/>

            <c:if test="${not empty pet_weight}">
                <div class="text-danger">
                    <fmt:formatNumber value="${pet.weight}" minFractionDigits="2" type="number"/>
                </div>
            </c:if>
        </div>
    </div>

    <!-- Nascimento -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="birth">Nascimento</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="birth" name="birth" placeholder="Quando ele nasceu?"
                   value='<c:if test="${not empty pet && not empty pet.birth}">${pet.birth.format(dateFormatter)}</c:if>'/>

            <c:if test="${not empty pet_birth}">
                <div class="text-danger">
                        ${pet_birth}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Cadastro -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="register">Cadastro</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="register" name="register"
                   placeholder="Qual o número do cadastro?"
                   value='<c:if test="${not empty pet && not empty pet.register}">${pet.register.format(dateFormatter)}</c:if>'/>

            <c:if test="${not empty pet_register}">
                <div class="text-danger">
                        ${pet_register}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Sexo -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="gender">Sexo</label>
        <div class="col-sm-10">
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="genderM" value="${M}"
                           <c:if test='${not empty pet && not empty pet.gender && pet.gender == M}'>checked="checked"</c:if>
                    />Macho
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="gender" id="genderF" value="${F}"
                           <c:if test='${not empty pet && not empty pet.gender && pet.gender == F}'>checked="checked"</c:if>
                    />Fêmea
                </label>
            </div>
            <c:if test="${not empty pet_gender}">
                <div class="text-danger">
                        ${pet_gender}
                </div>
            </c:if>

        </div>
    </div>

    <!-- Observações -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="comments">Observações</label>
        <div class="col-sm-10">
            <textarea class="form-control" id="comments" rows="4" name="comments"><c:if
                    test="${not empty pet && not empty pet.comments}">${pet.comments}</c:if></textarea>

            <c:if test="${not empty pet_comments}">
                <div class="text-danger">
                        ${pet_comments}
                </div>
            </c:if>
        </div>
    </div>

    <!-- Observações -->
    <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="comments">Opções</label>
        <div class="col-sm-2">
            <c:if test="${not empty pet_castrated}">
                <div class="text-danger">
                        ${pet_castrated}
                </div>
            </c:if>
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="castrated"
                           <c:if test="${not empty pet && pet.castrated}">checked="checked"</c:if> /> Castrado
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
                    <input type="checkbox" name="clientPacket"
                           <c:if test="${not empty pet && pet.clientPacket}">checked="checked"</c:if> /> Cliente pacote
                </label>
            </div>
        </div>
    </div>

    <div class="text-center">
        <a href="<c:url value="/pets" />" class="btn btn-default">Voltar</a>
        <button type="submit" class="btn btn-primary">Cadastrar</button>
    </div>
</form>

<script src="<c:url value="/js/pets/register.js"/>" type="text/javascript"></script>

<c:import url="../_comum/footer.jsp"/>