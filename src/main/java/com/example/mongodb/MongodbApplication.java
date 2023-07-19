package com.example.mongodb;

import com.example.mongodb.config.MongoConfig;
import com.example.mongodb.document.Book;
import com.example.mongodb.operations.BookOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
        BookOperations ops = new BookOperations(mongoTemplate);
        Book firstBook = new Book("b100", "Война и мир", "Л.Н. Толстой", "2018");
        Book secondBook = new Book("b200", "Анна Каренина", "Л.Н. Толстой", "2022");
        Book thirdBook = new Book("b300", "Мастер и Маргарита", "М.А. Булгаков", "2014");
        Book testBook = new Book("b400", "TEST", "TEST", "2007");
        ops.save(firstBook);
        ops.save(secondBook);
        ops.save(thirdBook);
        ops.save(testBook);
        ops.update("title", "Анна Каренина", "publishingYear", "2023");
        System.out.println("Поиск по автору:");
        ops.search("author", "М.А. Булгаков");
        System.out.println("Поиск по году издания:");
        ops.search("publishingYear", "2018");
        ops.delete("title", "TEST");
        System.out.println("Все книги: ");
        ops.getAll();
    }
}
