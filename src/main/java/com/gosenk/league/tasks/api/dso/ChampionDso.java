package com.gosenk.league.tasks.api.dso;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CHAMPION")
public class ChampionDso {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "key")
    private Long key;

    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
