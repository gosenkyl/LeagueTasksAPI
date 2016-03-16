package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dao.IGenericDAO;
import com.gosenk.league.tasks.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn=Exception.class)
public class UserServiceImpl implements IUserService{

    @Autowired
    private IGenericDAO genericDAO;

    @Override
    public List<User> getAllUsers(){
        return genericDAO.getAll(User.class);
    }

}
