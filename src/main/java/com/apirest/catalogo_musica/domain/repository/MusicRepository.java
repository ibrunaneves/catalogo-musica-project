package com.apirest.catalogo_musica.domain.repository;

import com.apirest.catalogo_musica.domain.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {
    boolean existsByTitleIgnoreCaseAndSinger_Id(String musicTitle, Long id);
}
