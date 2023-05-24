package com.kosa;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(description = "여기는 action.do 에요 ", urlPatterns = { "/action.do"})
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontServletController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get 요청이나, Post 요청 둘 다 doProcess가 처리하게 한다
	
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");

		//3. 요청 판단 로직
	
		if(cmd.equals("greeting")) {
			request.setAttribute("msgobj", new Message()); //객체만들기
			request.setAttribute("msg", new Message().getMessage(cmd)); //객체에 대한 메시지를 받아온다.
		}
 
		RequestDispatcher dis = request.getRequestDispatcher("/view/greeting.jsp");
		dis.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
