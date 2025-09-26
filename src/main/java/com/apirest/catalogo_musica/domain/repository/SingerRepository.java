package com.apirest.catalogo_musica.domain.repository;

import com.apirest.catalogo_musica.domain.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SingerRepository extends JpaRepository<Singer, Long> {

    boolean existsByNameIgnoreCase(String name);
}
