package elsys.oopprojectgame.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import elsys.oopprojectgame.controllers.resources.BossResource;
import elsys.oopprojectgame.entity.Boss;

@Mapper
public interface BossMapper {
    BossMapper BOSS_MAPPER = Mappers.getMapper(BossMapper.class);

    @Mapping(target = "id", source = "bossResource.id")
    Boss fromBossResource(BossResource bossResource); 

    @Mapping(target = "id", source = "boss.id")
    BossResource toBossResource(Boss boss);

    List<BossResource> toBossResourceList(List<Boss> bosses);
}
