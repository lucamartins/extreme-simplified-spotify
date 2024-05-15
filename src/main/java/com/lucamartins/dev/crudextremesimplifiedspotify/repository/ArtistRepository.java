package com.lucamartins.dev.crudextremesimplifiedspotify.repository;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findArtistByNameContainingIgnoreCase(String artistName);
}
