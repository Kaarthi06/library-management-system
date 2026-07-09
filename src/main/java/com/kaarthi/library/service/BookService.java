package com.kaarthi.library.service;
import com.kaarthi.library.model.Book;
import com.kaarthi.library.dao.BookDAO;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private BookDAO bookDAO = new BookDAO();
    private Scanner sc = new Scanner(System.in);

    // Add a new book
    public void addBook(){
        System.out.println("Enter the Title :");
        String title = sc.nextLine();
        System.out.println("Enter author name :");
        String author = sc.nextLine();
        System.out.println("Enter the ISBN number :");
        String isbn = sc.nextLine();
        System.out.println("Enter the Category");
        String category = sc.nextLine();
        System.out.println("Enter the price :");
        double price = sc.nextDouble();
        System.out.println("Total Copies :");
        int totalCopies = sc.nextInt();
        System.out.println("Available Copies :");
        int availableCopies = sc.nextInt();

        Book book = new Book(title,author,isbn,category,price,totalCopies,availableCopies);
        bookDAO.addBook(book);
    }

    // View all books
    public List<Book> viewBooks(){
        return bookDAO.getAllBooks();
    }

    // Update book details
    public void updateBook(){
        System.out.println("Enter the bookId to update : ");
        int bookId = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter the Title :");
        String title = sc.nextLine();
        System.out.println("Enter author name :");
        String author = sc.nextLine();
        System.out.println("Enter the ISBN number :");
        String isbn = sc.nextLine();
        System.out.println("Enter the Category");
        String category = sc.nextLine();
        System.out.println("Enter the price :");
        double price = sc.nextDouble();
        System.out.println("Total Copies :");
        int totalCopies = sc.nextInt();
        System.out.println("Available Copies :");
        int availableCopies = sc.nextInt();

        Book book = new Book(bookId,title,author,isbn,category,price,totalCopies,availableCopies);
        bookDAO.updateBook(book);
    }

    // Delete a book
    public void deleteBook(){
        System.out.println("Enter Book ID to delete :");
        int bookId = sc.nextInt();
        bookDAO.deleteBook(bookId);
    }
}
