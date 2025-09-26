package com.apirest.catalogo_musica.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MusicCreateDTO(
        @NotBlank @Size(max = 25) String title,
        @NotNull Long id
) {}
