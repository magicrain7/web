package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class BoardSelectOneAjaxServ
 */
@WebServlet("/BoardSelectOneAjaxServ")
public class BoardSelectOneAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectOneAjaxServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시판번호를 파라미터 받아서 단건조회 결과를 json 변환해서 출력
		//게시글 번호를 파라미터 받아서 단건조회결과 json변환해서 출력
		
		String no = request.getParameter("no");
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(no);
		
		BoardVO resultVO = BoardDAO.getInstance().selectOne(boardVO);
		String result = JSONObject.fromObject(resultVO).toString();
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
