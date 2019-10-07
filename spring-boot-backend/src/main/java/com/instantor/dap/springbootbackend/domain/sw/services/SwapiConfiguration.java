package com.instantor.dap.springbootbackend.domain.sw.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Getter
final class SwapiConfiguration {

    private String clientUrl;
    private Duration readTimeout;

    @Value("${swapi.client.url}")
    public void setClientApiUrl(String clientApiUrl) {
        this.clientUrl = clientApiUrl;
    }

    @Value("${swapi.client.timeout}")
    public void setClientApiUrl(Long timeout) {
        this.readTimeout = Duration.ofMillis(timeout);
    }
}
