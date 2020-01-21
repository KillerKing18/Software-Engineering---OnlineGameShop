package businesslogic;

import dao.DAOFactory;
import dao.UserDAO;
import transfer.User;

public class UserLogic {

    private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.APACHE_DERBY);
    
    protected User user;
    
    public boolean LogIn(String name, String password) {
    	
    	UserDAO userDAO = daoFactory.getUserDAO();
    	
    	User user = userDAO.getUserByCredentials(name, password);
    	
    	this.user = user;
    	
    	return this.user != null;
	}

    public User getUser() {
    	return user;
    }
    
    public void LogOut() {
    	user = null;
    }
}
