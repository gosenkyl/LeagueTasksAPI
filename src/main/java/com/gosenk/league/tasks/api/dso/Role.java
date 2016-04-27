package com.gosenk.league.tasks.api.dso;

import javax.persistence.*;

@Entity
@Table(name="ROLE")
public class Role {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="description")
    private String description;

    @Column(name="lane")
    private String lane;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }
}
