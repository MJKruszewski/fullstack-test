package com.instantor.dap.springbootbackend.domain.sw.services;

import org.springframework.web.client.RestClientException;
import pl.sunflux.swapi.model.StarShip;

public interface SwapiStarshipInterface {
    public StarShip getStarship(String id) throws RestClientException;
}
