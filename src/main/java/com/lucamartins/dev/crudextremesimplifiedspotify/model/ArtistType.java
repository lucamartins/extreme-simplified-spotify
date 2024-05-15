package com.lucamartins.dev.crudextremesimplifiedspotify.model;

public enum ArtistType {
    SOLO,
    BAND,
    DUO;

    static public ArtistType getArtistTypeFromLabel(String label) {
        var possibleValues = ArtistType.values();

        for (ArtistType artistType : possibleValues) {
            if (label.equalsIgnoreCase(artistType.name())) {
                return artistType;
            }
        }

        throw new RuntimeException("No ArtistType was found for the label");
    }
}
