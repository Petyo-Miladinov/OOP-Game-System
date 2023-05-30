package elsys.oopprojectgame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.repository.ItemRepository;
import elsys.oopprojectgame.service.ItemService;

public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.findById((int) id).orElse(null);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(long id, Item item) {
        Optional<Item> existingItem = itemRepository.findById((int) id);
        if (existingItem.isPresent()) {
            item.setId(id);
            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteItem(long id) {
        Optional<Item> item = itemRepository.findById((int) id);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
            return true;
        } else {
            return false;
        }
    }
}
