package dept;

import java.io.IOException;
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
		//사번으로 단건조회
		EmpDAO dao = new EmpDAO();
		EmpVO empVO = new EmpVO();
		
		//joblist
		
		//부서리스트
		
		//사원리스트
		
		
		//request에 저장
		request.setAttribute("");
		
		request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
		//수정페이지 이동
	}

	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
