
package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemManagerImpl implements IMemManager{
//싱글턴 패턴 적용하기
//회원저장 위한 리스트
	private static ArrayList<MemVO> list = new ArrayList<>();
	//private MemManagerImpl man = new MemManagerImpl(); 자기안에서 자기 부르면 스택오버플로우 터져

	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	
	// 싱글턴 위해 생성자 private
	public MemManagerImpl() {
	}

	public boolean addMem(String id, String name, String pw, String addr,int age,  String tel) {
		String str="insert into memberweb(id,name,pw,addr,age,tel)values(?,?,?,?,?,?)";
		boolean res=false;
		try {
			conn=ConnectionProxy.getConnection();
			st=conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, pw);
			st.setString(4, addr);
			st.setInt(5, age);
			st.setString(6, tel);
			st.execute();
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res=false;
		}finally {
			close();
		}
		
		return res;
	}

	public void close() {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean delMem(String id) {
		String str = "delete from memberweb where id = ?";
        boolean res = false;
        try {
        	conn=ConnectionProxy.getConnection();
            st = conn.prepareStatement(str);
            st.setString(1, id);
            st.execute();
            res=true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
        return res;
	}
	
	public boolean updateMem(String id, String name, String pw, String addr,int age, String tel) {
		String str="update memberweb set name=?,pw=?,addr=?,age=?,tel=? where id=?";
		boolean res=true;
		try {
			conn=ConnectionProxy.getConnection();
			st=conn.prepareStatement(str);
			st.setString(1, name);
			st.setString(2, pw);
			st.setString(3, addr);
			st.setInt(4, age);
			st.setString(5, tel);
			st.setString(6, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=false;
		}finally {
			close();
		}
		return res;
	}
	
	public ArrayList<MemVO> getList(){
		String sql="select * from memberweb";
		ArrayList<MemVO> list=new ArrayList<>();
		try {
			conn=ConnectionProxy.getConnection();
			st=conn.prepareStatement(sql);
			rs=st.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				MemVO vo=new MemVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setAddr(rs.getString("addr"));
				vo.setAge(rs.getInt("age"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public MemVO memInfo(String id) {
		 String sql = "select * from memberweb where id=?";
	        MemVO vo = null;
	        try {
	            conn = ConnectionProxy.getConnection();
	            
	            st = conn.prepareStatement(sql);
	            st.setString(1, id);
	            rs = st.executeQuery();
	            if (rs.next()) {
	                vo = new MemVO();
	                vo.setId(rs.getString("id"));
	                vo.setPw(rs.getString("pw"));
	                vo.setName(rs.getString("name"));
	                vo.setAge(rs.getInt("age"));
	                vo.setAddr(rs.getString("addr"));
	                vo.setTel(rs.getString("tel"));
	            }else {
	                return null;
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            close();
	        }
	        return vo;
	}
	public boolean isLogin(String id, String pw) {
		String sql = "select * from memberweb where id=? and pw=?";
		boolean res = false;
		MemVO vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(sql);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			//한명이라도 날라왔다
//			if (rs.next()) {
//				vo = new MemVO();
//				vo.setId(rs.getString("id"));
//				vo.setPw(rs.getString("pw"));
//			} 
//			if(vo!=null) {
//				res = true;
//			}
			rs.last();
			int cnt=rs.getRow();
			if(cnt==1) {
				res=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return res;
	}
}