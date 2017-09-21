package br.com.ricardosander.meupetshop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar as conexões com o banco de dados.
 */
public class Database {

    /**
     * Cria e retorna uma nova conexão com o banco de dados.
     * @return Conexão com o banco de dados.
     * @throws SQLException Erro ao realizar conexão com o banco de dados.
     */
    public static Connection getConnection() throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/meupetshop", "root", "123");
    }

}
