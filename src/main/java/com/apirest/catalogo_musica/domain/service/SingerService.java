package com.apirest.catalogo_musica.domain.service;

import com.apirest.catalogo_musica.domain.entity.Singer;
import com.apirest.catalogo_musica.domain.repository.SingerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SingerService {

    private final SingerRepository repository;

    public SingerService(SingerRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Singer create(Singer singer) {
        if (repository.existsByNameIgnoreCase(singer.getName())) {
            throw new IllegalArgumentException("Cantor já existe.");
        }
        return repository.save(singer);
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cantor não encontrado!"));
    }

    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Singer update(Long id, Singer singer) {
        Singer existing = findById(id);

        if (!existing.getName().equalsIgnoreCase(singer.getName())
                && repository.existsByNameIgnoreCase(singer.getName())) {
            throw new IllegalArgumentException("Cantor já existe.");
        }

        existing.setName(singer.getName());
        return repository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
