package com.gosenk.league.tasks.api;

import com.gosenk.league.tasks.api.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class MainController {

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> user(){
        List<User> userList = new ArrayList<>();

        userList.add(new User("AckmedJones"));
        userList.add(new User("User2"));

        return userList;
    }

}
