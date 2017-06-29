package ru.innopolis.ps.dao;

import ru.innopolis.ps.model.Word;

import java.util.List;

/**
 * Created by pavel on 29.06.17.
 */
public interface Dao {
    void addWord(String word, String translation);
    Word getWord(long id);
    List<Word> getAllWords();
}
