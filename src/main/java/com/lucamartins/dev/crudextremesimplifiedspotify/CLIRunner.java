package com.lucamartins.dev.crudextremesimplifiedspotify;

import com.lucamartins.dev.crudextremesimplifiedspotify.model.Artist;
import com.lucamartins.dev.crudextremesimplifiedspotify.model.ArtistType;
import com.lucamartins.dev.crudextremesimplifiedspotify.model.Song;
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
                2 - Register Song
                3 - List All Songs
                4 - List Artist's Songs
                                
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
                    handleRegisterArtist();
                    break;
                }
                case 2: {
                    handleRegisterSong();
                    break;
                }
                case 3: {
                    handleListAllSongs();
                    break;
                }
                case 4: {
                    handleListArtistSongs();
                    break;
                }
            }

        }

    }

    private void displayAllArtistsHelper() {
        System.out.println("All registered artists:");

        var artists = artistRepository.findAll();

        artists.forEach(artist -> {
            System.out.printf("ID: %d - Name: %s", artist.getId(), artist.getName());
        });

        System.out.println();
    }

    private void displayAllSongsHelper() {
        System.out.println("All registered songs:");

        var songs = songRepository.findAll();

        songs.forEach(song -> {
            System.out.printf("ID: %d - Name: %s - Artist: %s", song.getId(), song.getName(), song.getArtist().getName());
        });

        System.out.println();
    }

    private void handleRegisterArtist() {
        System.out.println("$ Register Artist");

        System.out.print("Artist name: ");
        var artistName = scanner.nextLine();

        System.out.print("Artist Type (solo, band, duo): ");
        var artistTypeString = scanner.nextLine();
        var artistType = ArtistType.getArtistTypeFromLabel(artistTypeString);

        Artist newArtist = new Artist(artistName, artistType);

        artistRepository.save(newArtist);

        System.out.println("New artist registered successfully");
    }

    private void handleRegisterSong() {
        System.out.println("$ Register Song");

        System.out.print("Song name: ");
        var songName = scanner.nextLine();

        displayAllArtistsHelper();

        System.out.print("Artist ID: ");
        var artistId = scanner.nextLong();
        scanner.nextLine();

        var optionalArtist = artistRepository.findById(artistId);

        if (optionalArtist.isEmpty()) {
            System.out.println("Operation cancelled: artist not found");

            return;
        }

        var artist = optionalArtist.get();

        var newSong = new Song(songName, artist);

        songRepository.save(newSong);

        System.out.println("New song registered successfully");

    }

    private void handleListAllSongs() {
        displayAllSongsHelper();
    }

    private void handleListArtistSongs() {
        displayAllArtistsHelper();

        System.out.print("Artist's ID: ");
        var artistId = scanner.nextLong();

        var optionalArtist = artistRepository.findById(artistId);

        if (optionalArtist.isEmpty()) {
            System.out.println("Operation cancelled: artist not found");
            return;
        }

        var artistSongs = songRepository.findAllByArtistId(artistId);

        artistSongs.forEach(artistSong -> {
            System.out.println(artistSong.getName());
        });
     }
}
