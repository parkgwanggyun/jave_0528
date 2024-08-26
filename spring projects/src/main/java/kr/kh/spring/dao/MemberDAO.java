package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	public String selectEmail(@Param("id")String id);
}
