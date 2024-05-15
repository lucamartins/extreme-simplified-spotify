package com.lucamartins.dev.crudextremesimplifiedspotify.repository;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Artist;
import com.lucamartins.dev.crudextremesimplifiedspotify.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT s FROM Song s WHERE s.artist.id = :artistId")
    List<Song> findAllByArtistId(Long artistId);

    Long countAllByArtist(Artist artist);
}
