package com.gosenk.league.tasks.api.repository;

import com.gosenk.league.tasks.api.dso.UserChampionDso;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserChampionRepository extends Repository<UserChampionDso, Long> {

    List<UserChampionDso> findByUserId(Long userId);

}
