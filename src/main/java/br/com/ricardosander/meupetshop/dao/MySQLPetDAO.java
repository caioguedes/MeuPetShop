package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.database.Database;
import br.com.ricardosander.meupetshop.model.Owner;
import br.com.ricardosander.meupetshop.model.Pet;
import br.com.ricardosander.meupetshop.model.User;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

                    pets.add(
                            new Pet(
                                    resultSet.getLong("ID"),
                                    resultSet.getString("NOME"),
                                    resultSet.getString("ESPECIE"),
                                    resultSet.getString("RACA"),
                                    resultSet.getString("PELO"),
                                    resultSet.getString("PELAGEM"),
                                    resultSet.getString("PORTE"),
                                    resultSet.getDouble("PESO"),
                                    LocalDate.parse(resultSet.getString("NASCIMENTO"), dateTimeFormatter),
                                    LocalDate.parse(resultSet.getString("CADASTRO"), dateTimeFormatter),
                                    resultSet.getBoolean("CASTRADO"),
                                    resultSet.getString("OBSERVACOES"),
                                    resultSet.getString("SEXO"),
                                    resultSet.getBoolean("CLIENTE_PACOTE"),
                                    new User(resultSet.getLong("USUARIO_ID"), resultSet.getString("USUARIO"), resultSet.getString("SENHA")),
                                    new Owner(resultSet.getLong("CLIENTE_ID"), resultSet.getString("CLIENTE"))
                            )
                    );
                }

            }

        } catch (SQLException | PropertyVetoException  e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return pets;
    }

    @Override
    public Pet find(User user, long id) {

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

                    return new Pet(
                            resultSet.getLong("ID"),
                            resultSet.getString("NOME"),
                            resultSet.getString("ESPECIE"),
                            resultSet.getString("RACA"),
                            resultSet.getString("PELO"),
                            resultSet.getString("PELAGEM"),
                            resultSet.getString("PORTE"),
                            resultSet.getDouble("PESO"),
                            LocalDate.parse(resultSet.getString("NASCIMENTO"), dateTimeFormatter),
                            LocalDate.parse(resultSet.getString("CADASTRO"), dateTimeFormatter),
                            resultSet.getBoolean("CASTRADO"),
                            resultSet.getString("OBSERVACOES"),
                            resultSet.getString("SEXO"),
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
        return false;
    }

}
