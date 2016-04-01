package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dao.IGenericDAO;
import com.gosenk.league.tasks.api.model.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn=Exception.class)
public class ChampionServiceImpl {

    @Autowired
    private IGenericDAO genericDAO;

    public void saveChampion(Champion champion){

        genericDAO.saveOrUpdate(champion);

    }

}
