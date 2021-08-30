package test.spring.bean;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample2/*")
public class HelloController3 {

	// 기존에 방식으로 객체 생성
	//private Date day = null;
	
	//public HelloController3() {
	//	this.day=new Date();
	//}
	
	// 자동 주입시, 변수의 타입을 보고 같은 타입으로 등록된 Bean을 찾아서 주입해준다.
	// 이때, 같은 타입의 bean이 두개 이상 등록되어있을경우! bean의 id 속성값과 변수명으로 구분한다.
	@Autowired
	private TestBean testBean = null;
	
	@Autowired
	private TestBean testBean2 = null;
	
	@RequestMapping("hello.git")
	public String hello() {
		System.out.println(testBean.getText());
		System.out.println(testBean.getNumber());
		System.out.println(testBean.getReg());
		System.out.println("=====================");
		System.out.println(testBean2.getText());
		System.out.println(testBean2.getNumber());
		System.out.println(testBean2.getReg());
		
		return "spring02/hello";
	}
	
	/* 의존성 자동 주입 : spring-servlet.xml 에 <bean> 태그로 등록한 객체를 스프링이 자동으로 채워준다.
	@Autowired
	private Date day = null;
	
	@Autowired
	private TestBean testBean = null;
	
	@RequestMapping("hello.git")
	public String hello() {
		
		//day = new Date();
		System.out.println("day = "+day);
		System.out.println("testBean = "+testBean);
		testBean.setText("hello");
		System.out.println("testBean = "+testBean.getText());
		testBean.func();
		
		return "/WEB-INF/views/spring02/hello.jsp";
	}
	*/
	
	@RequestMapping(value ="hello1.git", params = {"id=spring","pw", "!age"} ) // id=spring으로 와야한다고 제약을 걸어두는것
	public String hello1(String id, String pw) {
		// ~~8080/spring/sample2/hello1.git?id=spring&pw=123456
		System.out.println("id = "+id);
		System.out.println("pw = "+pw);
		
		return "/WEB-INF/views/spring02/hello.jsp";
	}
	
	@RequestMapping("hello3.git")
	public String hello3(@RequestParam(value ="id", required = false) String msg) {
		// ~~8080/spring/sample2/hello3.git?msg=tlqkfwhwrkxek
		System.out.println("msg = "+ msg);
		
		return "/WEB-INF/views/spring02/hello.jsp";
	}
	
	@RequestMapping("hello4.git")
	@ResponseBody
	public String hello4() {
		
		return "hello....4!!!!";
	}
	
	
	
	
	
	
}
