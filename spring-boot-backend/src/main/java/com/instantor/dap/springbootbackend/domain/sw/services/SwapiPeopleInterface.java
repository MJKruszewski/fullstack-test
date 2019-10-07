package com.instantor.dap.springbootbackend.domain.sw.services;

import org.springframework.web.client.RestClientException;
import pl.sunflux.swapi.model.People;

public interface SwapiPeopleInterface {
    public People getPerson(String id) throws RestClientException;
}
