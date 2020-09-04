package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/dept/DeptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//get:부서등록페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//지역정보
		ArrayList<HashMap<String, String>> locationlist = LocationDAO.getInstance().selectAll();

		request.setAttribute("locationlist", locationlist);
		
		//사원정보(매니저)정보
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.selectAll();
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("deptInsertForm.jsp")
		   .forward(request, response);
		
	}
	
	//post: 부서등록처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deptinsert실행");
		//1. 파라미터를 VO에 담기
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id") ));
		deptVO.setDepartment_name( request.getParameter("department_name") );
		
		//2. 등록처리
		DeptDAO dao = new DeptDAO();
		dao.insert(deptVO);
		
		//3.결과처리
		//4.전체 조회 서블릿페이지로 이동
		response.sendRedirect("deptSelectAll");  //response
	}


}
