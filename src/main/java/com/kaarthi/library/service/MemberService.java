package com.kaarthi.library.service;
import com.kaarthi.library.dao.MemberDAO;
import com.kaarthi.library.model.Member;
import java.util.List;
import java.util.Scanner;

public class MemberService {

    private MemberDAO memberDAO = new MemberDAO();
    private Scanner sc = new Scanner(System.in);

    // Add a new member
    public void addMember(){
        System.out.println("Enter Member name : ");
        String name = sc.nextLine();
        System.out.println("Enter phone number : ");
        String ph = sc.nextLine();
        System.out.println("Enter email address : ");
        String email = sc.nextLine();
        System.out.println("Enter address");
        String address = sc.nextLine();

        Member member = new Member(name,ph,email,address);
        memberDAO.addMember(member);
    }

    // View all members
    public List<Member> viewMembers(){
        return memberDAO.getAllMembers();
    }

    // Update member details
    public void updateMember(){
        System.out.println("Enter the memberID to update : ");
        int memberId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name : ");
        String name = sc.nextLine();
        System.out.println("Enter the phone number : ");
        String ph = sc.nextLine();
        System.out.println("Enter the Email Address : ");
        String email = sc.nextLine();
        System.out.println("Enter the address : ");
        String address = sc.nextLine();

        Member member1 = new Member(memberId,name,ph,email,address);
        memberDAO.updateMember(member1);
    }

    // Delete a member
    public void  deleteMember(){
        System.out.println("Enter MemberId to delete : ");
        int memberId = sc.nextInt();
        memberDAO.deleteMember(memberId);
    }
}
