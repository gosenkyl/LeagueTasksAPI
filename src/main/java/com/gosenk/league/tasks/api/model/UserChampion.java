package com.gosenk.league.tasks.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "USER_CHAMPION")
public class UserChampion {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "champion_id")
    private String championId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChampionId() {
        return championId;
    }

    public void setChampionId(String championId) {
        this.championId = championId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}