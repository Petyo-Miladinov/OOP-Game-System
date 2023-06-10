package elsys.oopprojectgame.service.impl;

import static elsys.oopprojectgame.mappers.BossMapper.BOSS_MAPPER;

import java.util.List;

import org.springframework.stereotype.Service;

import elsys.oopprojectgame.controllers.resources.BossResource;
import elsys.oopprojectgame.entity.Boss;
import elsys.oopprojectgame.mappers.BossMapper;
import elsys.oopprojectgame.repository.BossRepository;
import elsys.oopprojectgame.service.BossService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BossServiceImpl implements BossService {
    private final BossRepository bossRepository;
    private final BossMapper bossMapper;

    @Override
    public List<BossResource> getAllBosses() {
        return BOSS_MAPPER.toBossResourceList(bossRepository.findAll());
    }

    @Override
    public BossResource getBossById(long id) {
        return BOSS_MAPPER.toBossResource(bossRepository.getReferenceById((int) id));
    }

    @Override
    public BossResource saveBoss(BossResource resource) {
        Boss boss = bossMapper.fromBossResource(resource); 

        return BOSS_MAPPER.toBossResource(bossRepository.save(boss));
    }

    @Override
    public BossResource updateBoss(long id, BossResource resource) {
        Boss toUpdate = bossRepository.getReferenceById((int) id); 
        toUpdate.setName(resource.getName());

        return BOSS_MAPPER.toBossResource(bossRepository.save(toUpdate));
    }

    @Override
    public boolean deleteBoss(long id) {
        bossRepository.deleteById((int) id);

        return true;
    }

    // private final BossRepository bossRepository;

    // @Override
    // public List<Boss> getAllBosses() {
    //     return bossRepository.findAll();
    // }

    // @Override
    // public Boss getBossById(long id) {
    //     return bossRepository.findById((int) id).orElse(null);
    // }

    // @Override
    // public Boss createBoss(Boss boss) {
    //     return bossRepository.save(boss);
    // }

    // @Override
    // public Boss updateBoss(long id, Boss boss) {
    //     Optional<Boss> existingBoss = bossRepository.findById((int) id);
    //     if (existingBoss.isPresent()) {
    //         boss.setId(id);
    //         return bossRepository.save(boss);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteBoss(long id) {
    //     Optional<Boss> boss = bossRepository.findById((int) id);
    //     if (boss.isPresent()) {
    //         bossRepository.delete(boss.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    // private final BossRepository bossRepository;
    // private final BossService bossService; 

    // @Override
    // public List<BossResource> getAllBosses() {
    //     return BOSS_MAPPER.toBossResource(bossRepository.findAll());
    // }

    // @Override
    // public BossResource getBossById(long id) {
    //     return BOSS_MAPPER.toBossResource(bossRepository.findById((int) id).get());
    // }

    // @Override
    // public BossResource createBoss(BossResource boss) {
    //     return bossRepository.save(boss);
    // }

    // @Override
    // public BossResource updateBoss(long id, BossResource boss) {
    //     Optional<Boss> existingBoss = bossRepository.findById((int) id);
    //     if (existingBoss.isPresent()) {
    //         boss.setId(id);
    //         return bossRepository.save(boss);
    //     } else {
    //         return null;
    //     }
    // }

    // @Override
    // public boolean deleteBoss(long id) {
    //     Optional<Boss> boss = bossRepository.findById((int) id);
    //     if (boss.isPresent()) {
    //         bossRepository.delete(boss.get());
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
}
