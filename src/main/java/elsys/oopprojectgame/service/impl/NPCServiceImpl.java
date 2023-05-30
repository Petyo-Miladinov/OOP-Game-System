package elsys.oopprojectgame.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import elsys.oopprojectgame.entity.NPC;
import elsys.oopprojectgame.repository.NPCRepository;
import elsys.oopprojectgame.service.NPCService;

public class NPCServiceImpl implements NPCService {
    private final NPCRepository npcRepository;

    @Autowired
    public NPCServiceImpl(NPCRepository npcRepository) {
        this.npcRepository = npcRepository;
    }

    @Override
    public List<NPC> getAllNPCs() {
        return npcRepository.findAll();
    }

    @Override
    public NPC getNPCById(long id) {
        return npcRepository.findById((int) id).orElse(null);
    }

    @Override
    public NPC createNPC(NPC npc) {
        return npcRepository.save(npc);
    }

    @Override
    public NPC updateNPC(long id, NPC npc) {
        Optional<NPC> existingNPC = npcRepository.findById((int) id);
        if (existingNPC.isPresent()) {
            npc.setId(id);
            return npcRepository.save(npc);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteNPC(long id) {
        Optional<NPC> npc = npcRepository.findById((int) id);
        if (npc.isPresent()) {
            npcRepository.delete(npc.get());
            return true;
        } else {
            return false;
        }
    }
}
