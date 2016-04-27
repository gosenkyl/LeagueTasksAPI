package com.gosenk.league.tasks.api.resource;

import com.gosenk.league.tasks.api.dto.ChampionDto;
import com.gosenk.league.tasks.api.util.PositionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userchampions")
@CrossOrigin
public class UserChampionResource {

    @Autowired
    private PositionManager positionManager;

    @RequestMapping(value = "available/{userId}/{roleId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ChampionDto> getAvailableChampionsByUserId(@PathVariable long userId, @PathVariable String roleId){
        positionManager.filterUserChampionByRole(userId);
        List<ChampionDto> test = positionManager.getAvailableList(roleId.toUpperCase());
        return test;
    }

    @RequestMapping(value = "selected/{userId}/{roleId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ChampionDto> getSelectedChampionsByUserId(@PathVariable long userId, @PathVariable String roleId){
        positionManager.filterUserChampionByRole(userId);
        List<ChampionDto> test = positionManager.getSelectedList(roleId.toUpperCase());
        return test;
    }

}
