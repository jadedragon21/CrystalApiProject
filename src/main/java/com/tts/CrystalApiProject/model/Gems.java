package com.tts.CrystalApiProject.model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//TODO Add gems class to the swagger, runner database
@Entity
public class Gems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ApiModelProperty(notes = "The color of the gem" )
    private String color;

    @Size(max=20)
    @ApiModelProperty(notes = "The name of the gem" )
    private String name;



    //getters&setters
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //constructors
//    public Crystal(String color, String name) {
//        this.color = color;
//        this.name = name;
//    }
    public Gems(long l, String color, String name) {
        this.color = color;
        this.name = name;
    }
    public Gems() {
    }


}

