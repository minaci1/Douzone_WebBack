package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;

/*
 * 
Url 방식 (command 방식 상관 없다)
http://192.168.0.46:8090/WebSite/list.do >> *.do 매핑
http://192.168.0.46:8090/WebSite/write.do >> *.do 매핑
  
  
  
Command방식(parameter 업무 파악)
@WebServlet("site*.do")
http://192.168.0.46:8090/WebSite/site.do?cmd=list
http://192.168.0.46:8090/WebSite/site.do.cmd=write
 */

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public FrontRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글
    	request.setCharacterEncoding("UTF-8");
    	//2. 데이터 받기
    	String cmd = request.getParameter("cmd");    	
    	//3. 요청 판단하기 .. 판단에 따른 서비스 실행
    	if(cmd.equals("register")) {
    		// register 라면 회원가입 주세요 >> register.jsp
    		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/register/register.jsp");
    		dis.forward(request, response);
    	}else if(cmd.equals("registerok")){
    		// register ok 라면 회원데이터 받아서 db에 insert 하세요. 그리고 welcome 페이지로 forward
    		RegisterDto dto = new RegisterDto();
    		
    		dto.setId(Integer.parseInt(request.getParameter("id")));
    		dto.setPwd(request.getParameter("pwd"));
    		dto.setEmail(request.getParameter("email"));
    		
    	
    		RegisterDao dao = new RegisterDao();
    		dao.writeOk(dto);
    		
    		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/register/register_welcome.jsp");
    		dis.forward(request, response);
    		
    	}
    	
    	
    	// register ok 라면 회원데이터 받아서 db에 insert 하세요. 그리고 welcome 페이지로 forward 
    	// request 에 회원 id 하고 환영인사 담아서 view 에서 출력 >> register_welcome
    	
    	//4. 데이터 담기
    	//5. 뷰지정
    	//6. 뷰 forward
    	 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doProcess(request,response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
