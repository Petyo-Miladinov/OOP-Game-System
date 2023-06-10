package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.NPCMapper.NPC_MAPPER;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.NPCResource;
// import elsys.oopprojectgame.controllers.resources.NPCResource;
import elsys.oopprojectgame.entity.NPC;
import elsys.oopprojectgame.mappers.NPCMapper;
// import elsys.oopprojectgame.mappers.NPCMapper;
import elsys.oopprojectgame.repository.NPCRepository;
import elsys.oopprojectgame.service.NPCService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NPCServiceImpl implements NPCService {
    private final NPCRepository npcRepository;
    private final NPCMapper npcMapper; 

    @Override
    public List<NPCResource> getAllNPCs() {
        return NPC_MAPPER.toNPCResourceList(npcRepository.findAll());
    }

    @Override
    public NPCResource getNPCById(long id) {
        return NPC_MAPPER.toNPCResource(npcRepository.getReferenceById((int) id));
    }

    @Override
    public NPCResource saveNPC(NPCResource resource) {
        NPC NPC = npcMapper.fromNPCResource(resource); 

        return NPC_MAPPER.toNPCResource(npcRepository.save(NPC));
    }

    @Override
    public NPCResource updateNPC(long id, NPCResource resource) {
        NPC toUpdate = npcRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return NPC_MAPPER.toNPCResource(npcRepository.save(toUpdate));
    }

    @Override
    public boolean deleteNPC(long id) {
        npcRepository.deleteById((int) id);

        return true;
    }

    // @Override
    // public List<NPC> getAllNPCs() {
    //     return npcRepository.findAll();
    // }

    // @Override
    // public NPC getNPCById(long id) {
    //     return npcRepository.findById((int) id).orElse(null);
    // }

    // @Override
    // public NPC createNPC(NPC npc) {
    //     return npcRepository.save(npc);
    // }

    // @Override
    // public NPC updateNPC(long id, NPC npc) {
    //     Optional<NPC> existingNPC = npcRepository.findById((int) id);
    //     if (existingNPC.isPresent()) {
    //         npc.setId(id);
    //         return npcRepository.save(npc);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteNPC(long id) {
    //     Optional<NPC> npc = npcRepository.findById((int) id);
    //     if (npc.isPresent()) {
    //         npcRepository.delete(npc.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    // @Override
    // public NPCResource save(NPCResource npcResource) {
    //     NPC npc = NPC_MAPPER.fromNPCResource(npcResource); 
    // }
}
