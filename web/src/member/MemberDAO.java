package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ConnectionManager;

public class MemberDAO {

  
	//전역변수, 모든 메서드에서 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null; // 초기화
	
	//싱글톤
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance == null)
			instance=new MemberDAO();
			return instance;
	}
	
	//전체조회
	public ArrayList<MemberVO> selectAll(MemberVO memberVO) {
		MemberVO resultVO = null;
		ResultSet rs = null; // 초기화
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT * FROM MEMBER ORDER BY ID";
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
				resultVO.setHobby(rs.getString(7));
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

		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT * FROM MEMBER WHERE ID= ?";
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
				resultVO.setHobby(rs.getString(7));

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
			String sql = "DELETE FROM MEMBER WHERE ID = ?";
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
			String sql = "UPDATE MEMBER SET PW = ?, JOb = ?, gender = ?, mailyn = ?, "
						+ "reason = ?, hobby = ? WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getPw());
			pstmt.setString(2, memberVO.getJob());
			pstmt.setString(3, memberVO.getGender());
			pstmt.setString(4, memberVO.getMailyn());
			pstmt.setString(5, memberVO.getReason());
			pstmt.setString(6, memberVO.getHobby());
			pstmt.setString(7, memberVO.getId());
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
			String sql = "INSERT INTO MEMBER(id , pw, job, gender, mailyn, reason ,hobby, regdate)" 
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, sysdate )";
		    pstmt = conn.prepareStatement(sql); //예외처리
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPw());
			pstmt.setString(3, memberVO.getJob());
			pstmt.setString(4, memberVO.getGender());
			pstmt.setString(5, memberVO.getMailyn());
			pstmt.setString(6, memberVO.getReason());
			pstmt.setString(7, memberVO.getHobby());
			int r = pstmt.executeUpdate();
			//3.결과 처리
			System.out.println(r + " 건이 처리됨");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//4. 연결해제(DB에 접속 session수는 제한적 그래서 해제해야됨)
			ConnectionManager.close(conn);
			
		}
	}
	
	//select count(id) from member where mailyn ='y'
	public int getMailynCnt() {
		int cnt = 0;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select count(id) from member where mailyn ='y'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			ConnectionManager.close(conn);
		}
		return cnt;
		
	}
	
	//성별 인원수 :select gender, count(id) cnt from member group by gender
	public List<HashMap<String, Object>> getGenderCnt(){
		ResultSet rs = null;
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select count(id) from member where mailyn ='y'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("gender",rs.getString("gender"));
				map.put("cnt",rs.getString("cnt"));
				list.add(map);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
	 
	
}