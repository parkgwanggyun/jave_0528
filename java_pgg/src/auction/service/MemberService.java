package auction.service;

import org.apache.ibatis.annotations.Param;

import auction.model.vo.MemberVO;

public interface MemberService {

	MemberVO login(@Param("id")String id,@Param("pw")String pw);

	boolean signup(@Param("id")String id,@Param("pw") String pw, @Param("name")String name, @Param("address")String address,@Param("contact") String contact);

}
