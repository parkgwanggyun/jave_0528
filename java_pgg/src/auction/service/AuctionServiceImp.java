package auction.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import auction.dao.AuctionDao;

public class AuctionServiceImp implements AuctionService{
	private AuctionDao auctionDao;
	
	public AuctionServiceImp() {
		String resource = "auction/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			auctionDao = session.getMapper(AuctionDao.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
