package br.com.ricardosander.meupetshop.dao;

import br.com.ricardosander.meupetshop.database.Database;
import br.com.ricardosander.meupetshop.model.User;

import java.beans.PropertyVetoException;
import java.sql.*;

/**
 * Implementação MySQL para DAO de usuário.
 */
public class MySQLUserDAO implements UserDAO {

    @Override
    public User find(String email, String senha) {

        String sql = "select id, usuario, senha from usuario where usuario = ? and senha = ?";

        try (
                Connection connection = new Database().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            if (preparedStatement.execute()) {

                ResultSet resultSet = preparedStatement.getResultSet();
                if (resultSet.next()) {
                    return new User(
                            resultSet.getLong("id"),
                            resultSet.getString("usuario"),
                            resultSet.getString("senha")
                    );
                }
            }

        } catch (SQLException |PropertyVetoException e) {
            System.out.println("Erro ao conectar no banco de dados ou realizar query.");
            e.printStackTrace();
        }

        return null;
    }

}
