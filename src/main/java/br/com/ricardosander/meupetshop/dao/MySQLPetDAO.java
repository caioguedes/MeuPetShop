package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.database.Database;
import br.com.ricardosander.meupetshop.model.*;

import java.beans.PropertyVetoException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementação MySQL de DAO para Pet.
 */
public class MySQLPetDAO implements PetDAO {

    @Override
    public List<Pet> find(User user) {

        LinkedList<Pet> pets = new LinkedList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        PetSize petSize;
        Gender gender;

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder
                .append("   SELECT ")
                .append("       A.ID ")
                .append(" ,     A.NOME ")
                .append(" ,     A.ESPECIE ")
                .append(" ,     A.RACA ")
                .append(" ,     A.PELO ")
                .append(" ,     A.PELAGEM ")
                .append(" ,     A.PORTE ")
                .append(" ,     A.PESO ")
                .append(" ,     A.NASCIMENTO ")
                .append(" ,     A.CADASTRO ")
                .append(" ,     A.CASTRADO ")
                .append(" ,     A.OBSERVACOES ")
                .append(" ,     A.SEXO ")
                .append(" ,     A.CLIENTE_PACOTE ")
                .append(" ,     A.USUARIO USUARIO_ID ")
                .append(" ,     A.CLIENTE CLIENTE_ID ")
                .append(" ,     U.USUARIO ")
                .append(" ,     U.SENHA ")
                .append(" ,     C.NOME CLIENTE ")
                .append("  FROM animal A ")
                .append("   INNER JOIN usuario U ON U.ID = A.USUARIO ")
                .append("   LEFT JOIN cliente C ON C.ID = A.CLIENTE ")
                .append("   WHERE A.USUARIO = ? ");

        String sql = sqlBuilder.toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setLong(1, user.getId());

            if (preparedStatement.execute()) {

                ResultSet resultSet = preparedStatement.getResultSet();
                while (resultSet.next()) {

                    try {
                        petSize = PetSize.valueOf(resultSet.getString("PORTE"));
                    } catch (Exception exception) {
                        petSize = null;
                    }

                    try {
                        gender = Gender.valueOf(resultSet.getString("SEXO").toUpperCase());
                    } catch (Exception exception) {
                        gender = null;
                    }

                    pets.add(
                            new Pet(
                                    resultSet.getLong("ID"),
                                    resultSet.getString("NOME"),
                                    resultSet.getString("ESPECIE"),
                                    resultSet.getString("RACA"),
                                    resultSet.getString("PELO"),
                                    resultSet.getString("PELAGEM"),
                                    petSize,
                                    resultSet.getDouble("PESO"),
                                    LocalDate.parse(resultSet.getString("NASCIMENTO"), dateTimeFormatter),
                                    LocalDate.parse(resultSet.getString("CADASTRO"), dateTimeFormatter),
                                    resultSet.getBoolean("CASTRADO"),
                                    resultSet.getString("OBSERVACOES"),
                                    gender,
                                    resultSet.getBoolean("CLIENTE_PACOTE"),
                                    new User(resultSet.getLong("USUARIO_ID"), resultSet.getString("USUARIO"), resultSet.getString("SENHA")),
                                    new Owner(resultSet.getLong("CLIENTE_ID"), resultSet.getString("CLIENTE"))
                            )
                    );
                }

            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return pets;
    }

    @Override
    public Pet find(User user, long id) {

        PetSize petSize;
        Gender gender;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder
                .append("   SELECT ")
                .append("       A.ID ")
                .append(" ,     A.NOME ")
                .append(" ,     A.ESPECIE ")
                .append(" ,     A.RACA ")
                .append(" ,     A.PELO ")
                .append(" ,     A.PELAGEM ")
                .append(" ,     A.PORTE ")
                .append(" ,     A.PESO ")
                .append(" ,     A.NASCIMENTO ")
                .append(" ,     A.CADASTRO ")
                .append(" ,     A.CASTRADO ")
                .append(" ,     A.OBSERVACOES ")
                .append(" ,     A.SEXO ")
                .append(" ,     A.CLIENTE_PACOTE ")
                .append(" ,     A.USUARIO USUARIO_ID ")
                .append(" ,     A.CLIENTE CLIENTE_ID ")
                .append(" ,     U.USUARIO ")
                .append(" ,     U.SENHA ")
                .append(" ,     C.NOME CLIENTE ")
                .append("  FROM animal A ")
                .append("   INNER JOIN usuario U ON U.ID = A.USUARIO ")
                .append("   LEFT JOIN cliente C ON C.ID = A.CLIENTE ")
                .append("   WHERE A.USUARIO = ? AND A.ID = ? ");

        String sql = sqlBuilder.toString();

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setLong(1, user.getId());
            preparedStatement.setLong(2, id);

            if (preparedStatement.execute()) {

                ResultSet resultSet = preparedStatement.getResultSet();
                if (resultSet.next()) {

                    try {
                        petSize = PetSize.valueOf(resultSet.getString("PORTE"));
                    } catch (Exception exception) {
                        petSize = null;
                    }

                    try {
                        gender = Gender.valueOf(resultSet.getString("SEXO").toUpperCase());
                    } catch (Exception exception) {
                        gender = null;
                    }

                    return new Pet(
                            resultSet.getLong("ID"),
                            resultSet.getString("NOME"),
                            resultSet.getString("ESPECIE"),
                            resultSet.getString("RACA"),
                            resultSet.getString("PELO"),
                            resultSet.getString("PELAGEM"),
                            petSize,
                            resultSet.getDouble("PESO"),
                            LocalDate.parse(resultSet.getString("NASCIMENTO"), dateTimeFormatter),
                            LocalDate.parse(resultSet.getString("CADASTRO"), dateTimeFormatter),
                            resultSet.getBoolean("CASTRADO"),
                            resultSet.getString("OBSERVACOES"),
                            gender,
                            resultSet.getBoolean("CLIENTE_PACOTE"),
                            new User(resultSet.getLong("USUARIO_ID"), resultSet.getString("USUARIO"), resultSet.getString("SENHA")),
                            new Owner(resultSet.getLong("CLIENTE_ID"), resultSet.getString("CLIENTE"))
                    );
                }

            }

        } catch (SQLException | PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insert(Pet pet) {

        String sql = new StringBuilder()
                .append(" insert into animal ")
                .append(" (nome, especie, raca, pelo, pelagem, porte, peso, nascimento, cadastro, castrado, observacoes, ")
                .append(" sexo, usuario, cliente_pacote, cliente) ")
                .append(" values ")
                .append(" (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ")
                .toString();

        try (PreparedStatement preparedStatement = new Database().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            int index = 1;
            preparedStatement.setString(index++, pet.getName());
            preparedStatement.setString(index++, pet.getSpecies());
            preparedStatement.setString(index++, pet.getBreed());
            preparedStatement.setString(index++, pet.getFur());
            preparedStatement.setString(index++, pet.getPelage());
            preparedStatement.setString(index++, pet.getSize().toString());
            preparedStatement.setDouble(index++, pet.getWeight());
            preparedStatement.setString(index++, pet.getBirth().format(formatter));
            preparedStatement.setString(index++, pet.getRegister().format(formatter));
            preparedStatement.setBoolean(index++, pet.isCastrated());
            preparedStatement.setString(index++, pet.getComments());
            preparedStatement.setString(index++, pet.getGender().toString());
            preparedStatement.setLong(index++, pet.getUser().getId());
            preparedStatement.setBoolean(index++, pet.isClientPacket());
            preparedStatement.setLong(index++, pet.getOwner() != null && pet.getOwner().getId() > 0 ? pet.getOwner().getId() : 0);

            if (preparedStatement.executeUpdate() > 0) {

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    pet.setId(generatedKeys.getLong(1));
                    return true;
                }
            }

        } catch (PropertyVetoException | SQLException e) {
            System.out.println("Erro ao conectar no banco de dados ou inserir pet.");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean remove(Pet pet) {

        String sql = " delete from animal where id = ? ";

        try (PreparedStatement preparedStatement = new Database().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, pet.getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (PropertyVetoException | SQLException e) {
            System.out.println("Erro ao conectar no banco de dados ou remover pet.");
            e.printStackTrace();
        }

        return false;
    }

}
