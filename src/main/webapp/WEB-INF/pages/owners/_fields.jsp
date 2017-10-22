<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<input type="hidden" name="pet_id" value='<c:if test="${not empty pet_id && not empty pet_id}">${pet_id}</c:if>'/>
<input type="hidden" name="id" value='<c:if test="${not empty owner && not empty owner.id}">${owner.id}</c:if>'/>

<!-- Nome -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="name">Nome</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="name" name="name" placeholder="Qual o nome do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.name}">${owner.name}</c:if>'/>

        <c:if test="${not empty owner_name}">
            <div class="text-danger">
                    ${owner_name}
            </div>
        </c:if>
    </div>
</div>

<!-- Nome Secuntário -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="secondary_name">Nome Secundário</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="secondary_name" name="secondary_name"
               placeholder="Qual o nome do outro proprietário?"
               value='<c:if test="${not empty owner && not empty owner.secondaryName}">${owner.secondaryName}</c:if>'/>

        <c:if test="${not empty owner_secondary_name}">
            <div class="text-danger">
                    ${owner_secondary_name}
            </div>
        </c:if>
    </div>
</div>

<!-- Endereço -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="address">Endereço</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="address" name="address"
               placeholder="Qual o endereço do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.address}">${owner.address}</c:if>'/>

        <c:if test="${not empty owner_address}">
            <div class="text-danger">
                    ${owner_address}
            </div>
        </c:if>
    </div>
</div>

<!-- Bairro -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="district">Bairro</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="district" name="district"
               placeholder="Qual o bairro do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.district}">${owner.district}</c:if>'/>

        <c:if test="${not empty owner_district}">
            <div class="text-danger">
                    ${owner_district}
            </div>
        </c:if>
    </div>
</div>

<!-- Phone -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="phone">Telefone</label>
    <div class="col-sm-1">
        <input type="text" class="form-control" id="ddd" name="ddd" placeholder="DDD"
               value='<c:if test="${not empty owner && not empty owner.phone && not empty owner.phone.ddd}">${owner.phone.ddd}</c:if>'>
    </div>
    <div class="col-sm-9">
        <input type="text" class="form-control" id="phone" name="phone"
               placeholder="Qual o telefone do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.phone && not empty owner.phone.number}">${owner.phone.number}</c:if>'/>

        <c:if test="${not empty owner_phone_ddd}">
            <div class="text-danger">
                    ${owner_phone_ddd}
            </div>
        </c:if>
        <c:if test="${not empty owner_phone_number}">
            <div class="text-danger">
                    ${owner_phone_number}
            </div>
        </c:if>
    </div>
</div>

<!-- Phone 2 -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="phone2">Telefone 2</label>
    <div class="col-sm-1">
        <input type="text" class="form-control" id="ddd2" name="ddd2" placeholder="DDD"
               value='<c:if test="${not empty owner && not empty owner.phone2 && not empty owner.phone2.ddd}">${owner.phone2.ddd}</c:if>'>
    </div>
    <div class="col-sm-9">
        <input type="text" class="form-control" id="phone2" name="phone2"
               placeholder="Qual o segundo telefone do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.phone2 && not empty owner.phone2.number}">${owner.phone2.number}</c:if>'/>

        <c:if test="${not empty owner_phone_ddd2}">
            <div class="text-danger">
                    ${owner_phone_ddd2}
            </div>
        </c:if>
        <c:if test="${not empty owner_phone_number2}">
            <div class="text-danger">
                    ${owner_phone_number2}
            </div>
        </c:if>
    </div>
</div>

<!-- Phone 3 -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="phone3">Telefone 3</label>
    <div class="col-sm-1">
        <input type="text" class="form-control" id="ddd3" name="ddd3" placeholder="DDD"
               value='<c:if test="${not empty owner && not empty owner.phone3 && not empty owner.phone3.ddd}">${owner.phone3.ddd}</c:if>'>
    </div>
    <div class="col-sm-9">
        <input type="text" class="form-control" id="phone3" name="phone3"
               placeholder="Qual o terceiro telefone do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.phone3 && not empty owner.phone3.number}">${owner.phone3.number}</c:if>'/>

        <c:if test="${not empty owner_phone_ddd3}">
            <div class="text-danger">
                    ${owner_phone_ddd3}
            </div>
        </c:if>
        <c:if test="${not empty owner_phone_number3}">
            <div class="text-danger">
                    ${owner_phone_number3}
            </div>
        </c:if>
    </div>
</div>

<!-- Phone 4 -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="phone4">Telefone 4</label>
    <div class="col-sm-1">
        <input type="text" class="form-control" id="ddd4" name="ddd4" placeholder="DDD"
               value='<c:if test="${not empty owner && not empty owner.phone4 && not empty owner.phone4.ddd}">${owner.phone4.ddd}</c:if>'>
    </div>
    <div class="col-sm-9">
        <input type="text" class="form-control" id="phone4" name="phone4"
               placeholder="Qual o quarto telefone do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.phone4 && not empty owner.phone4.number}">${owner.phone4.number}</c:if>'/>

        <c:if test="${not empty owner_phone_ddd4}">
            <div class="text-danger">
                    ${owner_phone_ddd4}
            </div>
        </c:if>
        <c:if test="${not empty owner_phone_number4}">
            <div class="text-danger">
                    ${owner_phone_number4}
            </div>
        </c:if>
    </div>
</div>

<!-- Phone 5 -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="phone5">Telefone 5</label>
    <div class="col-sm-1">
        <input type="text" class="form-control" id="ddd5" name="ddd5" placeholder="DDD"
               value='<c:if test="${not empty owner && not empty owner.phone5 && not empty owner.phone5.ddd}">${owner.phone5.ddd}</c:if>'>
    </div>
    <div class="col-sm-9">
        <input type="text" class="form-control" id="phone5" name="phone5"
               placeholder="Qual o quinto telefone do proprietário?"
               value='<c:if test="${not empty owner && not empty owner.phone5 && not empty owner.phone5.number}">${owner.phone5.number}</c:if>'/>

        <c:if test="${not empty owner_phone_ddd5}">
            <div class="text-danger">
                    ${owner_phone_ddd5}
            </div>
        </c:if>
        <c:if test="${not empty owner_phone_number5}">
            <div class="text-danger">
                    ${owner_phone_number5}
            </div>
        </c:if>
    </div>
</div>

<!-- Observações -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="comments">Observações</label>
    <div class="col-sm-10">
            <textarea class="form-control" id="comments" rows="4" name="comments"><c:if
                    test="${not empty owner && not empty owner.comments}">${owner.comments}</c:if></textarea>

        <c:if test="${not empty owner_comments}">
            <div class="text-danger">
                    ${owner_comments}
            </div>
        </c:if>
    </div>
</div>

<!-- Saldo Devedor -->
<div class="form-group row">
    <label class="col-sm-2 col-form-label" for="debtor">Saldo Devedor</label>
    <div class="col-sm-10">
        <input type="text" step="0.5" class="form-control" id="debtor" name="debtor"
               placeholder="Quanto o cliente deve?"
               value='<c:if test="${not empty owner && not empty owner.debtor}"><fmt:formatNumber value="${owner.debtor}" minFractionDigits="2" type="number"/></c:if>'/>

        <c:if test="${not empty owner_debtor}">
            <div class="text-danger">
                    ${owner_debtor}
            </div>
        </c:if>
    </div>
</div>