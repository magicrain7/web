package board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class BoardSelectAllAjaxServ
 */
@WebServlet("/BoardSelectAllAjaxServ")
public class BoardSelectAllAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardSelectAllAjaxServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체조회 Ajax 요청처리(json구조로)
		ArrayList<BoardVO> list = BoardDAO.getInstance().selectAll();
		String result = JSONArray.fromObject(list).toString();
		response.getWriter().print(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
