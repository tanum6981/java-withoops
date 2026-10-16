package com.kiet.library.service;

import com.kiet.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(201, "Effective Java",
                "Joshua Bloch", "Programming", 2018, true));

        books.add(new Book(202, "Clean Code",
                "Robert C. Martin", "Programming", 2008, true));

        books.add(new Book(203, "The Hobbit",
                "J.R.R. Tolkien", "Fantasy", 1937, false));

        books.add(new Book(204, "Head First Java",
                "Kathy Sierra", "Programming", 2022, true));

        books.add(new Book(205, "Wings of Fire",
                "A.P.J. Abdul Kalam", "Biography", 1999, true));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book) {
        if (getBookById(book.getBookId()) != null) {
            throw new IllegalArgumentException(
                    "Book ID already exists");
        }

        books.add(book);
        return book;
    }

    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = getBookById(bookId);

        if (existingBook == null) {
            return null;
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setCategory(updatedBook.getCategory());
        existingBook.setPublicationYear(
                updatedBook.getPublicationYear());
        existingBook.setAvailable(updatedBook.isAvailable());

        return existingBook;
    }

    public boolean deleteBook(int bookId) {
        Book book = getBookById(bookId);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }

    public List<Book> searchByCategory(String category) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> findPublishedFromYear(int fromYear) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublicationYear() >= fromYear) {
                result.add(book);
            }
        }

        return result;
    }
}
