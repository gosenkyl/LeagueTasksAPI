package com.gosenk.league.tasks.api.util;

import com.gosenk.league.tasks.api.dto.ChampionDto;
import com.gosenk.league.tasks.api.dto.UserChampionDto;
import com.gosenk.league.tasks.api.service.ChampionService;
import com.gosenk.league.tasks.api.service.UserChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PositionManager {

    @Autowired
    private ChampionService championService;

    private static List<ChampionDto> allChampList = new ArrayList<>();
    private static Map<String, ChampionDto> champMap = new HashMap<>();

    @PostConstruct
    public void initialize(){
        this.allChampList = championService.getAll();
        populateChampMap();
    }

    @Autowired
    private UserChampionService userChampionService;

    private List<ChampionDto> availableTopList = new ArrayList<>();
    private List<ChampionDto> availableMidList = new ArrayList<>();
    private List<ChampionDto> availableJungleList = new ArrayList<>();
    private List<ChampionDto> availableAdcList = new ArrayList<>();
    private List<ChampionDto> availableSupportList = new ArrayList<>();

    private List<ChampionDto> selectedTopList = new ArrayList<>();
    private List<ChampionDto> selectedMidList = new ArrayList<>();
    private List<ChampionDto> selectedJungleList = new ArrayList<>();
    private List<ChampionDto> selectedAdcList = new ArrayList<>();
    private List<ChampionDto> selectedSupportList = new ArrayList<>();

    public List<UserChampionDto> getChampionListForUser(Long userId){
        return userChampionService.getUserChampionListByUserId(userId);
    }

    public void filterUserChampionByRole(Long userId){
        initializeChampionLists();

        for(UserChampionDto dto : getChampionListForUser(userId)){

            ChampionDto championDto = champMap.get(dto.getChampionId());

            switch(dto.getRoleId()){
                case "TOP":
                    availableTopList.remove(championDto);
                    selectedTopList.add(championDto);
                    break;
                case "MID":
                    availableMidList.remove(championDto);
                    selectedMidList.add(championDto);
                    break;
                case "JUNGLE":
                    availableJungleList.remove(championDto);
                    selectedJungleList.add(championDto);
                    break;
                case "ADC":
                    availableAdcList.remove(championDto);
                    selectedAdcList.add(championDto);
                    break;
                case "SUPP":
                    availableSupportList.remove(championDto);
                    selectedSupportList.add(championDto);
                    break;
                default:
                    break;
            }
        }
    }

    public List<ChampionDto> getAvailableList(String roleId){
        switch(roleId){
            case "TOP":
                return getAvailableTopList();
            case "MID":
                return getAvailableMidList();
            case "JUNGLE":
                return getAvailableJungleList();
            case "ADC":
                return getAvailableAdcList();
            case "SUPP":
                return getAvailableSupportList();
            default:
                return new ArrayList<>();
        }
    }

    public List<ChampionDto> getSelectedList(String roleId){
        switch(roleId){
            case "TOP":
                return getSelectedTopList();
            case "MID":
                return getSelectedMidList();
            case "JUNGLE":
                return getSelectedJungleList();
            case "ADC":
                return getSelectedAdcList();
            case "SUPP":
                return getSelectedSupportList();
            default:
                return new ArrayList<>();
        }
    }

    private void populateChampMap(){
        champMap = new HashMap<>();

        for(ChampionDto dto : allChampList) {
            champMap.put(dto.getId(), dto);
        }
    }

    private void initializeChampionLists(){
        availableTopList.clear();
        availableMidList.clear();
        availableJungleList.clear();
        availableAdcList.clear();
        availableSupportList.clear();

        availableTopList.addAll(allChampList);
        availableMidList.addAll(allChampList);
        availableJungleList.addAll(allChampList);
        availableAdcList.addAll(allChampList);
        availableSupportList.addAll(allChampList);

        selectedTopList.clear();
        selectedMidList.clear();
        selectedJungleList.clear();
        selectedAdcList.clear();
        selectedSupportList.clear();
    }

    public List<ChampionDto> getSelectedSupportList() {
        return selectedSupportList;
    }

    public List<ChampionDto> getAvailableTopList() {
        return availableTopList;
    }

    public List<ChampionDto> getAvailableMidList() {
        return availableMidList;
    }

    public List<ChampionDto> getAvailableJungleList() {
        return availableJungleList;
    }

    public List<ChampionDto> getAvailableAdcList() {
        return availableAdcList;
    }

    public List<ChampionDto> getAvailableSupportList() {
        return availableSupportList;
    }

    public List<ChampionDto> getSelectedTopList() {
        return selectedTopList;
    }

    public List<ChampionDto> getSelectedMidList() {
        return selectedMidList;
    }

    public List<ChampionDto> getSelectedJungleList() {
        return selectedJungleList;
    }

    public List<ChampionDto> getSelectedAdcList() {
        return selectedAdcList;
    }
}
