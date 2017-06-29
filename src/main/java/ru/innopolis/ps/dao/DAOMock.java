package ru.innopolis.ps.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.ps.model.Word2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pavel on 29.06.17.
 */
public class DAOMock implements DAO {

    private List<Word2> dictionary = new CopyOnWriteArrayList<>();
    private Logger logger = LoggerFactory.getLogger("DAOMock logger");
    private AtomicLong idCounter = new AtomicLong();

    public DAOMock() {
        dictionary.add(new Word2(0, "Default", "По умолчанию"));
        dictionary.add(new Word2(1, "Cat", "Кошка"));
        dictionary.add(new Word2(2, "Sun", "Солнце"));
        dictionary.add(new Word2(3, "Apple", "Яблоко"));
        idCounter.set(3);
    }

    @Override
    public void addWord(String word, String translation) {
        dictionary.add(new Word2(idCounter.incrementAndGet(), word, translation));
    }

    @Override
    public List<Word2> getAllWords() {
        return dictionary;
    }

    @Override
    public Word2 getWord(long id) {
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
