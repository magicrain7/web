package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class BoardDeleteAjaxServ
 */
@WebServlet("/BoardDeleteAjaxServ")
public class BoardDeleteAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO paramVO = new BoardVO();
		String no = request.getParameter("no");
		paramVO.setNo(no);
		
		BoardVO resultVO = BoardDAO.getInstance().selectOne(paramVO);
		String result = JSONArray.fromObject(resultVO).toString();
		response.getWriter().print(result);
		
		BoardDAO.getInstance().delete(paramVO);
		
	}
}