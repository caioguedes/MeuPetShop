package br.com.ricardosander.meupetshop.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Represents and controls a MongoDB database connection.
 */
public class DatabaseMongoDB {

    /**
     * MongoDB database connection.
     */
    private static MongoDatabase database;

    /**
     * Singleton
     */
    private DatabaseMongoDB() {

    }

    /**
     * Return a single MongoDB database instance.
     * @return
     */
    public static synchronized MongoDatabase getInstance() {

        if (database == null) {

            Properties properties = loadProperties();

            String host = properties.getProperty("host");
            int port = Integer.parseInt(properties.getProperty("port"));
            String database = properties.getProperty("database");

            MongoClient client = new MongoClient(new MongoClientURI("mongodb://" + host + ":" + port));
            DatabaseMongoDB.database = client.getDatabase(database);
        }

        return database;
    }

    /**
     * Loads properties collections from a file.
     * @return MongoDB connection properties.
     */
    private static Properties loadProperties() {

        File file = new File("connections.properties");
        if (!file.exists() || file.isDirectory()) {

            System.out.println("Database configuration file was not found.");
            System.out.println("Stopping application.");
            System.exit(0);

        }

        Properties properties = new Properties();

        try {

            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);

        } catch (Exception e) {

            System.out.println("A error have happen whe trying to load the database configuration file.");
            System.out.println("Stopping aplication.");
            e.printStackTrace();
            System.exit(0);
        }

        return properties;
    }

}
