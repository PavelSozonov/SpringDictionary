package ru.innopolis.ps.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.ps.model.Word;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pavel on 29.06.17.
 */
public class DaoMock implements Dao {

    private List<Word> dictionary = new CopyOnWriteArrayList<>();
    private Logger logger = LoggerFactory.getLogger(DaoMock.class);
    private AtomicLong idCounter = new AtomicLong();

    public DaoMock() {
        dictionary.add(new Word(0, "Default", "По умолчанию"));
        dictionary.add(new Word(1, "Cat", "Кошка"));
        dictionary.add(new Word(2, "Sun", "Солнце"));
        dictionary.add(new Word(3, "Apple", "Яблоко"));
        idCounter.set(3);
    }

    @Override
    public void addWord(String word, String translation) {
        dictionary.add(new Word(idCounter.incrementAndGet(), word, translation));
    }

    @Override
    public List<Word> getAllWords() {
        return dictionary;
    }

    @Override
    public Word getWord(long id) {
        int idValue;
        if (id >= 0 && id < dictionary.size()) {
            idValue = (int) id;
        } else {
            logger.error("Value of id is not in boundaries of the dictionary. The default value is used.");
            idValue = 0;
        }
        return dictionary.get(idValue);
    }
}
