package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dso.UserChampionDso;
import com.gosenk.league.tasks.api.dto.UserChampionDto;
import com.gosenk.league.tasks.api.repository.UserChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserChampionService {

    @Autowired
    private UserChampionRepository userChampionRepository;

    public List<UserChampionDto> getUserChampionListByUserId(Long userId){
        List<UserChampionDto> userChampionList = new ArrayList<>();

        for(UserChampionDso dso : userChampionRepository.findByUserId(userId)) {
            UserChampionDto dto = new UserChampionDto();
            dto.setId(dso.getId());
            dto.setChampionId(dso.getChampionId());
            dto.setUserId(dso.getUserId());
            dto.setRoleId(dso.getRoleId());

            userChampionList.add(dto);
        }

        return userChampionList;
    }

}
