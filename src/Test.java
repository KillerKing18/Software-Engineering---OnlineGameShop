import dao.DAOFactory;
import dao.ItemDAO;
import dao.UserDAO;
import transfer.Item;
import transfer.User;

import java.util.List;

public class Test
{

    public static void main(String[] args)
    {

        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.APACHE_DERBY);
        UserDAO userDAO = daoFactory.getUserDAO();

        User user1 = userDAO.getUserByCredentials("user", "pass");
        User user2 = userDAO.getUserByCredentials("dfsf", "");

        ItemDAO itemDAO = daoFactory.getItemDAO();

        List<Item> items = itemDAO.getAllItems();

        if(items != null)
        {
            for(Item item: items)
            {
                System.out.println(item.getId());
                System.out.println(item.getTitle());
                System.out.println(item.getPrice());
                System.out.println(item.getReleaseDate());
                System.out.println(item.getDeveloper());
                System.out.println(item.getNumberOfCopies());
                System.out.println();
            }
        }


        if(user1 != null)
        {
            System.out.println(user1.getId());
            System.out.println(user1.getUsername());
            System.out.println(user1.getPass());
            System.out.println(user1.getDob());
        }
        else
            System.err.println("User1 does not exist");

        if(user2 != null)
        {
            System.out.println(user2.getId());
            System.out.println(user2.getUsername());
            System.out.println(user2.getPass());
            System.out.println(user2.getDob());
        }
        else
            System.err.println("User2 does not exist");



    }




}
