package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.ItemResource;

public interface ItemService {
    // List<Item> getAllItems();

    // Item getItemById(long id);

    // Item createItem(Item item);

    // Item updateItem(long id, Item item);

    // boolean deleteItem(long id);

    List<ItemResource> getAllItems();

    ItemResource getItemById(long id);

    ItemResource saveItem(ItemResource resource);

    ItemResource updateItem(long id, ItemResource item);

    boolean deleteItem(long id);
}
