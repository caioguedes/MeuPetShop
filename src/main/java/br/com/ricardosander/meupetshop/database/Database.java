package br.com.ricardosander.meupetshop.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

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

            String host = null;
            int port = 0;
            String database = null;
            String user = null;
            String password = null;

            File file = new File("connections.properties");
            if (!file.exists() || file.isDirectory()) {

                System.out.println("Arquivo de configuração do banco de dados não encontrado.");
                System.out.println("Parando aplicação.");
                System.exit(0);

            }


            try {

                FileInputStream fileInputStream = new FileInputStream(file);

                Properties properties = new Properties();

                properties.load(fileInputStream);

                host = properties.getProperty("host");
                port = Integer.parseInt(properties.getProperty("port"));
                database = properties.getProperty("database");
                user = properties.getProperty("user");
                password = properties.getProperty("password");

            } catch (Exception e) {

                System.out.println("Erro ao ler propriedades da conexão com o banco de dados.");
                System.out.println("Parando aplicação.");
                e.printStackTrace();
                System.exit(0);
            }

            ComboPooledDataSource pool = new ComboPooledDataSource();
            pool.setDriverClass("com.mysql.jdbc.Driver");
            pool.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
            pool.setUser(user);
            pool.setPassword(password);
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
