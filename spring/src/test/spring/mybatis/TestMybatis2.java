package test.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.bean.TestDTO;

@Controller
@RequestMapping("/mybatis2/*")
public class TestMybatis2 {

	@Autowired
	private SqlSessionTemplate sqlSession = null;

	@RequestMapping("selectIf.git")
	public String selectIf(Model model, TestDTO dto) {
		System.out.println("sqlSession = " + sqlSession);

		// id 하나 넘겨주고 해당 id 가 db에 존재하는지 확인(id 중복확인)
		// int result = sqlSession.selectOne("mybatis.selectIf","pika");
		// int result = sqlSession.selectOne("mybatis.selectIf2","pika");
		// dto.setId("pika");
		// dto.setPw("1245");
		// dto.setAge(34);
		// int result = sqlSession.selectOne("mybatis.selectIf3", dto);
		// int result = sqlSession.selectOne("mybatis.choose", dto);
		// int result = sqlSession.selectOne("mybatis.selectTrim", dto);
		// int result = sqlSession.update("mybatis.updateTest", dto);
		/*
		 * List list = new ArrayList(); list.add("one"); list.add("pika");
		 * list.add("three"); list.add("twwo"); int result =
		 * sqlSession.selectOne("mybatis.selectIn", list);
		 */

		// test1 : id, j 두개 데이터 보내기 -> DTO, hashmap
		// pw i

		// HashMap map = new HashMap();
		// map.put("column", "id");
		// map.put("keyword", "J");
		// int result = sqlSession.selectOne("mybatis.selectLike", map);

		dto.setId("siballa");
		dto.setPw("12142");
		int result = sqlSession.insert("mybatis.insertSeq", dto);
		System.out.println("age = "+dto.getAge());

		// view 로 전달
		model.addAttribute("result", result);

		return "spring05/select";
	}

}
