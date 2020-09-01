package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardInsertServ
 */
@WebServlet("/board/boardInsert.do")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("boardinsert 실행");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNo(request.getParameter("no"));
		boardVO.setPoster(request.getParameter("poster"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContents(request.getParameter("contents"));
		boardVO.setFilename(request.getParameter("file"));
		
		BoardDAO dao = new BoardDAO();
		dao.insert(boardVO);
		
		response.sendRedirect("boardSelectAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
