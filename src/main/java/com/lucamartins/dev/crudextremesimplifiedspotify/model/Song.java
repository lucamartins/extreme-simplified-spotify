package com.lucamartins.dev.crudextremesimplifiedspotify.model;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Artist artist;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public Song(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public Song() {
    }
}
