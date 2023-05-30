package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.MemoDto;

public class MemoWriteServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		
		MemoDao dao = new MemoDao();
		MemoDto dto = new MemoDto();
		
		
		dto.setId(id);
		dto.setEmail(email);
		dto.setContent(content);
		
		int result =dao.insertMemo(dto);
		System.out.println("입력한 메모갯수는 : "+result+"개입니다.");
	 
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true); //리다이렉인지 포워드인지 
		forward.setPath("/WebServlet_91_Memo_Mvc_interface/memo.html");
		
		
		
		return forward;
	}
	
	
}
