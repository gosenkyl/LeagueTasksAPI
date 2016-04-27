package com.gosenk.league.tasks.api.repository;


import com.gosenk.league.tasks.api.dso.ChampionDso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends CrudRepository<ChampionDso, String> {


}
