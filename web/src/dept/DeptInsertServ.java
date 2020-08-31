package dept;

import java.io.IOException;

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
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id") ));
		deptVO.setDepartment_name( request.getParameter("department_name") );
		dao.insert(deptVO);
		
		//전체 조회 서블릿페이지로 이동
		response.sendRedirect("deptSelectAll");  //response
	}

}
