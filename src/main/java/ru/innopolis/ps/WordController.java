package ru.innopolis.ps;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by pavel on 28.06.17.
 */
@RestController
public class WordController {

    AtomicLong idGenerator = new AtomicLong();

    @RequestMapping("/word")
    public Word showWord() {
        return new Word(idGenerator.getAndIncrement(), "dog", "собака");
    }
}
