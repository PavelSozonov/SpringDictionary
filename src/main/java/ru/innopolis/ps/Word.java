package ru.innopolis.ps;

/**
 * Created by pavel on 28.06.17.
 */
public class Word {
    private final long id;
    private final String word;
    private final String translate;

    public Word(long id, String word, String translate) {
        this.id = id;
        this.word = word;
        this.translate = translate;
    }

    public long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getTranslate() {
        return translate;
    }
}
