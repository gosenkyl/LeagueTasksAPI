package com.gosenk.league.tasks.api.service;

import com.gosenk.league.tasks.api.dso.UserChampionDso;
import com.gosenk.league.tasks.api.dto.ChampionDto;
import com.gosenk.league.tasks.api.dto.UserChampionDto;
import com.gosenk.league.tasks.api.repository.UserChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserChampionService {

    @Autowired
    private UserChampionRepository userChampionRepository;

    @Autowired
    private ChampionService championService;

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

    public List<UserChampionDto> getUserChampionListByUserIdAndRoleId(Long userId, String roleId){
        Map<String, UserChampionDto> userChampionMap = new HashMap<>();

        for(UserChampionDso dso : userChampionRepository.findByUserIdAndRoleId(userId, roleId)) {
            UserChampionDto dto = new UserChampionDto();
            dto.setId(dso.getId());
            dto.setChampionId(dso.getChampionId());
            dto.setUserId(dso.getUserId());
            dto.setRoleId(dso.getRoleId());

            dto.setSelected(true);

            userChampionMap.put(dso.getChampionId(), dto);
        }

        List<UserChampionDto> userChampionList = new ArrayList<>();

        for(ChampionDto championDso : championService.getAll()){

            UserChampionDto userChampionDto = userChampionMap.get(championDso.getId());
            if(userChampionDto == null){
                userChampionDto = new UserChampionDto();

                userChampionDto.setId(userId + "-" + championDso.getId() + "-" + roleId);
                userChampionDto.setSelected(false);
                userChampionDto.setChampionId(championDso.getId());
                userChampionDto.setRoleId(roleId);
                userChampionDto.setUserId(userId);
            }

            userChampionList.add(userChampionDto);
        }

        return userChampionList;
    }

}
