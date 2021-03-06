package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class WriteActionCommand implements BbsCommandImpl {
	
	@Override
	public void execute(Model model) {
		// Model에 저장된 값을 Map컬렉션으로 변환한다.
		Map<String, Object> paramMap = model.asMap();
		// 첫 번째로 request내장객체를 가져온다.
		HttpServletRequest req =
				(HttpServletRequest)paramMap.get("req");
		// 두 번째로 작성페이지에서 전송한 모든 폼값이 저장된 DTO객체를 가져온다.
		SpringBbsDTO springBbsDTO =
				(SpringBbsDTO)paramMap.get("springBbsDTO");
		// 폼값 확인용 로그
		System.out.println("springBbsDTO.title= "+ springBbsDTO.getTitle());
		
		// DAO객체 생성 및 쓰기 처리
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		int affected = dao.write(springBbsDTO);
		System.out.println("입력된결과: "+ affected);
		// 자원을 별도로 반납하지도 않고 close 메서드는 공란이므로 생략해도 상관없다.
		// dao.close();
	}
}
