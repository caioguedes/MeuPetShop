package br.com.ricardosander.meupetshop.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Model de um proprietário de um Pet.
 */
public class Owner {

    /**
     * Identificador.
     */
    private long id;

    /**
     * Nome do proprietário.
     */
    private String name;

    /**
     * Nome secundário do proprietário.
     */
    private String secondaryName;

    /**
     * Endereço do priprietário.
     */
    private String address;

    /**
     * Bairro do proprietário.
     */
    private String district;

    /**
     * Telefone para contato.
     */
    private String phone;

    /**
     * Segundo telefone para contato.
     */
    private String phone2;

    /**
     * Terceiro telefone para contato.
     */
    private String phone3;

    /**
     * Quarto telefone para contato.
     */
    private String phone4;

    /**
     * Quinto telefone para contato.
     */
    private String phone5;

    /**
     * Observações sobre o proprietário.
     */
    private String comments;

    /**
     * Saldo devedor do proprietário.
     */
    private double debtor;

    /**
     * Usuário.
     */
    private User user;

    /**
     * Pets dos quais a instância é proprietário.
     */
    private final List<Pet> pets;

    /**
     * Construtor básico.
     */
    public Owner() {
        this.pets = new LinkedList<>();
    }

    /**
     * Construtor.
     *
     * @param id   Identificador.
     * @param name Nome do proprietário.
     */
    public Owner(long id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    /**
     * @return Identificador.
     */
    public long getId() {
        return id;
    }

    /**
     * @param id Identificador.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Nome do proprietário.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name Nome do proprietário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Nome secundário do proprietário.
     */
    public String getSecondaryName() {
        return secondaryName;
    }

    /**
     * @param secondaryName Nome secundário do proprietário.
     */
    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    /**
     * @return Endereço.
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address Endereço.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Bairro.
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district Bairro.
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return Telefone para contato.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone Telefone para contato.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return Segundo telefone para contato.
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * @param phone2 Segundo telefone para contato.
     */
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    /**
     * @return Terciário telefone para contato.
     */
    public String getPhone3() {
        return phone3;
    }

    /**
     * @param phone3 Terceiro telefone para contato.
     */
    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    /**
     * @return Quarto telefone para contato.
     */
    public String getPhone4() {
        return phone4;
    }

    /**
     * @param phone4 Quarto telefone para contato.
     */
    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    /**
     * @return Quinto telefone para contato.
     */
    public String getPhone5() {
        return phone5;
    }

    /**
     * @param phone5 Quinto telefone para contato.
     */
    public void setPhone5(String phone5) {
        this.phone5 = phone5;
    }

    /**
     * @return Observações.
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments Observações.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return Saldo devedor.
     */
    public double getDebtor() {
        return debtor;
    }

    /**
     * @param debtor Saldo devedor.
     */
    public void setDebtor(double debtor) {
        this.debtor = debtor;
    }

    /**
     * @return Usuário.
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user Usuário.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return Pets.
     */
    public List<Pet> getPets() {
        return Collections.unmodifiableList(pets);
    }

    /**
     * Adiciona um pet a lista de pets do proprietário.
     *
     * @param pet Pet.
     */
    public void addPets(Pet pet) {
        this.pets.add(pet);
    }

}