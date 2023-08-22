package db.day3.board.dao;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("member")MemberVO member);

	//void insertMember2(MemberVO member);

	void deleteMember(@Param("me_id")String me_id);

	void updateBoardCount(@Param("me_id")String me_id);

	void reduceBoardCount(@Param("me_id")String me_id);

}
