package ru.innopolis.ps.dao;

import ru.innopolis.ps.model.Word2;

import java.util.List;

/**
 * Created by pavel on 29.06.17.
 */
public interface DAO {
    void addWord(String word, String translation);
    Word2 getWord(long id);
    List<Word2> getAllWords();
}
