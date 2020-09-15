package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class BoardSelectOneAjaxServ
 */
@WebServlet("/BoardSelectOneAjaxServ")
public class BoardSelectOneAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글 번호를 파라미터 받아서 단건조회 결과를 json 변환해서 출력
		BoardVO paramVO = new BoardVO();
		String no = request.getParameter("no");
		paramVO.setNo(no);
		
		BoardVO resultVO = BoardDAO.getInstance().selectOne(paramVO);
		String result = JSONArray.fromObject(resultVO).toString();
		response.getWriter().print(result);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
