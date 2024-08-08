package kr.kh.app.service;

import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.model.vo.dto.LoginDTO;

public interface MemberService {

	boolean signup(LoginDTO member);

	MemberVO login(LoginDTO member);

}
