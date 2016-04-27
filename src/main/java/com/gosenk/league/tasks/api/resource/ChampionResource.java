package com.gosenk.league.tasks.api.resource;

import com.gosenk.league.tasks.api.dto.ChampionDto;
import com.gosenk.league.tasks.api.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/champions")
@CrossOrigin/*(origins = "http://domain2.com", maxAge = 3600)*/
public class ChampionResource {

    @Autowired
    private ChampionService championService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ChampionDto> getAllChampions(){
        return championService.getAll();
    }

    @RequestMapping(value = "/{championId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ChampionDto getChampionById(@PathVariable String championId){
        return championService.findById(championId);
    }
}
