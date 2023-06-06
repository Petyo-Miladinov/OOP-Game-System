package elsys.oopprojectgame.service;

import java.util.List;

// import elsys.oopprojectgame.controllers.resources.NPCResource;
import elsys.oopprojectgame.entity.NPC;

public interface NPCService {
    List<NPC> getAllNPCs();

    NPC getNPCById(long id);

    NPC createNPC(NPC npc);

    NPC updateNPC(long id, NPC npc);

    boolean deleteNPC(long id);

    // NPC save(NPCResource npcResource); 
}
