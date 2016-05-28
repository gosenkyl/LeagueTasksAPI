package com.gosenk.league.tasks.api.dso;

import javax.persistence.*;

@Entity
@Table(name = "USER_CHAMPION")
public class UserChampionDso {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "champion_id")
    private String championId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "role_id")
    private String roleId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}