package com.kiet.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }
}

@Component
class LibraryRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(LibraryRunner.class);

    @Override
    public void run(String... args) {
        log.info("Library Book Management System Started");
        log.info("Loading Book Catalogue...");
        log.info("Book Management REST API is Ready");
    }
}
