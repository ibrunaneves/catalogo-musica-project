package com.apirest.catalogo_musica.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(
        name = "singer",
        indexes = {
                @Index(name = "idx_singer_name", columnList = "name")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_singer_name", columnNames = "name")
        }
)
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 120)
    private String name;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Music> musics;
}
