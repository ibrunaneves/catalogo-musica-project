package com.apirest.catalogo_musica.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SingerCreateDTO(
        @NotBlank @Size(max = 120) String name
) {}
