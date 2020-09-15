package member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberInsertServ
 */
@WebServlet("/member/memberInsert")
public class MemberInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//등록페이지이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memberinsert 실행");
		request.getRequestDispatcher("memberInsert.jsp").forward(request, response);
		
	}
	
	//등록처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8"); //post일땐 encoding 넣어야됨
				//1. 파라미터를 VO에 담기
				MemberVO memberVO = new MemberVO();
				/*
				 * memberVO.setId(request.getParameter("id"));
				 * memberVO.setPw(request.getParameter("pw"));
				 * memberVO.setJob(request.getParameter("job"));
				 * memberVO.setGender(request.getParameter("gender"));
				 * memberVO.setMailyn(request.getParameter("mailyn"));
				 * memberVO.setReason(request.getParameter("reason"));
				 * memberVO.setHobby(request.getParameter("hobby"));
				 */
				
				try {
					BeanUtils.copyProperties(memberVO, request.getParameterMap());
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				System.out.println("===========map==========");
				Map<String, String[]> map = request.getParameterMap();
				System.out.println("id=" + map.get("id")[0]);
				
				
				System.out.println("===========names==========");
				Enumeration<String> pnames = request.getParameterNames();
				while(pnames.hasMoreElements()) {
					System.out.println(pnames.nextElement());
				}
				
				//checkbox
				System.out.println("===========values==========");
				String strHobby = "";
				String[] hobby = request.getParameterValues("hobby");
				System.out.println(Arrays.toString(hobby));
				if(hobby != null) {
					for ( String temp : hobby) {
						strHobby += temp +"/";
						
					}
				}
				memberVO.setHobby(strHobby);
				
				//2. DB등록 처리
				MemberDAO dao = new MemberDAO();
				dao.insert(memberVO);
				
				//목록으로 이동
				response.sendRedirect("memberSelectAll");
	}

}
