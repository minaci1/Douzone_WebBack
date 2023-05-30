package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.MemoListServiceAction;
import kr.or.kosa.service.MemoWriteServiceAction;

 
@WebServlet("*.do")//MemoServlet.do
public class FrontMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
 
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		String requestUri = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestUri.substring(contextPath.length());
    	
    
    	System.out.println("requestUri : " + requestUri);
    	System.out.println("contextPath : " + contextPath);
    	System.out.println("urlcommand : " + urlcommand);
    	
    	
    	Action action=null;
    	ActionForward forward=null;
    	
    	//Client 요청 (1.화면주세요(service 필요없어요) 2.처리해주세요(별도의 service 필요)
    	if(urlcommand.equals("/memoForm.do")) {
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/memo/memoForm.jsp");
    	}else if(urlcommand.equals("/MemoList.do")) {
    		
    		action = new MemoListServiceAction();
    		forward = action.execute(request, response);
    		
    	}else if(urlcommand.equals("/Memowrite.do")) {
    		action = new MemoWriteServiceAction();
    		forward = action.execute(request, response);
    	}
    	
    	
    	
    	
    	if(forward.isRedirect()) {
    		response.sendRedirect(forward.getPath());
    	}else {
    		
    		RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    		dis.forward(request, response);
    	}
	}
		
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
