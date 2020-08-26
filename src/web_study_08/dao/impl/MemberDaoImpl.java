package web_study_08.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_study_08.dao.MemberDao;
import web_study_08.ds.JdbcUtil;
import web_study_08.dto.Member;

public class MemberDaoImpl implements MemberDao {
    private static final MemberDaoImpl instance = new MemberDaoImpl();

    private MemberDaoImpl() {
    }

    public static MemberDaoImpl getInstance() {
        return instance;
    }

    @Override
    public List<Member> selectMemberByAll() {
        String sql = "SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN FROM MEMBER";
        try (Connection con = JdbcUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                List<Member> list = new ArrayList<Member>();
                do {
                    list.add(getMember(rs));
                } while (rs.next());
                return list;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Member getMember(ResultSet rs) throws SQLException {
        String name = rs.getString("NAME");
        String userId = rs.getString("USERID");
        String pwd = rs.getString("PWD");
        String email = rs.getString("EMAIL");
        String phone = rs.getString("PHONE");
        int admin = rs.getInt("ADMIN");
        return new Member(name, userId, pwd, email, phone, admin);
    }

    @Override
    public Member selectMemberByNo(Member member) {
        String sql = "SELECT NAME, USERID, PWD, EMAIL, PHONE, ADMIN " 
                    + " FROM MEMBER " 
                    + "WHERE USERID =?";
        try (Connection con = JdbcUtil.getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, member.getUserId());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return getMember(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public int insertMember(Member member) {
        String sql = "INSERT INTO MEMBER(NAME, USERID, PWD, EMAIL, PHONE, ADMIN) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = JdbcUtil.getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getUserId());
            pstmt.setString(3, member.getPwd());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getPhone());
            pstmt.setInt(6, member.getAdmin());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMember(Member member) {
        String sql = "DELETE FROM MEMBER WHERE USERID = ?";
        try (Connection con = JdbcUtil.getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, member.getUserId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateMember(Member member) {
        String sql = "UPDATE MEMBER " + 
                     "   SET NAME=?, PWD=?, EMAIL=?, PHONE=?, ADMIN=?" + 
                     " WHERE USERID = ?";
        try (Connection con = JdbcUtil.getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getEmail());
            pstmt.setString(4, member.getPhone());
            pstmt.setInt(5, member.getAdmin());
            pstmt.setString(6, member.getUserId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
