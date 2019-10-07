package com.instantor.dap.springbootbackend.domain.sw.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public final class CharacterDto {
    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String mass;
    private String skinColor;
    private String homeworld;
    private String url;

    private Date created;
    private Date edited;

    private List<String> films = new ArrayList<>();
    private List<String> starships = new ArrayList<>();
    private List<String> species = new ArrayList<>();
    private List<String> vehicles = new ArrayList<>();
}
