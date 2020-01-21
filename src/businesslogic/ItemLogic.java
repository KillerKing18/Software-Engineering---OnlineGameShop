package businesslogic;

import java.util.List;
import dao.DAOFactory;
import dao.ItemDAO;
import transfer.Item;

public class ItemLogic {
	private DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.APACHE_DERBY);

    
	public List<Item> browse(String searchText){

        ItemDAO itemDAO = daoFactory.getItemDAO();

        List<Item> items = itemDAO.getItemsBySearch(searchText);

        return items;
    }

}
