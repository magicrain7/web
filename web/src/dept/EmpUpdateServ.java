package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpUpdateServ
 */
@WebServlet("/dept/empUpdate")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdateServ() {
        super();
        
    }

    //수정페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// 부서리스트
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> deptlist = dao.selectAll(null);
		request.setAttribute("deptlist", deptlist);
		// 사원리스트
		List<EmpVO> emplist = EmpDAO.getInstance().selectAll();
		request.setAttribute("emplist", emplist);
		// 사번으로 단건조회
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(request.getParameter("employee_id"));
		emp = EmpDAO.getInstance().selectOne(emp);
		request.setAttribute("emp", emp);

		// 수정페이지 이동
		request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
	}

	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
