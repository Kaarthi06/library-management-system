package com.kaarthi.library.main;

import com.kaarthi.library.model.Book;
import com.kaarthi.library.model.Member;
import com.kaarthi.library.service.BookService;
import com.kaarthi.library.service.MemberService;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1.Book Management");
            System.out.println("2.Member Management");
            System.out.println("3.Issue Book");
            System.out.println("4.Return Book");
            System.out.println("5.Exit");

            int libraryChoice = sc.nextInt();
            sc.nextLine();

            switch (libraryChoice) {

                case 1:
                    showBookManagementMenu(sc, bookService);
                    break;
                case 2:
                    showMemberManagementMenu(sc, memberService);
                    break;
                case 3:
                    System.out.println("Issue Book module is under development.");
                    break;
                case 4:
                    System.out.println("Return Book module is under development.");
                    break;
                case 5:
                    System.out.println("\nThank you for using the Library Management System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Main Menu Choice.");
            }
        }
    }
    private static void showBookManagementMenu(Scanner sc, BookService bookService){

        boolean running = true;

        while (running) {
            System.out.println("====== BOOK MANAGEMENT ======");
            System.out.println("1.Add Book");
            System.out.println("2.View Books");
            System.out.println("3.Update Book");
            System.out.println("4.Delete Book");
            System.out.println("5.Back");

            int bookChoice = sc.nextInt();
            sc.nextLine();

            switch (bookChoice) {
                case 1:
                    bookService.addBook();
                    break;
                case 2:
                    List<Book> books = bookService.viewBooks();

                    if(books.isEmpty()){
                        System.out.println("No books available.");
                    }
                    else{
                        for(Book book : books){
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    bookService.updateBook();
                    break;
                case 4:
                    bookService.deleteBook();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Book Menu Choice.");
                    break;
            }
        }
    }

    private static void showMemberManagementMenu(Scanner sc, MemberService memberService){

        boolean running = true;

        while(running) {
            System.out.println("====== MEMBER MANAGEMENT ======");
            System.out.println("1.Add Member");
            System.out.println("2.View Members");
            System.out.println("3.Update Member");
            System.out.println("4.Delete Member");
            System.out.println("5.Back");

            int memberChoice = sc.nextInt();
            sc.nextLine();

            switch (memberChoice) {

                case 1:
                    memberService.addMember();
                    break;
                case 2:
                    List<Member> members = memberService.viewMembers();

                    if(members.isEmpty()) {
                        System.out.println("No members available.");
                    }
                    else{
                        for(Member member : members){
                            System.out.println(member);
                        }
                    }
                    break;
                case 3:
                    memberService.updateMember();
                    break;
                case 4:
                    memberService.deleteMember();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Member Menu Choice.");
                    break;
            }
        }
    }
}

