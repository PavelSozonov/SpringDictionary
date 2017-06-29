package ru.innopolis.ps.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.ps.model.WordPersistent;

import java.util.List;

/**
 * Created by pavel on 29.06.17.
 */
public interface WordRepository extends CrudRepository<WordPersistent, Long> {

    List<WordPersistent> findByWord(String word);


}
