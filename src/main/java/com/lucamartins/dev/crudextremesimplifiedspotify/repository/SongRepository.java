package com.lucamartins.dev.crudextremesimplifiedspotify.repository;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
