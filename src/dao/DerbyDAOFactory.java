package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyDAOFactory extends DAOFactory
{

    public static final String URL = "jdbc:derby:sampleDB;create=true";
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    // method to get the connection to database
    public static Connection getConnection()
    {
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL);
            return connection;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new RuntimeException("Error while connecting to the database", e);
        }
    }


    @Override
    public UserDAO getUserDAO()
    {
        return new DerbyUserDAO();
    }

    @Override
    public ItemDAO getItemDAO()
    {
        return new DerbyItemDAO();
    }
}
