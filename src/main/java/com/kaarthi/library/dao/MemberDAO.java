package com.kaarthi.library.dao;
import com.kaarthi.library.config.DatabaseConnection;
import com.kaarthi.library.model.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    // CREATE - Add member
    public void addMember(Member member){
        String sql = "INSERT INTO member(name,phone_number,email_address,address) VALUES (?,?,?,?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getPhoneNumber());
            preparedStatement.setString(3,member.getEmailAddress());
            preparedStatement.setString(4, member.getAddress());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Member added successfully.");
            }
            else{
                System.out.println("Failed to add member.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add member", e);
        }
    }

    // READ - Fetch members
    public List<Member> getAllMembers(){
        List<Member> members = new ArrayList<>();
        String sql = "select * from member";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Member member = new Member(rs.getInt("member_id"),
                                            rs.getString("name"),
                                            rs.getString("phone_number"),
                                            rs.getString("email_address"),
                                            rs.getString("address"));
                members.add(member);
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return members;
    }

    // UPDATE - Modify member
    public void updateMember(Member member){
        String sql = "UPDATE member set name = ? , phone_number = ? , email_address = ? , address = ? where member_id = ?";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getPhoneNumber());
            preparedStatement.setString(3, member.getEmailAddress());
            preparedStatement.setString(4, member.getAddress());
            preparedStatement.setInt(5,member.getMemberId());

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Member details updated successfully.");
            }
            else{
                System.out.println("Member update failed. Member ID may not exist.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // DELETE - Remove member
    public void deleteMember(int memberId){
        String sql = "delete from member where member_id = ?";
        try{
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,memberId);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Member deleted successfully.");
            }
            else{
                System.out.println("Member deletion failed. Member ID may not exist.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
