package auction.dao;

import auction.model.vo.MemberVO;

public interface MemberDao {

	MemberVO selectMember(String id);

	boolean insertMember(String id, String pw, String name, String address, String contact);

}
