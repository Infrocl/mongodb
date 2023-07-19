package com.example.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "db.books")
public class Book {
    @Id
    private String id;

    private String title;
    private String author;
    private String publishingYear;
}
