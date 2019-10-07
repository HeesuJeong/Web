package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean addMember(MemberVO memberVO) {
		String sql = "INSERT INTO members VALUES (?, ?, ?, ? , ?, ?)";
		conn = ConnectionProxy.getConnection();
		int result=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getName());
			pstmt.setString(2, memberVO.getUserid());
			pstmt.setString(3, memberVO.getPwd());
			pstmt.setString(4, memberVO.getEmail());
			pstmt.setString(5, memberVO.getPhone());
			pstmt.setInt(6, memberVO.getAdmin());
			result = pstmt.executeUpdate();   //적용된 행의 개수가 리턴되므로
			//한 행 입력했으므로 1이 리턴되겠지
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return result>0?true:false;
	}

	public MemberVO getMember(String userid) {
		String sql = "SELECT * FROM members WHERE userid = ?";
		conn = ConnectionProxy.getConnection();
		pstmt = null;
		MemberVO memberVO=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery(); //rs라는 화살표가 결과 테이블 맨 위로 올라옴
			//DDL은 execute  DML은 executeUpdate DQL은 executeQuery
			//넥스트하면 한 칸 내려와. 내려갈 수 있으면 true  없으면 false
			if(rs.next()) {
				memberVO=new MemberVO();
				memberVO.setName( rs.getString("name") );
				memberVO.setUserid( rs.getString("userid") );
				memberVO.setPwd( rs.getString("pwd") );
				memberVO.setEmail( rs.getString("email") );
				memberVO.setPhone( rs.getString("phone") );
				memberVO.setAdmin( rs.getInt("admin") );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	return memberVO;
	}

	public List<MemberVO> getMemberList() {
		String sql="SELECT * FROM members";
		conn=ConnectionProxy.getConnection();
		List<MemberVO> memberList = new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO memberVO=new MemberVO();
				memberVO.setName( rs.getString("name") );
				memberVO.setUserid( rs.getString("userid") );
				memberVO.setPwd( rs.getString("pwd") );
				memberVO.setEmail( rs.getString("email") );
				memberVO.setPhone( rs.getString("phone") );
				memberVO.setAdmin( rs.getInt("admin") );
				memberList.add(memberVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return memberList;
	}
	
}
