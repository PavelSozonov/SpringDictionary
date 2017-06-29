package ru.innopolis.ps.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.ps.dao.DAO;
import ru.innopolis.ps.dao.DAOMock;
import ru.innopolis.ps.model.Word2;

/**
 * Created by pavel on 28.06.17.
 */
@RestController
public class WordRestController {

    //AtomicLong idGenerator = new AtomicLong();
    private DAO dao = new DAOMock();
    private Logger logger = LoggerFactory.getLogger("WordController logger");
    private static final int DEFAULT_ID = 0;

    @RequestMapping(value = "/words", method = RequestMethod.GET)
    public Word2 showWordWithDefaultId() {
        return dao.getWord(DEFAULT_ID);
    }

    @RequestMapping(value = "/words/{id}", method = RequestMethod.GET)
    public Word2 showWord(@PathVariable(required = false, name = "id") String id) {
        long idValue;
        try {
            idValue = Long.parseLong(id);
        } catch (Exception e) {
            logger.error("Incorrect value (not long) is found in id. The default value is used.");
            idValue = DEFAULT_ID;
        }
        return dao.getWord(idValue);
    }

//    @RequestMapping(value = "/words", method = RequestMethod.POST)
//    public ResponseEntity<?> addWord(@PathVariable String word, @PathVariable String translation) {
//        dao.addWord(word, translation);
//        return ResponseEntity.noContent().build();
//    }
}
