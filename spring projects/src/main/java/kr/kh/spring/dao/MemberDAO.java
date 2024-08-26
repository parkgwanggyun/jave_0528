package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("m")MemberVO member);

	MemberVO selectMember(@Param("me_pw")String me_pw);



}