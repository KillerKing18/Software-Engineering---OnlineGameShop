package dao;

import transfer.Item;

import java.util.List;

public interface ItemDAO
{

    List<Item> getAllItems();
    List<Item> getItemsBySearch(String searchText);
    Item getItemById(int id);
    Item getItemByTitle(String title);
    int insertItem(Item item);
    boolean updateItem(Item item);
    boolean deleteItem(int id);

}
