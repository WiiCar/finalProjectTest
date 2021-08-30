package wiicar.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wiicar.member.dao.MemberDAOImpl;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAOImpl memberDAO = null;
	
}
