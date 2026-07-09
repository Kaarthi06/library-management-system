package com.kaarthi.library.dao;
import com.kaarthi.library.config.DatabaseConnection;
import com.kaarthi.library.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    // CREATE - Add new book
    public void addBook(Book book) {
        String sql = "INSERT INTO book(title, author, isbn, category, price, total_copies, available_copies) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getIsbn());
            preparedStatement.setString(4, book.getCategory());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setInt(6, book.getTotalCopies());
            preparedStatement.setInt(7, book.getAvailableCopies());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Book added successfully.");
            }
            else{
                System.out.println("Failed to add book.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Prepare statement failed", e);
        }
    }

    // READ - Fetch all books
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "select * from book";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book(rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("total_copies"),
                        rs.getInt("available_copies")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    // UPDATE - Update existing book details
    public void updateBook(Book book) {
        String sql = "update book set title = ? , author = ? , isbn = ?, category = ? , price = ?, total_copies = ? , available_copies = ? where book_id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getIsbn());
            preparedStatement.setString(4, book.getCategory());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setInt(6, book.getTotalCopies());
            preparedStatement.setInt(7, book.getAvailableCopies());
            preparedStatement.setInt(8, book.getBookId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Book details updated successfully.");
            }
            else{
                System.out.println("Book update failed. Book ID may not exist.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // DELETE - Remove book
    public void deleteBook(int bookId) {
        String sql = "delete from book where book_id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookId);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Book deleted successfully.");
            }
            else{
                System.out.println("Book deletion failed. Book ID may not exist.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}