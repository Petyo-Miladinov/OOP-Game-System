package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.Item;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(long id);

    Item createItem(Item item);

    Item updateItem(long id, Item item);

    boolean deleteItem(long id);
}
