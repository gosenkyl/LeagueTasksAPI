package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dao.IGenericDAO;
import com.gosenk.league.tasks.api.model.UserChampion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackOn=Exception.class)
public class UserChampionServiceImpl {

    @Autowired
    private IGenericDAO genericDAO;

    public List<UserChampion> getChampsByUserId(Long id, String champ){
        String query = "from UserChampion where user.id = :id and championId = :champ";
        HashMap params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("champ", champ);
        return genericDAO.findByQuery(query, params, UserChampion.class);
    }
}
