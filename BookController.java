package com.kiet.library.controller;

import com.kiet.library.model.Book;
import com.kiet.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // GET: Retrieve a book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(
            @PathVariable int bookId) {

        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            Book savedBook = bookService.addBook(book);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedBook);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", e.getMessage()));
        }
    }

    // PUT: Update an existing book
    @PutMapping("/{bookId}")
    public ResponseEntity<?> updateBook(
            @PathVariable int bookId,
            @RequestBody Book updatedBook) {

        Book book = bookService.updateBook(bookId, updatedBook);

        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(book);
    }

    // DELETE: Delete a book
    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(
            @PathVariable int bookId) {

        boolean deleted = bookService.deleteBook(bookId);

        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Book not found"));
        }

        return ResponseEntity.ok(
                Map.of("message", "Book deleted successfully"));
    }

    // GET: Search books by category
    @GetMapping("/search")
    public ResponseEntity<?> searchByCategory(
            @RequestParam String category) {

        List<Book> result =
                bookService.searchByCategory(category);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message", "No books found in this category"));
        }

        return ResponseEntity.ok(result);
    }

    // GET: Filter books by publication year
    @GetMapping("/published")
    public ResponseEntity<?> findPublishedFromYear(
            @RequestParam int fromYear) {

        List<Book> result =
                bookService.findPublishedFromYear(fromYear);

        if (result.isEmpty()) {
            return ResponseEntity.ok(
                    Map.of("message", "No books found for this year"));
        }

        return ResponseEntity.ok(result);
    }
}
