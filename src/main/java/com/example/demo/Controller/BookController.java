package com.example.demo.Controller;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("books")
    public ResponseEntity<Book> getAllBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book),HttpStatusCode.valueOf(201));
    }

    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatusCode.valueOf(200));
    }

    @GetMapping("books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id){
        return new ResponseEntity<>(bookService.getBook(id),HttpStatusCode.valueOf(200));
    }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") Integer id){
        Book newBook = bookService.updateBook(book,id);
        return new ResponseEntity<>(newBook,HttpStatusCode.valueOf(201));
    }
    @DeleteMapping("books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}
