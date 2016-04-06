package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dao.IGenericDAO;
import com.gosenk.league.tasks.api.model.Champion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackOn=Exception.class)
public class ChampionServiceImpl {

    @Autowired
    private IGenericDAO genericDAO;

    public void saveChampion(Champion champion){
        genericDAO.saveOrUpdate(champion);
    }

    public List<Champion> getChampsByUserAndRole(Long userId, String roleId){

        String query = "from Champion c left join c.userChampions uc left join uc.user u where (u.id is null or u.id = :userId) order by c.name asc";/*left join c.userChampions uc left join uc.user u where (u.id is null or u.id = 200)";*/
        HashMap params = new HashMap<String, Object>();
        params.put("userId", userId);

        return genericDAO.findByQuery(query, params, Champion.class);
    }

}
