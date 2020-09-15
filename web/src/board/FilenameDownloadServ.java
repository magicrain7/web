package board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class FilenameDownloadServ
 */

@WebServlet("/board/download.do")
public class FilenameDownloadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터를 VO에 담기
		String filename = request.getParameter("filename");
		//insert경로
		String path = request.getServletContext().getRealPath("/images");
		String realPath = path + "/" + filename;
		File file = new File(realPath);
		String downName = new String(filename.getBytes("utf-8"), "iso-8859-1");
		

		if(! file.exists() ) {
			return;
		}
		
		response.reset();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache;");
		response.setHeader("Expires", "-1;");
		
		FileUtils.copyFile(file, response.getOutputStream());
		
		response.getOutputStream().close();
	}
}
