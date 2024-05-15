package com.lucamartins.dev.crudextremesimplifiedspotify.repository;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Long, Artist> {
}
