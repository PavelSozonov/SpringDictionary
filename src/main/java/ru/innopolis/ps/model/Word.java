package ru.innopolis.ps.model;

import javax.persistence.Entity;

/**
 * Created by pavel on 28.06.17.
 */
public class Word {
    private long id;
    private String word;
    private String translation;

    public Word() {}

    public Word(long id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTranslation(String translation) {
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
