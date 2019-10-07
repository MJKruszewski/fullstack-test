package com.instantor.dap.springbootbackend.domain.sw.rest;

import com.instantor.dap.springbootbackend.core.dto.ApiErrorResponse;
import com.instantor.dap.springbootbackend.domain.sw.dto.CharacterDto;
import com.instantor.dap.springbootbackend.domain.sw.services.SwapiClientInterface;
import com.instantor.dap.springbootbackend.domain.sw.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/sw")
public class StarWarsCharacterController {

    private final SwapiClientInterface swapiClientInterface;

    @Autowired
    public StarWarsCharacterController(SwapiClientInterface swapiClientInterface) {
        this.swapiClientInterface = swapiClientInterface;
    }

    /**
     * @return character from Star Wars
     */
    @GetMapping("/characters/{id}")
    public CharacterDto getCharacter(@PathVariable String id) {
        return CharacterMapper.MAPPER.toCharacter(
                swapiClientInterface.getPerson(id)
        );
    }

    /**
     * @return random character from Star Wars
     */
    @GetMapping("/characters/random")
    public CharacterDto getCharacter() {
        return CharacterMapper.MAPPER.toCharacter(
                swapiClientInterface.getPerson(getRandom().toString())
        );
    }

    private Integer getRandom() {
        return new Double(((Math.random() * ((200 - 1) + 1)) + 1)).intValue();
    }

    @ExceptionHandler(value = {HttpClientErrorException.class})
    public ApiErrorResponse handleException(HttpClientErrorException exception) {
        return new ApiErrorResponse(
                exception.getStatusCode(),
                exception.getStatusText(),
                exception.getMessage()
        );
    }
}
