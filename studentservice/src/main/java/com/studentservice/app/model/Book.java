package com.studentservice.app.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@JsonFilter("Book")
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String bookName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Book() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book(Long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
