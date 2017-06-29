package ru.innopolis.ps.model;

/**
 * Created by pavel on 28.06.17.
 */
public class Word2 {
    private final long id;
    private final String word;
    private final String translation;

    public Word2(long id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }
}
