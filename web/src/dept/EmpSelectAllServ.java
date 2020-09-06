package dept;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpSelectAllServ
 */
@WebServlet("/dept/EmpSelectAll")
public class EmpSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpSelectAllServ() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> empList = dao.selectAll();
		request.setAttribute("empList", empList);
		request.getRequestDispatcher("empSelectAll.jsp")
				.forward(request, response);
		
	}

}
