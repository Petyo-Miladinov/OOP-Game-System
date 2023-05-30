package elsys.oopprojectgame.service;

import java.util.List;

import elsys.oopprojectgame.entity.Boss;

public interface BossService {
    List<Boss> getAllBosses();

    Boss getBossById(long id);

    Boss createBoss(Boss boss);

    Boss updateBoss(long id, Boss boss);

    boolean deleteBoss(long id);
}
