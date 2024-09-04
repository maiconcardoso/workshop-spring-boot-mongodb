package com.maicon.devsuperior.workshopmongo.dto;

import java.time.LocalDate;

public class CommentDto {

    private String text;
    private LocalDate date;
    private AuthorDto author;

    public CommentDto() {

    }

    public CommentDto(String text, LocalDate date, AuthorDto author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
