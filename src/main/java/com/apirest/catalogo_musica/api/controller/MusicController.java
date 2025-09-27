package com.apirest.catalogo_musica.api.controller;

import com.apirest.catalogo_musica.api.dto.MusicCreateDTO;
import com.apirest.catalogo_musica.api.dto.MusicDTO;
import com.apirest.catalogo_musica.domain.entity.Music;
import com.apirest.catalogo_musica.domain.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/musics")
@RequiredArgsConstructor
public class MusicController {

    private final MusicService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicDTO create(@RequestBody @Valid MusicCreateDTO dto) {
        var saved = service.create(dto.title(), dto.id());
        return toDTO(saved);
    }

    @GetMapping("/{id}")
    public MusicDTO findById(@PathVariable Long id) {
        return toDTO(service.findById(id));
    }

    @GetMapping
    public List<MusicDTO> findAll() {
        return service.findAll().stream().map(this::toDTO).toList();
    }

    @PutMapping("/{id}")
    public MusicDTO update(@PathVariable Long id, @RequestBody @Valid MusicCreateDTO dto) {
        var updated = service.update(id, dto.title(), dto.id());
        return toDTO(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private MusicDTO toDTO(Music m) {
        return new MusicDTO(
                m.getTitle(),
                m.getSinger().getId(),
                m.getSinger().getName()
        );
    }
}
