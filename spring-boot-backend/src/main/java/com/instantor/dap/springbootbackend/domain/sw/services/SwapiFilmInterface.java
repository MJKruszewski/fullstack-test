package com.instantor.dap.springbootbackend.domain.sw.services;

import org.springframework.web.client.RestClientException;
import pl.sunflux.swapi.model.Films;

public interface SwapiFilmInterface {
    public Films getFilm(String id) throws RestClientException;
}
