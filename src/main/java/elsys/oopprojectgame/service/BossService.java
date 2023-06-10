package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.controllers.resources.BossResource;

public interface BossService {
    // List<Boss> getAllBosses();

    // Boss getBossById(long id);

    // Boss createBoss(Boss boss);

    // Boss updateBoss(long id, Boss boss);

    // boolean deleteBoss(long id);

    List<BossResource> getAllBosses();

    BossResource getBossById(long id);

    // BossResource createBoss(BossResource boss); 

    BossResource saveBoss(BossResource resource);

    BossResource updateBoss(long id, BossResource boss);

    boolean deleteBoss(long id);
}
