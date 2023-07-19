package com.example.mongodb.operations;

import com.example.mongodb.document.Book;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class BookOperations {
    private final MongoOperations mongoOperation;

    public BookOperations(MongoOperations mongoOperation) {
        this.mongoOperation = mongoOperation;
    }

    public void save(Book book) {
        mongoOperation.save(book);
    }

    public void search(String critera, String value) {
        Query searchBook = new Query(Criteria.where(critera).is(value));
        Book resultBook = mongoOperation.findOne(searchBook, Book.class);
        System.out.println(resultBook);
    }

    public void update(String critera, String value, String updateCriteria, String updateValue) {
        Query searchBook = new Query(Criteria.where(critera).is(value));
        mongoOperation.updateFirst(searchBook, Update.update(updateCriteria, updateValue),
                Book.class);
    }

    public void getAll() {
        List<Book> bookList = mongoOperation.findAll(Book.class);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void delete(String critera, String value) {
        Query searchStudent = new Query(Criteria.where(critera).is(value));
        mongoOperation.remove(searchStudent, Book.class);
    }
}
