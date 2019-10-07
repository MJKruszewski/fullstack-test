package com.instantor.dap.springbootbackend.domain.sw.services;

import org.springframework.web.client.RestClientException;
import pl.sunflux.swapi.model.Planet;

public interface SwapiPlanetInterface {
    public Planet getPlanet(String id) throws RestClientException;
}
