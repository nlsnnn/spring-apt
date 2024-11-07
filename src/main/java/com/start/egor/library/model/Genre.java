package com.start.egor.library.model;

public enum Genre {
    FANTASY("Фантастика"),
    DRAMA("Драма"),
    NOVEL("Роман"),
    COMEDY("Комедия"),
    ADVENTURE("Приключения");

    private final String genreTextDisplay;

    Genre(String text) {
        this.genreTextDisplay = text;
    }

    public String getGenreTextDisplay() {
        return genreTextDisplay;
    }
}
