package db.day2.board.service;

public interface MemberService {

	boolean signUp(String id, String pw);

	boolean dismiss(String id, String pw);

}
