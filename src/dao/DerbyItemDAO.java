package dao;

import transfer.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DerbyItemDAO implements ItemDAO
{


    @Override
    public List<Item> getAllItems()
    {
        try(Connection connection = DerbyDAOFactory.getConnection()) {

            Statement stmt = connection.createStatement();

            ResultSet result = stmt.executeQuery("SELECT * FROM items");

            List<Item> items = new ArrayList<>();

            while(result.next())
            {
                items.add(mapToItem(result));
            }

            if(items.isEmpty())
                return null;
            else
                return items;

        }
        catch(SQLException e)
        {
            throw new RuntimeException("SQL query error", e);
        }
    }

    @Override
    public Item getItemById(int id)
    {
        return null;
    }

    @Override
    public Item getItemByTitle(String title)
    {
        return null;
    }

    @Override
    public int insertItem(Item item)
    {
        return 0;
    }

    @Override
    public boolean updateItem(Item item)
    {
        return false;
    }

    @Override
    public boolean deleteItem(int id)
    {
        return false;
    }

	@Override
	public List<Item> getItemsBySearch(String searchText) {
	try(Connection connection = DerbyDAOFactory.getConnection()) {

            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM items WHERE LOWER(title) LIKE LOWER(?)"
            );

            stmt.setString(1, "%" + searchText + "%");

            ResultSet result = stmt.executeQuery();
            
            List<Item> items = new ArrayList<>();

            while(result.next())
            {
                items.add(mapToItem(result));
            }

            if(items.isEmpty())
                return null;
            else
                return items;
        }
        catch(SQLException e)
        {
            throw new RuntimeException("SQL query error", e);
        }
	}

	private Item mapToItem(ResultSet result) throws SQLException
    {
        Item item = new Item();
        item.setId(result.getInt("id"));
        item.setTitle(result.getString("title"));
        item.setPrice(result.getDouble("price"));
        item.setReleaseDate(result.getDate("release_date"));
        item.setDeveloper(result.getString("developer"));
        item.setNumberOfCopies(result.getInt("number_of_copies"));
        item.setImagePath(result.getString("image_path"));
        return item;
    }

}
