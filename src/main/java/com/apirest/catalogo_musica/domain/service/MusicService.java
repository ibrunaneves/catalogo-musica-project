package com.apirest.catalogo_musica.domain.service;

import com.apirest.catalogo_musica.domain.entity.Music;
import com.apirest.catalogo_musica.domain.entity.Singer;
import com.apirest.catalogo_musica.domain.repository.MusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository repository;
    private final SingerService singerService;

    public MusicService(MusicRepository repository, SingerService singerService) {
        this.repository = repository;
        this.singerService = singerService;
    }

    @Transactional
    public Music create(String name, Long id) {
        Singer singer = singerService.findById(id);

        if (repository.existsByTitleIgnoreCaseAndSinger_Id(name, singer.getId())) {
            throw new IllegalArgumentException("Música já existe para este cantor.");
        }

        var music = Music.builder()
                .title(name)
                .singer(singer)
                .build();

        return repository.save(music);
    }

    @Transactional(readOnly = true)
    public Music findById(Long musicId) {
        return repository.findById(musicId)
                .orElseThrow(() -> new IllegalArgumentException("Música não encontrada!"));
    }

    @Transactional(readOnly = true)
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Music update(Long musicId, String title, Long id) {
        var existing = findById(musicId);
        var singer = singerService.findById(id);

        boolean sameTitle = existing.getTitle().equalsIgnoreCase(title);
        boolean sameSinger = existing.getSinger().getId().equals(singer.getId());

        if (!(sameTitle && sameSinger)
                && repository.existsByTitleIgnoreCaseAndSinger_Id(title, singer.getId())) {
            throw new IllegalArgumentException("Já existe uma música com esse nome para este cantor.");
        }

        existing.setTitle(title);
        existing.setSinger(singer);
        return repository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(findById(id));
    }
}
