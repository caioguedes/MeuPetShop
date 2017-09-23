package br.com.ricardosander.meupetshop.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar as conexões com o banco de dados.
 */
public class Database {

    /**
     * Pool de conexões.
     */
    private static DataSource pool;

    public Database() throws SQLException, PropertyVetoException {

        if (Database.pool == null) {

            ComboPooledDataSource pool = new ComboPooledDataSource();
            pool.setDriverClass("com.mysql.jdbc.Driver");
            pool.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/meupetshop");
            pool.setUser("root");
            pool.setPassword("123");
            pool.setMinPoolSize(1);
            pool.setAcquireIncrement(5);
            pool.setMaxPoolSize(20);

            Database.pool = pool;
        }

    }

    /**
     * Cria e retorna uma nova conexão com o banco de dados.
     *
     * @return Conexão com o banco de dados.
     * @throws SQLException Erro ao realizar conexão com o banco de dados.
     */
    public Connection getConnection() throws SQLException {
        return Database.pool.getConnection();
    }

}
