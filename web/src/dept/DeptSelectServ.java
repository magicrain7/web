package dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptSelectServ
 */
@WebServlet("/dept/deptSelect")
public class DeptSelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//부서번호 파라미터 조회한 결과를 select.jsp로 forward
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 VO에 담기
		DeptVO paramVO = new DeptVO();
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		paramVO.setDepartment_id(department_id);
		
		//단건조회
		DeptDAO dao = new DeptDAO();
		DeptVO dept = dao.selectOne(paramVO);
		
		//조회결과 request 저장
		request.setAttribute("dept", dept); //deptSelect.jsp에 정한거랑 같아야됨${dept
		
		//view 페이지로 이동(포워드)
		request.getRequestDispatcher("deptSelect.jsp")
			   .forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
