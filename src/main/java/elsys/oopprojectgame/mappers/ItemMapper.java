package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.ItemResource;
import elsys.oopprojectgame.entity.Item;

public interface ItemMapper {
    ItemMapper ITEM_MAPPER = Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "id", source = "itemResource.id")
    Item fromItemResource(ItemResource itemResource);

    @Mapping(target = "id", source = "item.id")
    ItemResource toItemResource(Item item);

    List<ItemResource> toItemResourceList(List<Item> items);
}
