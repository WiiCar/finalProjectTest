package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 컨트롤러 클래스 생성
// @Controller 어노테이션 : 컨트롤러의 역할을 하는 클래스라고 선언.

@Controller
// 클래스 레벨에 RequestMapping 적용 : 클래스 내의 모든 매핑경로들의 공통 주소를 지정.
//		...8080:/spring/hello/hello.git 이런식
@RequestMapping("/hello/*")
public class HelloController {

	// @RequestMapping 어노테이션 : 요청 주소와 () 안에 작성된 주소가 동일하면 어노테이션이 붙은 메소드 실행시켜준다.
	// 메소드 : 리턴타입 String, 리턴값은 요청이 들어왔을때 보여줘야하는 jsp 파일의 전체 경로.
	// @RequestMapping("*.git") // 와일드카드 매핑
	// @RequestMapping({"hello.git","hi.git","kyc.git"})//여러경로
	// @RequestMapping("?.git") // 아무글자 한개.git면 페이지 가능
	// @RequestMapping(value = "hello.git", method=RequestMethod.POST) // 요청방식
	// GET/POST 방식
	@RequestMapping("hello.git") // 혼자쓸땐 value 값 생략 가능
	public String hello() {
		// 로직 처리 // Model 호출
		System.out.println("hello 요청!!!");

		return "/WEB-INF/views/spring01/hello.jsp"; // View 페이지
	}

	// @GetMapping, @PostMapping을 사용하려면 클래스레벨 RequestMapping에 /hello/에 *을 추가해야함
	// @GetMapping("hello2.git") = @RequestMapping(value = "hello.git",
	// method=RequestMethod.Get)
	@GetMapping("hello2.git")
	public String hello2() {
		System.out.println("hello2 요청 !!!");
		//

		return "/WEB-INF/views/spring01/hello.jsp"; // View 페이지
	}

	@PostMapping("hello3.git")
	public String hello3() {
		System.out.println("hello3 요청 !!!");

		return "/WEB-INF/views/spring01/hello.jsp"; // View 페이지
	}

	// http://localhost:8080/spring/hello/hello.git
	//							 contextPath
	//									 클래스레벨@RM
	//											 메소드레벨 @RM

}
