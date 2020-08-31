package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;

public class MemberDAO {


	//전역변수, 모든 메서드에서 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;
	
	//전체조회
	public ArrayList<MemberVO> selectAll() {
		MemberVO resultVO = null;
		ResultSet rs = null; // 초기화
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT id, pw, job, gender, mailyn, mailyn "
					   + " FROM MEMBER"
					   + " ORDER BY id";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,MemberVO.getDepartment_id()); sql문에 물음표 없어서 set도 필요없음.
			rs = pstmt.executeQuery(); 
			while(rs.next()) {	
				resultVO = new MemberVO();
				resultVO.setId(rs.getString(1));
				resultVO.setPw(rs.getString(2));
				resultVO.setJob(rs.getString(3));
				resultVO.setGender(rs.getString(4));
				resultVO.setMailyn(rs.getString(5));
				resultVO.setReason(rs.getString(6));
				list.add(resultVO);
			}
		} catch(Exception e) {
			
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
		
	}
	//단건 조회
	public MemberVO selectOne(MemberVO memberVO) {
		MemberVO resultVO = null;
		ResultSet rs = null; // 초기화
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT id, pw, job, gender, mailyn, mailyn "
					   + " FROM MEMBER"
					   + " WHERE ID= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,memberVO.getId());
			rs = pstmt.executeQuery(); 
			if(rs.next()) {	//처음 커서 위치는 BOF 
				resultVO = new MemberVO();
				resultVO.setId(rs.getString(1));
				resultVO.setPw(rs.getString(2));
				resultVO.setJob(rs.getString(3));
				resultVO.setGender(rs.getString(4));
				resultVO.setMailyn(rs.getString(5));
				resultVO.setReason(rs.getString(6));

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
	public void delete(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "delete from member where id = ?";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, MemberVO.getDepartment_name());
			pstmt.setString(1, memberVO.getId());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 삭제됨");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	//수정
	public void update(MemberVO memberVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "update board set pw = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPw());
			pstmt.setString(2, memberVO.getId());
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
	public void insert(MemberVO memberVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.SQL 구문 실행
			String sql = "insert into member values = ?, ?, ?, ?, ?, ?, ? ";
			Statement stmt = conn.createStatement(); //예외처리
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPw());
			pstmt.setString(3, memberVO.getJob());
			pstmt.setString(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getMailyn());
			pstmt.setString(6, memberVO.getReason());
			int r = stmt.executeUpdate(sql);
			//3.결과 처리
			System.out.println(r + " 건이 처리됨");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. 연결해제(DB에 접속 session수는 제한적 그래서 해제해야됨)
			ConnectionManager.close(conn);
			
		}
	}
}