package com.gosenk.league.tasks.api;

import com.gosenk.league.tasks.api.model.User;
import com.gosenk.league.tasks.api.model.UserChampion;
import com.gosenk.league.tasks.api.service.IUserService;
import com.gosenk.league.tasks.api.service.UserChampionServiceImpl;
import com.gosenk.league.tasks.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
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

    @RequestMapping(value = "users/{id}/champs", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UserChampion> userChampions(@PathVariable("id") Long id){
        return userChampionService.getChampsByUserId(id);
    }
}
