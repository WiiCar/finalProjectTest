package wiicar.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import wiicar.carpool.service.CarpoolServiceImpl;

@Controller
@RequestMapping("/carpool/*")
public class CarpoolController {

	@Autowired
	private CarpoolServiceImpl carpoolService = null;
	
	
	
	
	
	
	
	
	
	
}
