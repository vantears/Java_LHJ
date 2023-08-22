package db.day2.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.day2.board.vo.MemberVO;

public class MemberMapper implements MemberDAO {
	
	private Connection con;

	public MemberMapper(Connection con) {
		this.con = con;
	}

	@Override
	public MemberVO getMember(String id) {
		String sql ="select * from member where me_id = ?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String me_id = rs.getString(1);
			String me_pw = rs.getString(2);
			int me_board_count = rs.getInt(3);
			return new MemberVO(me_id, me_pw, me_board_count);
		}
	} catch (SQLException e) {
		return null;
	}
		return null;
	}

	@Override
	public void insertMember(String id, String pw) {
		String sql = "insert into member(me_id,me_pw) values(?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void searchMember() {
		String sql = "SELECT * from member";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String me_id = rs.getString(1);
				String me_pw = rs.getString(2);
				int me_board_count = rs.getInt(3);
				MemberVO vo = new MemberVO(me_id, me_pw, me_board_count);
				System.out.println(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMember(String id) {
		String sql = "delete from member where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {}
	}

}
