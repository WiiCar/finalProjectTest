package wiicar.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wiicar.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService = null;
	
	
}
