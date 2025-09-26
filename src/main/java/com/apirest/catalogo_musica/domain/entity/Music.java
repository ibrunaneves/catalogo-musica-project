package com.apirest.catalogo_musica.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(
        name = "music",
        indexes = {
                @Index(name = "idx_music_title", columnList = "title"),
                @Index(name = "idx_music_singer", columnList = "singer_id")
        },
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_music_title_singer", columnNames = {"title", "singer_id"})
        }
)
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 25)
    private String title;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "singer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_music_singer")
    )
    private Singer singer;
}
