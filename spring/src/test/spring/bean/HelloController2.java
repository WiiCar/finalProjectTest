package test.spring.bean;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample/*")
public class HelloController2 {

	@RequestMapping("form.git")
	public String form() {
		System.out.println("!!! form 요청 !!!");

		return "spring01/form";
	}

	@RequestMapping("pro.git")
	// public String pro(String id, String pw) {
	public String pro(SampleDTO dto, String id, int pw) { // dto 와 넘어오는 파라미터 값 name 이 동일해야한ㄷ ㅏ!!!
		System.out.println("!!! pro 요청 !!!");
		System.out.println("dto id = " + dto.getId());
		System.out.println("dto pw = " + dto.getPw());
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);

		return "spring01/pro";
	}

	@RequestMapping("hello.git")
	// @RequestParam() 을 사용하면 넘어오는 파라미터의 이름과 매개변수랑 다르게 설정 가능
	public String hello(@RequestParam("name") String username, @RequestParam("age") int number) {
		// ~~8080:/spring/sample/hello.git?name=java&age=13

		System.out.println("username = " + username);
		System.out.println("number = " + number);

		return "spring01/hello";
	}

	// 리스트 처리
	// 스프링은 파라미터(매개변수)의 타입을 보고 객체를 생성한 후 바인딩(값저장) 하므로,
	// 파라미터의 타입은 List와 같은 인터페이스가 아닌, 실제적인 클래스 타입으로 지정한다.
	@RequestMapping("hello2.git")
	public String hello2(@RequestParam("ids") ArrayList<String> ids) {
		// ~~8080:/spring/sample/hello2.git?ids=111&ids=222&ids=kyc
		System.out.println("ids = " + ids);

		return "spring01/hello";
	}

	@RequestMapping("hello3.git")
	public String hello3(String[] ids, HttpServletRequest request, HttpServletResponse response) {
		// ~~8080:/spring/sample/hello2.git?ids=111&ids=222&ids=kyc
		System.out.println("String[] ids = " + ids);
		System.out.println("String[] ids = " + Arrays.toString(ids));

		return "spring01/hello";
	}

	// request를 통해 view로 데이터 전달
	@RequestMapping("hello4.git")
	public String hello4(String id, String pw, HttpServletRequest request) {
		// ~~8080/spring/sample/hello4.git?id=java&pw=1234 요청
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);

		request.setAttribute("id", id);
		request.setAttribute("pw", pw);

		return "/WEB-INF/views/spring01/hello.jsp";
	}

	// Model 통해 view로 데이터 전달
	@RequestMapping("hello5.git")
	public String hello5(String id, int pw, Model model) {
		// ~~8080/spring/sample/hello5.git?id=java&pw=1234 요청
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		SampleDTO dto = new SampleDTO();
		dto.setId("test");
		dto.setPw(1010);
		model.addAttribute("dto", dto);

		return "/WEB-INF/views/spring01/hello.jsp";
	}

	// ModelAndView 통해 데이터와 view 경로 한번에 리턴
	@RequestMapping("hello6.git")
	public ModelAndView hello6(String id, int pw) {
		// ~~8080/spring/sample/hello6.git?id=java&pw=1234 요청
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);

		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id); // view로 전달할 데이터 추가
		mv.addObject("pw", pw);
		// view 경로 추가
		mv.setViewName("/WEB-INF/views/spring01/hello.jsp");

		return mv;
	}

	@RequestMapping("hello7.git")
	public String hello7(String id, String pw, @ModelAttribute("dto") SampleDTO dto) {
		// ~~8080/spring/sample/hello7.git?id=java&pw=1234 요청
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		System.out.println("dto id = " + dto.getId());
		System.out.println("dto pw = " + dto.getPw());

		return "/WEB-INF/views/spring01/hello.jsp";
	}

	// ~~8080/spring/sample/hello8.git?col=red
	@RequestMapping("hello8.git")
	public String hello8() {
		System.out.println("hello8 요청!!!");

		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	// 이 클래스안에 있는 모든 매핑 메소드가 호출되기전에 자동으로 먼저 호출되고, 리턴되는 객체는 암묵적으로 Model에 추가되어 view까지 전달된다.
	@ModelAttribute("tv") // 별칭을 달아주면 꺼낼때도 tv.~ 으로 꺼내라
	public TvDTO getTv(String col) {
		System.out.println("GetTv 호출!!!");
		TvDTO tv = new TvDTO();
		tv.setPower(true);
		tv.setCh(10);
		tv.setColor(col);
		
		return tv; // 암묵적으로 Model 객체에 추가... TvDTO -> tvDTO
	}

	// ~~8080/spring/sample/hello8.git?col=red
		@RequestMapping("hello9.git")
		public String hello9() {
			System.out.println("hello9 요청!!!");

			return "/WEB-INF/views/spring01/hello.jsp";
		}
	
	
	
	
	
}
