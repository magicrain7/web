package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServ
 */
@WebServlet({"/member/login","/member/logout"})
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//logout
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate(); //무효화시킴
		response.sendRedirect("../index.jsp");
	}

	//login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.파라미터 VO
		MemberVO memberVO = new MemberVO();
		memberVO.setId(request.getParameter("id"));
		memberVO.setPw(request.getParameter("pw"));
		
		// 2.서비스 처리(DB)
		MemberVO resultVO = MemberDAO.getInstance().selectOne(memberVO);
		
		// 3.결과 저장
		String page = "";
		if(resultVO == null) { //id 없음
			request.setAttribute("errormsg", "해당 id가 없습니다");
			page = "login.jsp";
			
		} else {
			if(memberVO.getPw().equals(resultVO.getPw())) { //로그인 성공
				request.getSession().setAttribute("login", resultVO);
				request.getSession().setAttribute("id", resultVO.getId());
				page = "../index.jsp";  
			} else { //패스워드 불일치
				request.setAttribute("errormsg", "pw 불일치");
				page = "login.jsp";
			}
		}
		
		// 4. 뷰페이지 이동(redirect,forward) 또는 뷰페이지 출력
		request.getRequestDispatcher(page).forward(request, response);
	}

}
