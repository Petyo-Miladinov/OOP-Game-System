package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.NPCResource;
import elsys.oopprojectgame.entity.NPC;

public interface NPCMapper {
    NPCMapper NPC_MAPPER = Mappers.getMapper(NPCMapper.class);

    @Mapping(target = "id", source = "npcResource.id")
    NPC fromNPCResource(NPCResource npcResource);

    @Mapping(target = "id", source = "npc.id")
    NPCResource toNPCResource(NPC npc);

    List<NPCResource> toNPCResourceList(List<NPC> npcs);
}
