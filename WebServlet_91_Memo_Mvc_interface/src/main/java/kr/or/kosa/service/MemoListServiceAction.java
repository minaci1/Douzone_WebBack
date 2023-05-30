package kr.or.kosa.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.MemoDto;

public class MemoListServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("목록보기");
		MemoDao dao = new MemoDao();
		List<MemoDto> memolist = new ArrayList<MemoDto>();
		
		 
		memolist= dao.getMemoList();
		
		request.setAttribute("memolist",memolist);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/memo/memolist.jsp");
		
		return forward;
	}
}
