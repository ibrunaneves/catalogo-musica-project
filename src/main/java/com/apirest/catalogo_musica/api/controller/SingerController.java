package com.apirest.catalogo_musica.api.controller;

import com.apirest.catalogo_musica.api.dto.SingerCreateDTO;
import com.apirest.catalogo_musica.api.dto.SingerDTO;
import com.apirest.catalogo_musica.domain.entity.Singer;
import com.apirest.catalogo_musica.domain.service.SingerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/singers")
@RequiredArgsConstructor
public class SingerController {

    private final SingerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SingerDTO create(@RequestBody @Valid SingerCreateDTO dto) {
        var saved = service.create(Singer.builder()
                .name(dto.name())
                .build());
        return toDTO(saved);
    }

    @GetMapping("/{id}")
    public SingerDTO findById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @GetMapping
    public List<SingerDTO> findAll() {
        return service.findAll().stream().map(this::toDTO).toList();
    }

    @PutMapping("/{id}")
    public SingerDTO update(@PathVariable Long id, @RequestBody @Valid SingerCreateDTO dto) {
        var updated = service.update(id, Singer.builder()
                .name(dto.name())
                .build());
        return toDTO(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private SingerDTO toDTO(Singer s) {
        return new SingerDTO(s.getId(), s.getName());
    }
}