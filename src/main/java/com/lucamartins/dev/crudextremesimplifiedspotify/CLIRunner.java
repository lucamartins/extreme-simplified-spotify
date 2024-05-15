package com.lucamartins.dev.crudextremesimplifiedspotify;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Artist;
import com.lucamartins.dev.crudextremesimplifiedspotify.model.ArtistType;
import com.lucamartins.dev.crudextremesimplifiedspotify.repository.ArtistRepository;
import com.lucamartins.dev.crudextremesimplifiedspotify.repository.SongRepository;

import java.util.Scanner;

public class CLIRunner {
    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    private final Scanner scanner = new Scanner(System.in);

    public CLIRunner(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void startCLI() {
        var menuString = """
                
                ### Application Menu
                
                0 - Close program
                1 - Register Artist
                """;

        while (true) {
            System.out.println(menuString);
            var operation = scanner.nextInt();
            scanner.nextLine();

            switch (operation) {
                case 0: {
                    return;
                }
                case 1: {
                    registerArtist();
                    break;
                }
            }

        }

    }

    private void registerArtist() {
        System.out.println("Register artist");

        System.out.print("Artist name: ");
        var artistName = scanner.nextLine();

        System.out.print("Artist Type (solo, band, duo): ");
        var artistTypeString = scanner.nextLine();
        var artistType = ArtistType.getArtistTypeFromLabel(artistTypeString);

        Artist newArtist = new Artist(artistName, artistType);

        artistRepository.save(newArtist);

        System.out.println("New artist registered successfully");
    }
}
