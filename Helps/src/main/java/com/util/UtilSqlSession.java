package com.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//huo
public class UtilSqlSession {
	public static SqlSession MySession() {
		Reader reader;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("mapper/Mybatis_conf.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
			session = factory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e) ;
		}
		return session;
	}
}
