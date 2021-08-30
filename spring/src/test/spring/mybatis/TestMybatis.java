package test.spring.mybatis;

import java.sql.Timestamp;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.bean.TestDTO;

@Controller
@RequestMapping("/mybatis/*")
public class TestMybatis {

	// 쿼리문 호출 : 커넥션 필요 -> sqlSession bean 객체 가져오기
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// 테스트할 uri 매핑 메소드 하나 추가
	@RequestMapping("mybatis.git")
	public String mybatis() {
		System.out.println("sqlSession = "+sqlSession);
		
		return "spring02/hello";
	}
	
	@RequestMapping("test.git")
	public String test(Model model) {
		System.out.println("!!! test 메소드 실행 !!!");
		
		int count = (Integer)sqlSession.selectOne("test.userCount");		
		int maxAge = (Integer)sqlSession.selectOne("test.maxAge");		
		List<TestDTO> userList = sqlSession.selectList("test.selectAll");
		TestDTO user = sqlSession.selectOne("test.getOneUser", "one");
		Timestamp userReg = sqlSession.selectOne("test.getReg", "JAVA01");
		// db에 insert
		TestDTO dto = new TestDTO();
		dto.setId("pika");
		dto.setPw("1234");
		dto.setAge(12);
		int res = sqlSession.insert("test.insertUser", dto);
		
		// 결과 view로 전달
		model.addAttribute("count", count);
		model.addAttribute("maxAge", maxAge);
		model.addAttribute("userList", userList);
		model.addAttribute("user", user);
		model.addAttribute("userReg", userReg);
		model.addAttribute("res",res);
		
		return "spring04/test";
	}
	
	//insert form
	@RequestMapping("insertForm.git")
	public String insertForm() {
		
		return "spring04/insertForm";
	}
	
	// insert Pro
	@RequestMapping("insertPro.git")
	public String insertPro(TestDTO dto, Model model) {
		
		int result = sqlSession.insert("test.insertUser", dto);
		
		model.addAttribute("result", result); // view에 insert 결과 전달
		
		return "spring04/insertPro";
	}
	
	//updateForm
	@RequestMapping("updateForm.git")
	public String updateForm(Model model) {
		
		String id ="pika1";
		// id 주고 해당 회원정보를 db에서 가져와야한다.
		TestDTO dto = sqlSession.selectOne("test.getOneUser", id);
		
		model.addAttribute("user", dto);
		
		return "spring04/updateForm";
	}
	
	//updatePro
	@RequestMapping("updatePro.git")
	public String updatePro(TestDTO dto, Model model) {
		
		dto.setId("pika1");
		int result = sqlSession.update("test.updateUser", dto);
		
		model.addAttribute("result", result);
		
		return "spring04/updatePro";
	}
	
	//delete
	@RequestMapping("deleteUser.git")
	public String deleteUser(Model model) {
		
		String id ="pika1";
		int result = sqlSession.delete("test.deleteUser", id);
		model.addAttribute("result", result);
		
		return "spring04/deleteUser";
	}
	
	
	
}
