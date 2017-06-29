package ru.innopolis.ps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.ps.dao.Dao;
import ru.innopolis.ps.dao.DaoMock;
import ru.innopolis.ps.model.Word;

import java.util.List;

/**
 * Created by pavel on 28.06.17.
 */
@RestController
public class WordRestController {

    //AtomicLong idGenerator = new AtomicLong();
    private Dao dao = new DaoMock();
    private Logger logger = LoggerFactory.getLogger(WordRestController.class);
    private static final int DEFAULT_ID = 0;

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public Word showWordWithDefaultId() {
        return dao.getWord(DEFAULT_ID);
    }

    @RequestMapping(value = "/words/{id}", method = RequestMethod.GET)
    public Word showWord(@PathVariable(required = false, name = "id") String id) {
        long idValue;
        try {
            idValue = Long.parseLong(id);
        } catch (Exception e) {
            logger.error("Incorrect id. The default value is used.");
            idValue = DEFAULT_ID;
        }
        return dao.getWord(idValue);
    }

    @RequestMapping(value = "/words/list", method = RequestMethod.GET)
    public List<Word> showWords() {
        return dao.getAllWords();
    }

    @RequestMapping(value = "/words", method = RequestMethod.POST)
    public ResponseEntity<Word> addWord(@RequestBody Word input) {
        dao.addWord(input.getWord(), input.getTranslation());
        return ResponseEntity.noContent().build();
    }
}
