package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.NPCResource;

public interface NPCService {
    // List<NPC> getAllNPCs();

    // NPC getNPCById(long id);

    // NPC createNPC(NPC npc);

    // NPC updateNPC(long id, NPC npc);

    // boolean deleteNPC(long id);

    // NPC save(NPCResource npcResource); 

    List<NPCResource> getAllNPCs();

    NPCResource getNPCById(long id);

    NPCResource saveNPC(NPCResource resource);

    NPCResource updateNPC(long id, NPCResource NPC);

    boolean deleteNPC(long id);
}
