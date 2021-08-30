package test.spring.testpack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestBean {

	@RequestMapping("test2.git")
	public String test2() {
		
		System.out.println("test2 요청완료 !!!");
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
}
