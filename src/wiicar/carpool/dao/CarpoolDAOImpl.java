package wiicar.carpool.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarpoolDAOImpl implements CarpoolDAO {

	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	
}
