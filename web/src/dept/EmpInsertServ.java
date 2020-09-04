package dept;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class EmpInsertServ
 */
@WebServlet("/dept/empInsert")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpInsertServ() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Job 정보
		List<JobVO> jobList =JobDAO.getInstance().selectAll();
		request.setAttribute("jobList", jobList);
		
		//부서 정보
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> deptList = dao.selectAll(null);
		request.setAttribute("deptList", deptList);
		
		//매니저 정보
		List<EmpVO> mgrList = EmpDAO.getInstance().selectAll();
		request.setAttribute("mgrList", mgrList);
		
		request.getRequestDispatcher("employeeInsert.jsp")
		   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		EmpVO empVO = new EmpVO();
		
		try {
			BeanUtils.copyProperties(empVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		EmpDAO dao = new EmpDAO();
		
		dao.insert(empVO);
		
		//response.sendRedirect();
	}

}
