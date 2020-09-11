package dept;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import common.ConnectionManager;

public class DeptDAO {
	//전역변수, 모든 메서드에서 공통으로 사용되는 변수
	Connection conn;
	PreparedStatement pstmt;
	
	//전체조회 (페이징처리) + 검색조건
	public ArrayList<DeptVO> selectAll(DeptVO deptVO) {
		DeptVO resultVO = null;
		ResultSet rs = null; // 초기화
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String where =" where 1=1";
			if (deptVO.getDepartment_name() != null) {
				where += " and department_name like '%' || ? || '%'";
			}
			
			String sql =  " SELECT A.* FROM( SELECT ROWNUM RN,B.* FROM( " 
						+ " SELECT DEPARTMENT_ID, DEPARTMENT_NAME,MANAGER_ID MGR_ID, LOCATION_ID"
						+ " FROM HR.DEPARTMENTS"
						+ where
						+ " ORDER BY DEPARTMENT_ID"
						+ " ) B ) A WHERE RN BETWEEN ? AND ? ";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1,deptVO.getDepartment_id()); sql문에 물음표 없어서 set도 필요없음.
			int pos = 1;
			if (deptVO.getDepartment_name() != null) {
				pstmt.setString(pos++, deptVO.getDepartment_name());
			}
			pstmt.setInt(pos++,deptVO.getFirst());
			pstmt.setInt(pos++,deptVO.getLast());
			rs = pstmt.executeQuery(); 
			while(rs.next()) {	
				resultVO = new DeptVO();
				resultVO.setDepartment_id(rs.getInt(1));
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
				list.add(resultVO);
			}
		} catch(Exception e) {
			
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return list;
		
	}
	//전체 건수 
		public int count(DeptVO deptVO) {
			int cnt = 0;
			try {
				String where =" where 1=1";
				if (deptVO.getDepartment_name() != null) {
					where += " and department_name like '%' || ? || '%'";
				}
				conn = ConnectionManager.getConnnect();
				String sql = "select count(*) from hr.departments " + where;
				pstmt = conn.prepareStatement(sql);
				int pos =1;
				if (deptVO.getDepartment_name() != null) {
					pstmt.setString(pos++, deptVO.getDepartment_name());
				}
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				cnt = rs.getInt(1);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				ConnectionManager.close(conn);
			}
			return cnt;
		}
	//단건 조회
	public DeptVO selectOne(DeptVO deptVO) {
		DeptVO resultVO = null;
		ResultSet rs = null; // 초기화
		try {
			conn = ConnectionManager.getConnnect();
			String sql = " SELECT DEPARTMENT_ID, DEPARTMENT_NAME,MANAGER_ID mgr_id, LOCATION_ID"
					   + " FROM HR.DEPARTMENTS"
					   + " WHERE DEPARTMENT_ID= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,deptVO.getDepartment_id());
			rs = pstmt.executeQuery(); 
			if(rs.next()) {	//처음 커서 위치는 BOF 
				resultVO = new DeptVO();
				resultVO.setDepartment_id(rs.getInt(1));
				resultVO.setDepartment_name(rs.getString("department_name"));
				resultVO.setManager_id(rs.getInt("mgr_id"));
				resultVO.setLocation_id(rs.getInt("LOCATION_ID"));
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
	public void delete(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "DELETE HR.DEPARTMENTS WHERE DEPARTMENT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, deptVO.getDepartment_name());
			pstmt.setInt(1, deptVO.getDepartment_id());
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 삭제됨");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public void update(DeptVO deptVO) {
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "UPDATE HR.DEPARTMENTS SET DEPARTMENT_NAME = ? WHERE DEPARTMENT_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptVO.getDepartment_name());
			pstmt.setInt(2, deptVO.getDepartment_id());
			pstmt.executeUpdate(); //업데이트할때 괄호안에 안들어감
			int r = pstmt.executeUpdate();
			System.out.println(r + " 건이 수정됨");
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			ConnectionManager.close(null, pstmt, conn);
		}
	}
	
	public void insert(DeptVO deptVO) {
		try {
			//1.DB연결
			conn = ConnectionManager.getConnnect();
			//2.SQL 구문 실행
			String sql = "INSERT INTO HR.DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME)"
						+ "VALUES ("+ deptVO.getDepartment_id() + " ,' " 
									+ deptVO.getDepartment_name() + "')";
			Statement stmt = conn.createStatement(); //예외처리
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
