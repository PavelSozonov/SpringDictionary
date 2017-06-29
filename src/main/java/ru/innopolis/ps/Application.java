package ru.innopolis.ps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import ru.innopolis.ps.model.WordPersistent;
import ru.innopolis.ps.repository.WordRepository;

/**
 * Created by pavel on 28.06.17.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Bean
    public CommandLineRunner demo(WordRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new WordPersistent("Jack", "Джек"));
            repository.save(new WordPersistent("Chloe", "Хлоя"));
            repository.save(new WordPersistent("Kim", "Ким"));
            repository.save(new WordPersistent("David", "Давид"));
            repository.save(new WordPersistent("Michelle", "Мишель"));

            // fetch all customers
            logger.info("Words found with findAll():");
            logger.info("-------------------------------");
            for (WordPersistent word : repository.findAll()) {
                logger.info(word.toString());
            }
            logger.info("");

            // fetch an individual customer by ID
            WordPersistent customer = repository.findOne(1L);
            logger.info("Customer found with findOne(1L):");
            logger.info("--------------------------------");
            logger.info(customer.toString());
            logger.info("");

            // fetch customers by last name
            logger.info("Customer found with findByLastName('Bauer'):");
            logger.info("--------------------------------------------");
            for (WordPersistent word : repository.findByWord("Kim")) {
                logger.info(word.toString());
            }
            logger.info("");
        };
    }
}