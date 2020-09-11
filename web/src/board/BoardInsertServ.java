package board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import common.FileRenamePolicy;

/**
 * Servlet implementation class BoardInsertServ
 */

//파라미터 넘어오는 스트림 값을 바운드리(구분기호)로 잘라서 part배열로 만들어줌 - multipartconfig
@MultipartConfig(location = "c:/upload", maxRequestSize = 1024 * 1024 * 10)
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 인코딩
		request.setCharacterEncoding("utf-8");
		System.out.println("boardinsert 실행");

		// 파라미터 받기
		BoardVO boardVO = new BoardVO();
		boardVO.setPoster(request.getParameter("poster"));
		boardVO.setSubject(request.getParameter("subject"));
		boardVO.setContents(request.getParameter("contents"));

		// 첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);
		String path = request.getServletContext().getRealPath("/images/"); //"c:/upload";
		//part.write(fileName);
		//boardVO.setFilename(fileName);
		
		
		//파일명 중복체크
		File renameFile = FileRenamePolicy.rename(new File(path, fileName));
		part.write(path + "/" + renameFile.getName());
		boardVO.setFilename(renameFile.getName());
		System.out.println(path);
		

		BoardDAO dao = new BoardDAO();
		dao.insert(boardVO);

		// 목록페이지 이동
		response.sendRedirect("boardSelectAll.do");
	}
	
	//파일네임 불러오는 매소드
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
