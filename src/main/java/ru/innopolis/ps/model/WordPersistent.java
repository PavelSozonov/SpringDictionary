package ru.innopolis.ps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by pavel on 29.06.17.
 */
@Entity
public class WordPersistent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String word;
    private String translation;

    public WordPersistent(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    protected WordPersistent() {} // for jpa only
}
