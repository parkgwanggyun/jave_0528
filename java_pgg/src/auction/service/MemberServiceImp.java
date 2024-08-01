package auction.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import auction.dao.MemberDao;
import auction.model.vo.MemberVO;




public class MemberServiceImp implements MemberService{
	private MemberDao memberDao;
	
	public MemberServiceImp() {
		String resource = "auction/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberVO login(String id, String pw) {
		MemberVO user = memberDao.selectMember(id);
		if(user == null) {
			return null;
		}
		if(user.getMe_password().equals(pw)) {
			return user;
		}
		return null;
	}

	@Override
	public boolean signup(String id, String pw, String name, String address, String contact) {
		//아이디 중복 검사
		//다오에게 아이디를 주면서 회원 정보를 가져오라고 시켜서 있으면 false를 리턴
		MemberVO user = memberDao.selectMember(id);
		if(user != null) {
			return false;
		}
		//아이디가 정규 표현식에 맞지 않으면 false를 리턴
		String idRegex = "^\\w{6,13}$";
		if(!Pattern.matches(idRegex, id)) {
			return false;
		}
		//비번이 정규 표현식에 맞지 않으면 false를 리턴
		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
		if(!Pattern.matches(pwRegex, pw)) {
			return false;
		}
		if(name == null) {
			return false;
		}
		if(address == null) {
			return false;
		}
		String coRegex = "^[0-9]{16}$";
		if(contact == null) {
			return false;
		}
		//다오에게 아이디, 비번, 이름,주소,연락처 을 주면서 회원가입하라고 시킴
		return memberDao.insertMember(id, pw, name,address,contact);
	}
}
