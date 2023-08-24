package com.example.demo.Exeption;

public class BookNotFoundExption extends RuntimeException{
    public BookNotFoundExption(String message) {
        super(message);
    }
}


