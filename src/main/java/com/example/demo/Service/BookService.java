package com.example.demo.Service;

import com.example.demo.Exeption.BookNotFoundExption;
import com.example.demo.Model.Book;
import com.example.demo.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;


    public Book addBook(Book book){
        return bookRepo.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }
    public Book getBook(Integer id){
        return bookRepo.findById(id)
                .orElseThrow(()-> new BookNotFoundExption("Book is not found"));
    }

    public Book updateBook(Book book,Integer id){
        Book bookData = bookRepo.findById(id)
                .orElseThrow(()-> new BookNotFoundExption("Book is not found"));
        bookData.setAuthor(book.getAuthor());
        bookData.setTitle(book.getTitle());
        bookData.setPublisher(book.getPublisher());
        bookData.setNumber_of_pages(book.getNumber_of_pages());
        bookData.setDate_of_issue(book.getDate_of_issue());
        return bookRepo.save(bookData);
    }

    public void deleteBook(Integer id){
        bookRepo.deleteById(id);
    }


}
