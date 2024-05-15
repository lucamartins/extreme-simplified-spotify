package com.lucamartins.dev.crudextremesimplifiedspotify;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudExtremeSimplifiedSpotifyApplication implements CommandLineRunner {
    public static void main(String[] args)  {
        SpringApplication.run(CrudExtremeSimplifiedSpotifyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var cliRunner = new CLIRunner();

        cliRunner.startCLI();
    }
}
