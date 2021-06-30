package com.studentservice.app.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;

import java.util.List;

@JsonFilter("Student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="student_name")
    private String studentname;
    private int age;

    @OneToMany(mappedBy = "student")
    List<Book> allBooks;

    public Student() {
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Student(long id, String studentname, int age) {
        this.id = id;
        this.studentname = studentname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentname='" + studentname + '\'' +
                ", age=" + age +
                '}';
    }
}
