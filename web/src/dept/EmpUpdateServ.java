package dept;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpUpdateServ
 */
@WebServlet("/dept/empUpdateServ")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpUpdateServ() {
        super();
        
    }

    //수정페이지 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사번으로 단건조회
		
		//joblist
		
		//부서리스트
		
		//사원리스트
		
		
		//request에 저장
		request.setAttribute("emp", o);
		
		//수정페이지 이동
	}

	//수정처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
