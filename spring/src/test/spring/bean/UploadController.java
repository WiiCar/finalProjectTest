package test.spring.bean;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload/*")
public class UploadController {

	@RequestMapping("uploadForm.git")
	public String uploadForm() {
		System.out.println("uploadForm.jsp 요청 !!!");

		return "spring03/uploadForm";
	}

	@RequestMapping("uploadPro.git")
	public String uploadPro(String name, MultipartHttpServletRequest request) {
		System.out.println("uploadPro.jsp 요청 !!!");

		System.out.println("name = " + name);
		try {
			MultipartFile mf = request.getFile("img"); // 파라미터 이름(form에서 file name) 주면서 해당 파일 정보 변수에 담기!!!
			// 파일 사이즈
			long fileSize = mf.getSize();
			System.out.println("fileSize = " + fileSize);
			String org = mf.getOriginalFilename();
			System.out.println("org = " + org);

			// 서버에 이미지 파일 저장(WebContent > save 폴더 생성)
			String path = request.getRealPath("save");
			System.out.println("path = " + path);
			//String imgPath = path + "\\" + mf.getOriginalFilename(); // 저장경로 \\ 파일명.확정자 로 전체 경로 지정!!
			//System.out.println("imgPath = " + imgPath);
			
			// 파일이름 중복처리 : 오리지널파일명 + 시간 (millis) + 확장자
			String orgName = mf.getOriginalFilename();
			System.out.println("orgName = "+orgName);
			// 확장자를 뺀 파일이름
			String imgName = orgName.substring(0, orgName.lastIndexOf('.'));
			System.out.println("imgName = "+imgName);
			// 확장자만 !
			String ext = orgName.substring(orgName.lastIndexOf('.'));
			System.out.println("ext = "+ ext);
			
			// 현재시간 밀리세컨드
			long millis = System.currentTimeMillis();
			
			// !! 이미지 파일명 조합 합치기 !!
			//String newName = imgName+millis+ext;
			//System.out.println("newName = "+newName);
			
			
			// UUID
			UUID uuid = UUID.randomUUID();
			System.out.println("UUID = "+uuid.toString().replace("-", ""));
			String newName = imgName + uuid.toString().replace("-", "")+ ext;
			
			//저장될 파일의 전체 경로 세팅 : save 경로 + 새이미지 파일명
			String imgPath = path +"\\"+newName;
			System.out.println("imgPath = "+imgPath);
			
			File f = new File(imgPath); // 파일 객체 생성
			mf.transferTo(f); // 이미지 서버에 저장
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "spring03/uploadPro";
	}
	
	// 다운로드 버튼을 보여줄 경로 매핑
	@RequestMapping("downPage.git")
	public String downPage() {
		
		return "spring03/downPage";
	}
	
	// 다운로드 요청처리 매핑
	@RequestMapping("download.git")
	public ModelAndView download(HttpServletRequest request, String imgname) {
		// 어떤 파일을 다운로드 시킬지 연결.
		// 서버상의 폴더에서 다운받을 수 있도록 파일 준비해놓고 경로잡아서 전달
		System.out.println("imgname = "+imgname);
		String path = request.getRealPath("save");
		// 다운시킬 파일의 전체 경로 문자열로 조합
		String filePath = path + "\\" + imgname;
		System.out.println("filePath = "+filePath);
		File f = new File(filePath);
		//						view 이름,		view에게 전달할 데이터이름,	데이터 객체
							// String viewname / String modelname / Object modelObject
		ModelAndView mv = new ModelAndView("fileDown", "downloadFile", f);
		return mv;
	}
	
	
	
	
	
	

}
