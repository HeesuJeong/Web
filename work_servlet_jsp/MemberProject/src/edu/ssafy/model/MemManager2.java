package edu.ssafy.model;

import java.util.ArrayList;

public class MemManager2 {
//싱글턴 패턴 적용하기
//회원저장 위한 리스트
	private static ArrayList<MemVO> list = new ArrayList<>();
	private static MemManager2 man = new MemManager2();

	// 싱글턴 위해 생성자 private
	private MemManager2() {
	}

	public static MemManager2 getInstance() {
		return man;
	}

	public boolean addMem(String id, String name, String pw, String addr, int age, String tel) {
		list.add(new MemVO(id, name, pw, addr, age, tel));
		return true;
	}

	public boolean delMem(String id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
		return true;
	}
	
	public boolean updateMem(String id, String name, String pw, String addr, int age, String tel) {
		//알아서 하기
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				list.get(i).setName(name);
				list.get(i).setPw(pw);
				list.get(i).setAddr(addr);
				list.get(i).setAge(age);
				list.get(i).setTel(tel);
			}
		}
		return true;
	}
	
	public ArrayList<MemVO> getList(){
		return list;
	}
	public MemVO memInfo(String id) {
		for (MemVO memVO : list) {
			if(memVO.getId().equals(id)) {
				return memVO;
			}
		}
		return null;
	}
	
}
