package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.json.JSONArray;

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
		try {
			BeanUtils.copyProperties(boardVO, request.getParameterMap());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		BoardDAO dao = new BoardDAO();
		dao.insert(boardVO);
		
		//json에서 string 으로 출력
		BoardVO resultVO = BoardDAO.getInstance().selectOne(boardVO);
		String result = JSONArray.fromObject(boardVO).toString();
		response.getWriter().print(result);
	}

}
