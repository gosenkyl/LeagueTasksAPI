package com.gosenk.league.tasks.api.service;


import com.gosenk.league.tasks.api.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User getUserById(int id);

}
