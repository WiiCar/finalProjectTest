package wiicar.carpool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wiicar.carpool.dao.CarpoolDAOImpl;

@Service
public class CarpoolServiceImpl implements CarpoolService{

	@Autowired
	private CarpoolDAOImpl carpoolDAO = null;
	
}
