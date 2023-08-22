package db.day1;

import java.sql.*;
import java.util.*;

public class dbex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.print("DB ID : ");
		String dbId = sc.next();
		System.out.print("DB PW : ");
		String dbPw = sc.next();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, dbId, dbPw);
		} catch (SQLException e) {
			System.out.println("Connection Fail!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found!");
			e.printStackTrace();
		}
		System.out.println("Connection success!");
		
		/*
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//회원가입 할 아이디와 비번을 입력
			System.out.print("ID : ");
			String id = sc.next();
			System.out.print("PW : ");
			String pw = sc.next();
			//쿼리에 있는 ? 대신 입력한 아이디와 비번을 넣어줌
			//setXXX(index, value) : index는 ?의 위치로 1부터 시작, value는 ?대신 들어갈 값
			ps.setString(1, id);
			ps.setString(2, pw);
			
			//쿼리를 실행
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		/*
		String sql = "update member set me_board_count = ? where me_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.print("ID : ");
			String id = sc.next();
			ps.setString(2, id);
			System.out.print("Count : ");
			int count = sc.nextInt();
			ps.setInt(1, count);
			
			int resultCount = ps.executeUpdate();
			if(resultCount != 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
		String sql ="select * from member";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			//쿼리를 실행
			ResultSet resultSet = ps.executeQuery();
			//select문은 반복문을 통해 값을 읽어와야 함.
			while(resultSet.next()) {
				String id = resultSet.getNString(1);
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3);
				System.out.println(id + " : " + pw + " : " + boardCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
