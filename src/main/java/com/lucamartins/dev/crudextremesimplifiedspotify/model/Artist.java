package com.lucamartins.dev.crudextremesimplifiedspotify.model;

import jakarta.persistence.*;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ArtistType artistType;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public Artist(String name, ArtistType artistType) {
        this.name = name;
        this.artistType = artistType;
    }

    public Artist() {
    }
}
