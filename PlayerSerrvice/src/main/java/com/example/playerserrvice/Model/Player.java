package com.example.playerserrvice.Model;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Player {

    @ApiModelProperty(notes = "Name of the Player",name="name",required=true,value="player 1")
    private String name;
    @ApiModelProperty(notes = "Id of the player",name="id",required=true,value="12345")
    private int id;

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Player [name=" + name +  ", id=" + id + "]";
    }

}
