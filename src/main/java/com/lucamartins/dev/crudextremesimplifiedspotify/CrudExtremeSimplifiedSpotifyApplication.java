package com.lucamartins.dev.crudextremesimplifiedspotify;

import com.lucamartins.dev.crudextremesimplifiedspotify.repository.ArtistRepository;
import com.lucamartins.dev.crudextremesimplifiedspotify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudExtremeSimplifiedSpotifyApplication implements CommandLineRunner {
    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private SongRepository songRepository;

    public static void main(String[] args) {
        SpringApplication.run(CrudExtremeSimplifiedSpotifyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var cliRunner = new CLIRunner(artistRepository, songRepository);

        cliRunner.startCLI();
    }
}
