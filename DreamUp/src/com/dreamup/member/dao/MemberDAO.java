package com.dreamup.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.dreamup.ibatis.SqlMapConfig;
import com.dreamup.member.dto.MemberDTO;
import com.ibatis.sqlmap.client.SqlMapClient;

public class MemberDAO {
	SqlMapClient sqlMap;

	public MemberDAO() {
		sqlMap = SqlMapConfig.getSqlMapInstance();
	}

	// 회원가입 : 다운 ok
	public boolean insert(MemberDTO member) {
		boolean result = false;
		try {
			System.out.println("before insert to member : " + member.toString());
			sqlMap.insert("member.insert", member);

			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 비밀번호 암호화
	public boolean encryptionPwd(String m_password) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.encryptionPwd", m_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 회원탈퇴 : 다운ok
	public boolean delete(String m_id) {
		int result;
		try {
			result = sqlMap.delete("member.delete", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 아이디 찾기  ok
	public String findId(MemberDTO member) {

		String m_id = null;
		try {
			m_id = (String) sqlMap.queryForObject("member.findId", member);
			if(m_id != null){
				return m_id;
			}else{
				System.out.println("이름, 메일 입력값을 확인하세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 비밀번호 재설정 : 다운ok
	public boolean resetPwd(MemberDTO member) {
		int result;
		try {
			result = sqlMap.update("member.resetPwd", member);
			if (result == 1) {
				return true;
			}else{
				System.out.println("이름, 메일, 아이디 입력값을 확인하세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 중복검사 ok
	public boolean IdDuplicationCheck(String m_id) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.IdDuplicationCheck", m_id);
			if(result == 0){
				System.out.println("사용가능한 아이디 입니다.");
			return true;
			}else {
				System.out.println("이미 존재하는 아이디 입니다.\n아이디를 다시 입력해주세요.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 로그인 ok
	public boolean login(MemberDTO member) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.login", member);
			if (result == 1) {
				System.out.println("로그인 성공");
				return true;
			}else{
				//아이디 불일치 or 비번 불일치는 유효성검사인가?
				System.out.println("아이디와 비밀번호를 다시 입력해주세요");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 한번이라도 후원한 적이 있는 사용자가 배송주소를 당사자 주소지로 할 경우
	public boolean supportingCount(String m_id) {
		int result;
		try {
			result = (int) sqlMap.queryForObject("member.supportingCount", m_id);
			if(result==0){
				
			return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 사용자 후원정보 입력시 가입정보가 본인인경우
	public MemberDTO selectOwn(String m_id) {
		MemberDTO member;
		try {
			member = (MemberDTO) sqlMap.queryForObject("member.selectOwn", m_id);
			return member;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 마이페이지 개인 정보 수정 ok
	public boolean updateInfo(MemberDTO member) {
		int result;
		try {
			result = sqlMap.update("member.updateInfo", member);
		if (result == 1) {
			return true;
		  }else{
			  System.out.println("아이디가 일치하지 않습니다.");
		  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// 한번도 후원한 적이 없는 사용자가 사용자 후원정보 입력시 배송주소를 당사자 주소지로 할경우
	public boolean updateSupport(String m_id) {
		int result;
		try {
			result = sqlMap.update("member.updateSupport", m_id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	// project테이블/support테이블에 속하는 멤버 컬럼의 값을 가져오기 위함
	// 사용자 세션 부여시
	public MemberDTO selectMember(int i) {
		MemberDTO member;

		try {
			member = (MemberDTO) sqlMap.queryForObject("member.selectMember", i);
			return member;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 전체 유저 정보 조회 ok
	public List<MemberDTO> listMember() {
		List<MemberDTO> memberList;
		try {
			memberList = sqlMap.queryForList("member.listMember");
			return memberList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
