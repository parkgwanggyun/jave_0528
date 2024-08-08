package kr.kh.app.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.dto.LoginDTO;

public interface MemberDAO {

	boolean insertMember(@Param("me")LoginDTO member);

	MemberVO selectMember(@Param("id")String id);

}
