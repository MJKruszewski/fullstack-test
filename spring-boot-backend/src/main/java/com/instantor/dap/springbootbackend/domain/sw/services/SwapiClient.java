package com.instantor.dap.springbootbackend.domain.sw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.sunflux.swapi.model.Films;
import pl.sunflux.swapi.model.People;
import pl.sunflux.swapi.model.Planet;
import pl.sunflux.swapi.model.StarShip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
final class SwapiClient implements SwapiClientInterface {

    private final Pattern pattern = Pattern.compile("[0-9]+");
    private final RestTemplate restTemplate;

    @Autowired
    public SwapiClient(RestTemplateBuilder restTemplateBuilder, SwapiConfiguration configuration) {
        this.restTemplate = restTemplateBuilder
                .rootUri(configuration.getClientUrl())
                .setReadTimeout(configuration.getReadTimeout())
                .build();
    }

    public StarShip getStarship(String id) throws RestClientException {
        return this.restTemplate.getForObject("/starships/{id}", StarShip.class, id);
    }

    public Planet getPlanet(String id) throws RestClientException {
        return this.restTemplate.getForObject("/planets/{id}", Planet.class, id);
    }

    public Films getFilm(String id) throws RestClientException {
        return this.restTemplate.getForObject("/films/{id}", Films.class, id);
    }

    public People getPerson(String id) throws RestClientException {
        People people = this.restTemplate.getForObject("/people/{id}", People.class, id);

        people.setFilms(people.getFilms().stream().map(this::matchToPattern).collect(Collectors.toList()));
        people.setStarships(people.getStarships().stream().map(this::matchToPattern).collect(Collectors.toList()));
        people.setVehicles(people.getVehicles().stream().map(this::matchToPattern).collect(Collectors.toList()));
        people.setSpecies(people.getSpecies().stream().map(this::matchToPattern).collect(Collectors.toList()));
        people.setHomeworld(matchToPattern(people.getHomeworld()));

        return people;
    }

    private String matchToPattern(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return matcher.group();
        }
        return s;
    }

}
