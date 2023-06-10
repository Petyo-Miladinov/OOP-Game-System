package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.ItemMapper.ITEM_MAPPER;

import java.util.List;

import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.ItemResource;
import elsys.oopprojectgame.entity.Item;
import elsys.oopprojectgame.mappers.ItemMapper;
import elsys.oopprojectgame.repository.ItemRepository;
import elsys.oopprojectgame.service.ItemService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemResource> getAllItems() {
        return ITEM_MAPPER.toItemResourceList(itemRepository.findAll());
    }

    @Override
    public ItemResource getItemById(long id) {
        return ITEM_MAPPER.toItemResource(itemRepository.getReferenceById((int) id));
    }

    @Override
    public ItemResource saveItem(ItemResource resource) {
        Item Item = itemMapper.fromItemResource(resource); 

        return ITEM_MAPPER.toItemResource(itemRepository.save(Item));
    }

    @Override
    public ItemResource updateItem(long id, ItemResource resource) {
        Item toUpdate = itemRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return ITEM_MAPPER.toItemResource(itemRepository.save(toUpdate));
    }

    @Override
    public boolean deleteItem(long id) {
        itemRepository.deleteById((int) id);

        return true;
    }

    // private final ItemRepository itemRepository;

    // @Autowired
    // public ItemServiceImpl(ItemRepository itemRepository) {
    //     this.itemRepository = itemRepository;
    // }

    // @Override
    // public List<Item> getAllItems() {
    //     return itemRepository.findAll();
    // }

    // @Override
    // public Item getItemById(long id) {
    //     return itemRepository.findById((int) id).orElse(null);
    // }

    // @Override
    // public Item createItem(Item item) {
    //     return itemRepository.save(item);
    // }

    // @Override
    // public Item updateItem(long id, Item item) {
    //     Optional<Item> existingItem = itemRepository.findById((int) id);
    //     if (existingItem.isPresent()) {
    //         item.setId(id);
    //         return itemRepository.save(item);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteItem(long id) {
    //     Optional<Item> item = itemRepository.findById((int) id);
    //     if (item.isPresent()) {
    //         itemRepository.delete(item.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
