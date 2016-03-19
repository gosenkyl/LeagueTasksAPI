package com.gosenk.league.tasks.api;

import com.gosenk.league.tasks.api.model.User;
import com.gosenk.league.tasks.api.model.UserChampion;
import com.gosenk.league.tasks.api.service.IUserService;
import com.gosenk.league.tasks.api.service.UserChampionServiceImpl;
import com.gosenk.league.tasks.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin/*(origins = "http://domain2.com", maxAge = 3600)*/

public class MainController {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserChampionServiceImpl userChampionService;

    @RequestMapping(value = "users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> allUsers(){
        List<User> userList = userService.getAllUsers();

        return userList;
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public User user(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = {"users/{id}/champs", "users/{id}/champs/{champ}"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserChampion> userChampions(@PathVariable("id") Long id, @PathVariable("champ") String champ){
        return userChampionService.getChampsByUserId(id, champ);
    }

 /*   @RequestMapping(value = "users/{id}/champs/{champ}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserChampion userChamp(@PathVariable("id") Long id, @PathVariable("champ") String champ){
        return userChampionService.getChampByUserId(id);
    }*/
}
