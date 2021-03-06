package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;


public class BoardDAO {

	//전역변수, 모든 메서드에서 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;
	
	static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null)
			instance = new BoardDAO();
			return instance;
	}
	
	
	//전체조회
	public ArrayList<BoardVO> selectAll() {
		BoardVO resultVO = null;
		ResultSet rs = null; // 초기화
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME "
					   + " FROM DEPARTMENTS"
					   + " ORDER BY NO";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,BoardVO.getDepartment_id()); sql문에 물음표 없어서 set도 필요없음.
			rs = pstmt.executeQuery(); 
			while(rs.next()) {	
				resultVO = new BoardVO();
				resultVO.setNo(rs.getString(1));
				resultVO.setPoster(rs.getString(2));
				resultVO.setSubject(rs.getString(3));
				resultVO.setContents(rs.getString(4));
				resultVO.setLastpost(rs.getString(5));
				resultVO.setViews(rs.getString(6));
				resultVO.setFilename(rs.getString(7));
				list.add(resultVO);
			}
		} catch(Exception e) {
			
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
		
	}
	//단건 조회
	public BoardVO selectOne(BoardVO boardVO) {
		BoardVO resultVO = null;
		ResultSet rs = null; // 초기화
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT NO, POSTER, SUBJECT, CONTENTS, LASTPOST, VIEWS, FILENAME "
					   + " FROM DEPARTMENTS"
					   + " WHERE NO= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardVO.getNo());
			rs = pstmt.executeQuery(); 
			if(rs.next()) {	//처음 커서 위치는 BOF 
				resultVO = new BoardVO();
				resultVO.setNo(rs.getString(1));
				resultVO.setPoster(rs.getString(2));
				resultVO.setSubject(rs.getString(3));
				resultVO.setContents(rs.getString(4));
				resultVO.setLastpost(rs.getString(5));
				resultVO.setViews(rs.getString(6));
				resultVO.setFilename(rs.getString(7));

			}else {
				System.out.println("no data");
			}
		} catch(Exception e) {
			
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return resultVO;
		
	}
	
	//삭제
	public void delete(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from board where no = ?";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, BoardVO.getDepartment_name());
			pstmt.setString(1, boardVO.getNo());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 삭제됨");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	//수정
	public void update(BoardVO boardVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update board set subject = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getSubject());
			pstmt.setString(2, boardVO.getNo());
			pstmt.executeUpdate(); //업데이트할때 괄호안에 안들어감
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 수정됨");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	//insert
	public void insert(BoardVO boardVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			// 보드 번호조회, 업데이트
			String seqSql="select no from seq where tablename = 'board'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(seqSql);
			rs.next();
			int no = rs.getInt(1);
			seqSql="update seq set no = no + 1 where tablename = 'board' ";
			stmt = conn.createStatement();
			
			// 보드번호 업데이트
			stmt.executeUpdate(seqSql);
			
			//pstmt=conn.prepareStatement(sql);  ??
			
			// 게시글 등록
			String sql = "insert into board values (?, ?, ?, ?, ?, ?, ? )";
			//() "+" values()";
			PreparedStatement psmtm = conn.prepareStatement(sql); //예외처리
			pstmt.setInt(1, no);
			pstmt.setString(2, boardVO.getPoster());
			pstmt.setString(3, boardVO.getSubject());
			pstmt.setString(4, boardVO.getContents());
			pstmt.setString(5, boardVO.getLastpost());
			pstmt.setString(6, boardVO.getViews());
			pstmt.setString(7, boardVO.getFilename());
			int r = stmt.executeUpdate(sql);
			
			conn.commit();
			//3.결과 처리
			//System.out.println(r + " 건이 처리됨");
			
		} catch(Exception e) {
			try {
			conn.rollback();
			} catch(SQLException e1) {
			  e.printStackTrace();
			}
		} finally {
			//4. 연결해제(DB에 접속 session수는 제한적 그래서 해제해야됨)
			ConnectionManager.close(conn);
			
		}
	}
}