package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dso.ChampionDso;
import com.gosenk.league.tasks.api.dto.ChampionDto;
import com.gosenk.league.tasks.api.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampionService {

    @Autowired
    private ChampionRepository championRepository;

    public ChampionDto findById(String id){
        ChampionDso dso = championRepository.findOne(id);

        ChampionDto dto = null;
        if(dso != null) {
            dto = new ChampionDto();
            dto.setId(dso.getId());
            dto.setTitle(dso.getTitle());
            dto.setImage(dso.getImage());
            dto.setKey(dso.getKey());
            dto.setName(dso.getName());
        }

        return dto;
    }

    public List<ChampionDto> getAll(){
        Iterable<ChampionDso> dsoList = championRepository.findAll();

        List<ChampionDto> dtoList = new ArrayList<>();

        for(ChampionDso dso : dsoList){
            ChampionDto dto = new ChampionDto();

            dto.setId(dso.getId());
            dto.setKey(dso.getKey());
            dto.setName(dso.getName());
            dto.setImage(dso.getImage());
            dto.setTitle(dso.getTitle());

            dtoList.add(dto);
        }

        return dtoList;
    }


}
