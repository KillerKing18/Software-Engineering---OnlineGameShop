package dao;

public abstract class DAOFactory
{
    // here more of the database factories can be specified later (in example 'oracle')
    public static final int APACHE_DERBY = 0;

    // abstract methods to return concrete DAO classes
    public abstract UserDAO getUserDAO();
    public abstract ItemDAO getItemDAO();

    // method to get the concrete dao factory
    public static DAOFactory getDAOFactory(int factory)
    {
        switch(factory)
        {
            case APACHE_DERBY:
                return new DerbyDAOFactory();
            default:
                return null;
        }
    }

}
