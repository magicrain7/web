package member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class MemberUpdateServ
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
		
	}

	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO memberVO = new MemberVO();
		MemberVO member = (MemberVO)request.getSession().getAttribute("login");
		
		try {
			BeanUtils.copyProperties(memberVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		if(memberVO.getGender() == null) {
			memberVO.setGender(member.getGender());
		}
		if(memberVO.getJob().equals("")) {
			memberVO.setJob(member.getJob());
		}
		if(memberVO.getMailyn() == null) {
			memberVO.setMailyn(member.getMailyn());
		}
		
		String strHobby = "";
		String[] hobby = request.getParameterValues("hobby");
		if (hobby != null) {
			for (String temp : hobby) {
				strHobby += temp + "/";
			}
		}
		System.out.println(Arrays.toString(hobby));
		memberVO.setHobby(strHobby);
		
		
		if(memberVO.getRegdate() == null) {
			memberVO.setRegdate(member.getRegdate());
		}
		
		MemberDAO.getInstance().update(memberVO);
		response.sendRedirect("memberSelectAll.do");
	}
}
